/**
 * 
 */
package com.homeshop18.airport.appserver.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * @author Vinay.Mehta
 * 
 */
@XmlRootElement(name = "product")
@JsonPropertyOrder({"rankid","productTitle","productCode","hs18Price","mrp"})
public class Product {
	int rankid;
	

	boolean resultStatus;
	String statusMsg;
	String productTitle;
	String productCode;

	
	String barCodeImage;
	String tollFreeNumber;
	String videoUrl;
	String logoUrl;

	ArrayList imageUrl;

	int inventory;

	String keyFeature;
	
	 float mrp;
	 float hs18Price;
	 /**
	 * @return the hs18Price
	 */
	 @XmlElement
	public float getHs18Price() {
		return hs18Price;
	}

	/**
	 * @param hs18Price the hs18Price to set
	 */
	public void setHs18Price(float hs18Price) {
		this.hs18Price = hs18Price;
	}

	/**
	 * @return the mrp
	 */
	 @XmlElement
	public float getMrp() {
		return mrp;
	}

	/**
	 * @param mrp the mrp to set
	 */
	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	/**
	 * @return the ourPrice
	 */
	

	
	/**
	 * @return the productTitle
	 */
	@XmlElement
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
	@XmlElement
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
	 * @return the resultStatus
	 */
	@XmlElement
	public boolean isResultStatus() {
		return resultStatus;
	}

	/**
	 * @param resultStatus
	 *            the resultStatus to set
	 */
	public void setResultStatus(boolean resultStatus) {
		this.resultStatus = resultStatus;
	}

	/**
	 * @return the statusMsg
	 */
	@XmlElement
	public String getStatusMsg() {
		return statusMsg;
	}

	/**
	 * @param statusMsg
	 *            the statusMsg to set
	 */
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	

	/**
	 * @return the barCodeImage
	 */
	@XmlElement
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
	 * @return the toolFreeNumber
	 */
	@XmlElement
	public String getTollFreeNumber() {
		return tollFreeNumber;
	}

	/**
	 * @param toolFreeNumber
	 *            the toolFreeNumber to set
	 */
	public void setTollFreeNumber(String toolFreeNumber) {
		this.tollFreeNumber = toolFreeNumber;
	}

	/**
	 * @return the videoUrl
	 */
	@XmlElement
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
	 * @return the imageUrl
	 */
	@XmlElement
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
	 * @return the logoUrl
	 */
	@XmlElement
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


	@XmlElement
	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	@XmlElement
	public String getKeyFeature() {
		return keyFeature;
	}

	public void setKeyFeature(String keyFeature) {
		this.keyFeature = keyFeature;
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
