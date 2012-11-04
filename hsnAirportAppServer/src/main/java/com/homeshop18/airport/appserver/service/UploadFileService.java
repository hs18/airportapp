package com.homeshop18.airport.appserver.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.homeshop18.airport.appserver.configuration.ConfigurationObject;

@Path("/file")
public class UploadFileService {

	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response uploadFile(@MultipartForm FileUploadForm form) {

		String fileName = ConfigurationObject.imageSavedLocation + form.getCategoryid();
		System.out.println("Image File Name"+ fileName);
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
				+ fileName +"\n";
		response +=" && title " + form.getTitle()+"\n";
		response +=" && Product Cat " + form.getCategoryid()+"\n";
		response +=" && RankId " + form.getRankid()+"\n";
		response +=" && Inventory " + form.getInventory()+"\n";
		response +=" && KeyFeatures " + form.getKeyfeatures()+"\n";
		
		return Response
				.status(200)
				.entity(response).build();

	}

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
}