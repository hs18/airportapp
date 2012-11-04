package com.homeshop18.airport.appserver.dao;

import java.util.ArrayList;

public class DatabaseObject {
	int rowid;
	
	int rankid;
	String productTitle;
	String productCode;
	String barCodeImage;
	String tollFreeNumber;
	String videoUrl;
	String logoUrl;
	String keyFeature;

	ArrayList imageUrl;

	int inventory;

	/**
	 * @return the productTitle
	 */
	public String getProductTitle() {
		return productTitle;
	}

	/**
	 * @param productTitle
	 *            the productTitle to set
	 */
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode
	 *            the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the barCodeImage
	 */
	public String getBarCodeImage() {
		return barCodeImage;
	}

	/**
	 * @param barCodeImage
	 *            the barCodeImage to set
	 */
	public void setBarCodeImage(String barCodeImage) {
		this.barCodeImage = barCodeImage;
	}

	/**
	 * @return the tolllFreeNumber
	 */
	public String getTollFreeNumber() {
		return tollFreeNumber;
	}

	/**
	 * @param tolllFreeNumber
	 *            the tolllFreeNumber to set
	 */
	public void setTollFreeNumber(String tolllFreeNumber) {
		this.tollFreeNumber = tolllFreeNumber;
	}

	/**
	 * @return the videoUrl
	 */
	public String getVideoUrl() {
		return videoUrl;
	}

	/**
	 * @param videoUrl
	 *            the videoUrl to set
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl() {
		return logoUrl;
	}

	/**
	 * @param logoUrl
	 *            the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	/**
	 * @return the keyFeature
	 */
	public String getKeyFeature() {
		return keyFeature;
	}

	/**
	 * @param keyFeature
	 *            the keyFeature to set
	 */
	public void setKeyFeature(String keyFeature) {
		this.keyFeature = keyFeature;
	}

	/**
	 * @return the imageUrl
	 */
	public ArrayList getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(ArrayList imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the inventory
	 */
	public int getInventory() {
		return inventory;
	}

	/**
	 * @param inventory
	 *            the inventory to set
	 */
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	/**
	 * @return the rowid
	 */
	public int getRowid() {
		return rowid;
	}

	/**
	 * @param rowid the rowid to set
	 */
	public void setRowid(int rowid) {
		this.rowid = rowid;
	}

	/**
	 * @return the rankid
	 */
	public int getRankid() {
		return rankid;
	}

	/**
	 * @param rankid the rankid to set
	 */
	public void setRankid(int rankid) {
		this.rankid = rankid;
	}
}
