package com.homeshop18.airport.appserver.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationObject {
	
	private static final String VERSION = "1.0.0.0";
	private static final String CONFIG_PROP_FILE_NAME ="/config.properties";
	
	public static String dataSource;
	
	public static String querySelect;
	public static String queryOOSChecker;
	public static String querynewproductselect;
	public static String querydiableOOSProduct;
	public static String queryenableNewProduct;
	public static String queryselectAllProduct;
	public static String priceInfoUrl;
	public static String imageSavedLocation;
	public static String imageSavedBaseUrl;
	private static Properties props;
	private static File propFile;
	
	static {
		
		props = new Properties();
		propFile = new File(ConfigurationObject.class.getResource(
				CONFIG_PROP_FILE_NAME).getFile());
		try {
			props.load(new FileInputStream(propFile));
			dataSource = props.getProperty("datasource");
			
			querySelect = props.getProperty("querySelect");
			querynewproductselect = props.getProperty("newproductselect");
			queryOOSChecker = props.getProperty("ooschecker");
			querydiableOOSProduct = props.getProperty("diableOOSProduct");
			queryenableNewProduct = props.getProperty("enableNewProduct");
			queryselectAllProduct = props.getProperty("selectAllProduct");
			
			priceInfoUrl = props.getProperty("priceinfourl");
			imageSavedLocation = props.getProperty("image_saved_location");
			imageSavedBaseUrl = props.getProperty("image_base_url");
			System.out.println("VERSION :"+ VERSION);
			System.out.println("DataSource :"+ dataSource);
			System.out.println("querySelect :"+ querySelect);
			System.out.println("priceInfoUrl :"+ priceInfoUrl);
			System.out.println("querydiableOOSProduct :"+ querydiableOOSProduct);
			System.out.println("queryenableNewProduct :"+ queryenableNewProduct);
			System.out.println("queryselectAllProduct :"+queryselectAllProduct);
			
			System.out.println("image_saved_location :"+ imageSavedLocation);
			System.out.println("image_saved_location :"+ imageSavedBaseUrl);
			System.out.println("**********************************************************");
			System.out.println("\n");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
