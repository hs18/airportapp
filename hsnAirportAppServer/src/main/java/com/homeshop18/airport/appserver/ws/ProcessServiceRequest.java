/**
 * 
 */
package com.homeshop18.airport.appserver.ws;

import com.homeshop18.airport.appserver.ws.Request.HttpRequestHandler;
import com.homeshop18.airport.appserver.ws.Response.PriceInfo;
import com.homeshop18.airport.appserver.ws.Response.ResponseParser;

/**
 * @author Vinay.Mehta
 * 
 */
public class ProcessServiceRequest {

	public static PriceInfo getProductPrice(String productCode) {
		PriceInfo price = null;

		String response = HttpRequestHandler.processHttpRequest(productCode);
		price = ResponseParser.parsePriceJSONResponse(response);
		return price;
	}
}
