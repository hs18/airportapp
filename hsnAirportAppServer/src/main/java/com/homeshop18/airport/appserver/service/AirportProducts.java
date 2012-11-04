/**
 * 
 */
package com.homeshop18.airport.appserver.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.spi.HttpResponse;

import com.homeshop18.airport.appserver.configuration.ConfigurationObject;
import com.homeshop18.airport.appserver.configuration.Constants;
import com.homeshop18.airport.appserver.dao.DatabaseObject;

import com.homeshop18.airport.appserver.dao.DbUtilities;
import com.homeshop18.airport.appserver.model.Product;
import com.homeshop18.airport.appserver.model.OOSData;

import com.homeshop18.airport.appserver.ws.ProcessServiceRequest;
import com.homeshop18.airport.appserver.ws.Response.PriceInfo;

/**
 * @author Vinay.Mehta
 * 
 */
@Path("/airportproducts")
public class AirportProducts {
	@Context
	HttpResponse response;

	/*
	 * REST API to fetch Airport Product based upon RANKID from the configured
	 * Product Database
	 */

	@GET
	@Path("/product/rankid/{id}")
	// @Produces("application/json")
	@Produces("text/plain")
	public String getProducts(@PathParam("id") Integer rankid) {

		Product productData = null;

		/*
		 * get all the data from database based upon rankid
		 */
		DatabaseObject daoObject = DbUtilities.getProductData(rankid,
				Constants.QUERY_STATE_INITIAL_PRODUCT_SELECT);

		System.out.println("Row Id = " + daoObject.getRowid());

		if (daoObject != null && daoObject.getRowid() > 0) {
			productData = new Product();
			DbUtilities.fillFinalProductData(productData, daoObject);

			/*
			 * Fetching Price Information from HS18 Platform at Run time w.r.t
			 * ProductId
			 */
			if (productData.getProductCode() != null
					&& !productData.getProductCode().isEmpty()) {
				PriceInfo priceData = ProcessServiceRequest
						.getProductPrice(productData.getProductCode());

				if (priceData != null) {
					productData.setHs18Price(priceData.getOurPrice());
					productData.setMrp(priceData.getMrp());

				}
			} else {
				productData = null;
				response.setStatus(Response.Status.NO_CONTENT.getStatusCode());
				System.out.println("Product Code is NULL");
			}
			response.setStatus(Response.Status.OK.getStatusCode());
		} else {
			response.setStatus(Response.Status.NO_CONTENT.getStatusCode());
		}

		String jsonResponse = getJSONAsString(productData);

		return "getData(" + jsonResponse + ")";

	}

	@GET
	@Path("/product/osschecker/rankid/{id}")
	@Produces("text/plain")
	public String outOfStockChecker(@PathParam("id") Integer rankid) {

		OOSData dataObj = new OOSData();
		DatabaseObject daoObject_newProd = null;
		/*
		 * 1.Need to check the inventory. If is is ZERO, 2. then we need to
		 * fetch next configured product based upon RANKID 3. Make that product
		 * active for requested RANKID
		 */

		DatabaseObject daoObject = DbUtilities.getProductData(rankid,
				Constants.QUERY_STATE_PRODUCT_OOS_CHECK);
		System.out.println("Product Inventory = " + daoObject.getInventory());
		if (daoObject != null && daoObject.getInventory() == 0) {
			dataObj.setProductOOS(true);
			daoObject_newProd = DbUtilities.getProductData(
					Constants.RANKID_ZERO, Constants.QUERY_STATE_NEW_PRODUCT);
			if (daoObject_newProd != null) {
				dataObj.setNextProduct(new Product());
				DbUtilities.fillFinalProductData(dataObj.getNextProduct(),
						daoObject_newProd);
				/*
				 * Fetching Price Information from HS18 Platform at Run time
				 * w.r.t ProductId
				 */
				PriceInfo priceData = ProcessServiceRequest
						.getProductPrice(dataObj.getNextProduct()
								.getProductCode());

				if (priceData != null) {
					dataObj.getNextProduct().setHs18Price(
							priceData.getOurPrice());
					dataObj.getNextProduct().setMrp(priceData.getMrp());

				}
			}
			DbUtilities.updateDBforProductOOS(rankid,
					daoObject_newProd.getRowid(), daoObject.getRowid());
		}

		dataObj.setProductInventoryAvailable(daoObject.getInventory());
		String jsonResponse = getJSONAsString(dataObj);

		// return dataObj;
		return "getData(" + jsonResponse + ")";
	}

