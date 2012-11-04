/**
 * 
 */
package com.homeshop18.airport.appserver.model;

import javax.ws.rs.FormParam;

/**
 * @author Vinay.Mehta
 *
 */
public class ProductData {
	 @FormParam("title") private String title;
	 private byte[] data;
	 /**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	@FormParam("code") private String code;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	 @FormParam("file")
	    public void setContentData(byte[] data) {
	        this.data = data;
	    }

	    public byte[] getData() {
	        return data;
	    }
}
