/**
 * 
 */
package com.homeshop18.airport.appserver.ws.Response;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author Vinay.Mehta
 * 
 */
public class ResponseParser {

	public static PriceInfo parsePriceJSONResponse(String rawResponse) {

		PriceInfo price = null;

		org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();

		Product responseProd;
		try {
			responseProd = mapper.readValue(rawResponse, Product.class);
			price = new PriceInfo();
			System.out.println(responseProd.getOurPrice());
			System.out.println(responseProd.getMrp());

			price.setMrp(responseProd.getMrp());
			price.setOurPrice(responseProd.getOurPrice());

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return price;
	}
}
