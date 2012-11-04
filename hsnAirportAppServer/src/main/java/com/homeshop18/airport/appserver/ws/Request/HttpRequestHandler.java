package com.homeshop18.airport.appserver.ws.Request;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.homeshop18.airport.appserver.configuration.ConfigurationObject;

import java.io.*;

public class HttpRequestHandler {

	// private static String url =
	// "http://localhost:8080/HSNMobileBackend/product/category;marketPlace=1;merchantId=1;appName=M;offset=0;numOfResults=1;id=";

	// public static void main(String[] args) {

	public static String processHttpRequest(String productId) {
		String response = null;

		String url = ConfigurationObject.priceInfoUrl + productId;

		System.out.println("GET URL= " + url);

		// Create an instance of HttpClient.
		HttpClient client = new HttpClient();

		// Create a method instance.
		GetMethod method = new GetMethod(url);

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler(3, false));

		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);

			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			}

			// Read the response body.
			byte[] responseBody = method.getResponseBody();

			// Deal with the response.
			// Use caution: ensure correct character encoding and is not binary
			// data
			response = new String(responseBody);
			System.out.println(response);

		} catch (HttpException e) {
			System.err.println("Fatal protocol violation: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Release the connection.
			method.releaseConnection();
		}
		return new String(response);
	}
}
