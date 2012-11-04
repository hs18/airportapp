/**
 * 
 */
package com.homeshop18.airport.appserver.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * @author Vinay.Mehta
 * 
 */
@XmlRootElement(name = "outofstock")
@JsonPropertyOrder({ "productOOS", "productInventoryAvailable" })
public class OOSData {
	boolean productOOS;
	int productInventoryAvailable;
	Product nextProduct;

	public OOSData() {
		productOOS = false;

	}

	/**
	 * @return the productOOS
	 */
	public boolean isProductOOS() {
		return productOOS;
	}

	/**
	 * @param productOOS
	 *            the productOOS to set
	 */
	public void setProductOOS(boolean productOOS) {
		this.productOOS = productOOS;
	}

	/**
	 * @return the nextProduct
	 */

	public Product getNextProduct() {
		return nextProduct;
	}

	/**
	 * @param nextProduct
	 *            the nextProduct to set
	 */
	public void setNextProduct(Product nextProduct) {
		this.nextProduct = nextProduct;
	}

	/**
	 * @return the productInventoryAvailable
	 */
	public int getProductInventoryAvailable() {
		return productInventoryAvailable;
	}

	/**
	 * @param productInventoryAvailable
	 *            the productInventoryAvailable to set
	 */
	public void setProductInventoryAvailable(int productInventoryAvailable) {
		this.productInventoryAvailable = productInventoryAvailable;
	}

}