	@GET
	@Path("/product/newproduct")
	@Produces("text/plain")
	public String newProductChecker(@MatrixParam("id") Integer rankid,
			@MatrixParam("prodcode") String productcode) {
		/*
		 * get all the data from database based upon rankid
		 */
		Product productData = null;
		String jsonResponse = null;
		DatabaseObject daoObject = DbUtilities.getProductData(rankid,
				Constants.QUERY_STATE_INITIAL_PRODUCT_SELECT);

		System.out.println("Row Id = " + daoObject.getRowid());

		if (daoObject != null && daoObject.getRowid() > 0) {
			if (daoObject.getProductCode().equalsIgnoreCase(productcode)) {
				System.out
						.println("Product is Same , No new Product is available");
			} else {
				System.out.println("New Product is Available");
				productData = new Product();
				DbUtilities.fillFinalProductData(productData, daoObject);

				/*
				 * Fetching Price Information from HS18 Platform at Run time
				 * w.r.t ProductId
				 */
				if (productData.getProductCode() != null
						&& !productData.getProductCode().isEmpty()) {
					PriceInfo priceData = ProcessServiceRequest
							.getProductPrice(productData.getProductCode());

					if (priceData != null) {
						productData.setHs18Price(priceData.getOurPrice());
						productData.setMrp(priceData.getMrp());

					}
				} else {
					productData = null;
					response.setStatus(Response.Status.NO_CONTENT
							.getStatusCode());
					System.out.println("Product Code is NULL");
				}
				response.setStatus(Response.Status.OK.getStatusCode());
				jsonResponse = getJSONAsString(productData);
			}
		}

		return "getData(" + jsonResponse + ")";
	}

	@GET
	@Path("/product/getall")
	@Produces("text/plain")
	public String getAllProducts() {
		String jsonResponse = null;
		
		jsonResponse = getJSONAsString(DbUtilities.getAllProductData(Constants.QUERY_STATE_SELECT_ALL_PRODUCT));
		
		return jsonResponse;
	}

	@PUT
	@Path("/product/update/inventory")
	@Produces("text/plain")
	public String updateInventory(@MatrixParam("id") Integer rankid,
			@MatrixParam("prodcode") String productcode) {
		String jsonResponse = null;

		return jsonResponse;
	}

	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response uploadFile(@MultipartForm FileUploadForm form) {

		String fileName = ConfigurationObject.imageSavedLocation
				+ form.getCategoryid();
		System.out.println("Image File Name" + fileName);
		String ext = ".png";
		try {
			if (form.getData() != null) {
				writeFile(form.getData(), fileName + ext);
			}
			if (form.getImage2() != null) {
				writeFile(form.getImage2(), fileName + "_2" + ext);
			}
			if (form.getImage3() != null) {
				writeFile(form.getImage3(), fileName + "_3" + ext);
			}
			if (form.getImage4() != null) {
				writeFile(form.getImage4(), fileName + "_4" + ext);
			}
			if (form.getImage5() != null) {
				writeFile(form.getImage5(), fileName + "_5" + ext);
			}

			if (form.getBrandlogo() != null) {
				writeFile(form.getBrandlogo(), fileName + "_BrandLogo" + ext);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("Done");
		String response = "uploadFile is called, Uploaded file name : "
				+ fileName + "\n";
		response += " && title " + form.getTitle() + "\n";
		response += " && Product Cat " + form.getCategoryid() + "\n";
		response += " && RankId " + form.getRankid() + "\n";
		response += " && Inventory " + form.getInventory() + "\n";
		response += " && KeyFeatures " + form.getKeyfeatures() + "\n";

		return Response.status(200).entity(response).build();

	}

	
	
	/*
	 * UTILITES FUNCTIONS
	 */
	// save to somewhere
	private void writeFile(byte[] content, String filename) throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		fop.write(content);
		fop.flush();
		fop.close();

	}

	private String getJSONAsString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonResponse = null;
		try {
			jsonResponse = mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonResponse;
	}

}
