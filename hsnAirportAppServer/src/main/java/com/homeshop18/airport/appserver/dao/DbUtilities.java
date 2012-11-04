package com.homeshop18.airport.appserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.homeshop18.airport.appserver.configuration.ConfigurationObject;
import com.homeshop18.airport.appserver.configuration.Constants;
import com.homeshop18.airport.appserver.model.Product;

public class DbUtilities {
	// private static final Logger logger = LoggerFactory
	// .getLogger(DbUtilities.class);

	public static DatabaseObject getProductData(int rankid, int queryState) {
		DatabaseObject daoObject = null;

		ResultSet rset = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String query = null;
		try {
			query = getQuery(queryState);
			conn = DbOperation.getInstance().getConnection();
			if (conn != null) {

				ps = conn.prepareStatement(query);
				ps.setInt(1, rankid);

				System.out.println("Sql Query :" + ps.toString());
				rset = ps.executeQuery();

				System.out.println("rset = " + rset);

				daoObject = new DatabaseObject();
				switch (queryState) {
				case Constants.QUERY_STATE_INITIAL_PRODUCT_SELECT:
				case Constants.QUERY_STATE_NEW_PRODUCT:
					fillProductDetails(rset, daoObject);
					break;
				case Constants.QUERY_STATE_PRODUCT_OOS_CHECK:
					fillOOSCheckerData(rset, daoObject);
					break;

				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			daoObject = null;
		} finally {
			DbOperation.cleanDBResource(conn, ps, rset);
		}
		return daoObject;
	}

	public static ArrayList<Product> getAllProductData(int queryState) {

		ResultSet rset = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String query = null;
		ArrayList<Product> arrProdObj = new ArrayList<Product>();
		try {
			query = getQuery(queryState);
			conn = DbOperation.getInstance().getConnection();
			if (conn != null) {

				ps = conn.prepareStatement(query);

				System.out.println("Sql Query :" + ps.toString());
				rset = ps.executeQuery();
				fillAllProductDetails(rset, arrProdObj);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			arrProdObj = null;
		} finally {
			DbOperation.cleanDBResource(conn, ps, rset);
		}
		return arrProdObj;
	}

	private static String getQuery(int queryState) {
		String query = null;
		switch (queryState) {
		case Constants.QUERY_STATE_INITIAL_PRODUCT_SELECT:
			query = ConfigurationObject.querySelect;
			break;
		case Constants.QUERY_STATE_PRODUCT_OOS_CHECK:
			query = ConfigurationObject.queryOOSChecker;
			break;
		case Constants.QUERY_STATE_NEW_PRODUCT:
			query = ConfigurationObject.querynewproductselect;
			break;
		case Constants.QUERY_STATE_PRODUCT_DISABLE:
			query = ConfigurationObject.querydiableOOSProduct;
			break;
		case Constants.QUERY_STATE_PRODUCT_ENABLE:
			query = ConfigurationObject.queryenableNewProduct;
			break;
		case Constants.QUERY_STATE_SELECT_ALL_PRODUCT:
			query = ConfigurationObject.queryselectAllProduct;
			break;
		}
		return query;

	}

	private static void fillProductDetails(ResultSet aRset,
			DatabaseObject daoObject) {
		try {
			while (aRset.next()) {
				daoObject.setRowid(aRset.getInt("rowid"));
				daoObject.setRankid(aRset.getInt("rankid"));
				daoObject.setProductTitle(aRset.getString("title"));
				daoObject.setProductCode(aRset.getString("productcode"));

				/*
				 * Fetches Images
				 */
				// String[] imgList = new String[5];
				ArrayList<String> imgList = new ArrayList<String>();
				String temp = aRset.getString("imageurl1");
				if (temp != null && !temp.isEmpty()) {
					// imgList[0] = temp;
					imgList.add(temp);
				}
				temp = aRset.getString("imageurl2");
				if (temp != null && !temp.isEmpty()) {
					// imgList[1] = temp;
					imgList.add(temp);
				}
				temp = aRset.getString("imageurl3");
				if (temp != null && !temp.isEmpty()) {
					// imgList[2] = temp;
					imgList.add(temp);
				}
				temp = aRset.getString("imageurl4");
				if (temp != null && !temp.isEmpty()) {
					// imgList[3] = temp;
					imgList.add(temp);
				}
				temp = aRset.getString("imageurl5");
				if (temp != null && !temp.isEmpty()) {
					// imgList[4] = temp;
					imgList.add(temp);
				}

				daoObject.setImageUrl(imgList);

				daoObject.setBarCodeImage(aRset.getString("barcodeimage"));

				daoObject.setVideoUrl(aRset.getString("videourl"));

				daoObject.setLogoUrl(aRset.getString("logourl"));
				daoObject.setTollFreeNumber(aRset.getString("tollfreenumber"));
				daoObject.setInventory(aRset.getInt("inventory"));
				daoObject.setKeyFeature(aRset.getString("keyfeatures"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void fillAllProductDetails(ResultSet aRset,
			ArrayList<Product> arrProdObj) {
		try {
			boolean dataAvailable = false;
			Product prodObj = null;
			while (aRset.next()) {
				prodObj = new Product();
				prodObj.setRankid(aRset.getInt("rankid"));
				prodObj.setProductTitle(aRset.getString("title"));
				prodObj.setProductCode(aRset.getString("productcode"));

				/*
				 * Fetches Images
				 */
				// String[] imgList = new String[5];
				ArrayList<String> imgList = new ArrayList<String>();
				String temp = aRset.getString("imageurl1");
				if (temp != null && !temp.isEmpty()) {
					// imgList[0] = temp;
					imgList.add(temp);
				}
				temp = aRset.getString("imageurl2");
				if (temp != null && !temp.isEmpty()) {
					// imgList[1] = temp;
					imgList.add(temp);
				}
				temp = aRset.getString("imageurl3");
				if (temp != null && !temp.isEmpty()) {
					// imgList[2] = temp;
					imgList.add(temp);
				}
				temp = aRset.getString("imageurl4");
				if (temp != null && !temp.isEmpty()) {
					// imgList[3] = temp;
					imgList.add(temp);
				}
				temp = aRset.getString("imageurl5");
				if (temp != null && !temp.isEmpty()) {
					// imgList[4] = temp;
					imgList.add(temp);
				}

				prodObj.setImageUrl(imgList);

				prodObj.setBarCodeImage(aRset.getString("barcodeimage"));

				prodObj.setVideoUrl(aRset.getString("videourl"));

				prodObj.setLogoUrl(aRset.getString("logourl"));
				prodObj.setTollFreeNumber(aRset.getString("tollfreenumber"));
				prodObj.setInventory(aRset.getInt("inventory"));
				prodObj.setKeyFeature(aRset.getString("keyfeatures"));

				dataAvailable = true;
				arrProdObj.add(prodObj);
			}

			if (!dataAvailable) {
				arrProdObj = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			arrProdObj = null;
			e.printStackTrace();
		}

	}

	private static void fillOOSCheckerData(ResultSet aRset,
			DatabaseObject daoObject) {
		try {
			while (aRset.next()) {
				daoObject.setRowid(aRset.getInt("rowid"));
				daoObject.setInventory(aRset.getInt("inventory"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void fillFinalProductData(Product productData,
			DatabaseObject daoObject) {
		if (daoObject.getProductTitle() != null
				&& !daoObject.getProductTitle().isEmpty()) {
			productData.setProductTitle(daoObject.getProductTitle());
		}
		if (daoObject.getProductCode() != null
				&& !daoObject.getProductCode().isEmpty()) {
			productData.setProductCode(daoObject.getProductCode());
		}
		if (daoObject.getImageUrl() != null) {
			productData.setImageUrl(daoObject.getImageUrl());
		}
		if (daoObject.getBarCodeImage() != null
				&& !daoObject.getBarCodeImage().isEmpty()) {
			productData.setBarCodeImage(daoObject.getBarCodeImage());
		}
		if (daoObject.getVideoUrl() != null
				&& !daoObject.getVideoUrl().isEmpty()) {
			productData.setVideoUrl(daoObject.getVideoUrl());
		}
		if (daoObject.getTollFreeNumber() != null
				&& !daoObject.getTollFreeNumber().isEmpty()) {
			productData.setTollFreeNumber(daoObject.getTollFreeNumber());
		}

		if (daoObject.getKeyFeature() != null
				&& !daoObject.getKeyFeature().isEmpty()) {
			productData.setKeyFeature(daoObject.getKeyFeature());
		}
		if (daoObject.getLogoUrl() != null && !daoObject.getLogoUrl().isEmpty()) {
			productData.setLogoUrl(daoObject.getLogoUrl());
		}

		productData.setRankid(daoObject.getRankid());
		productData.setInventory(daoObject.getInventory());
	}

	public static boolean updateDBforProductOOS(int currRankid, int newRowId,
			int oldRowId) {
		boolean updateQueryStatus = true;
		ResultSet rset = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String query = null;
		try {
			query = getQuery(Constants.QUERY_STATE_PRODUCT_DISABLE);
			conn = DbOperation.getInstance().getConnection();
			if (conn != null) {

				ps = conn.prepareStatement(query);
				ps.setInt(1, oldRowId);

				System.out.println("Sql Query :" + ps.toString());
				int disableProductStatus = ps.executeUpdate();
				System.out.println("Sql Query disableProductStatus:"
						+ disableProductStatus);
				ps.clearBatch();
				ps.clearParameters();

				query = getQuery(Constants.QUERY_STATE_PRODUCT_ENABLE);
				ps = conn.prepareStatement(query);
				ps.setInt(1, currRankid);
				ps.setInt(2, newRowId);

				System.out.println("Sql Query :" + ps.toString());
				int enableProductStatus = ps.executeUpdate();
				System.out.println("Sql Query enableProductStatus:"
						+ enableProductStatus);

			}
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			DbOperation.cleanDBResource(conn, ps, rset);
		}
		return updateQueryStatus;
	}
}
