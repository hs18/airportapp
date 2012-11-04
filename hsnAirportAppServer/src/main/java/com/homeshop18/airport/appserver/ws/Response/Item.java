/**
 * ItemData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homeshop18.airport.appserver.ws.Response;

public class Item  {
    private Long itemId;
    private String itemValue;
    private String itemName;
    /**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	private Integer itemPrice;

    public Item() {
    }

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Item(Long itemId, String itemValue, Integer itemPrice,String itemName) {
		super();
		this.itemId = itemId;
		this.itemValue = itemValue;
		this.itemPrice = itemPrice;
		this.itemName = itemName;
	}

}
