package com.homeshop18.airport.appserver.service;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadForm {

	public FileUploadForm() {
	}

	private String title;
	private String categoryid;
	private int rankid;
	private int inventory;
	private String keyfeatures;
	private byte[] brandlogo;
	private byte[] image1;
	private byte[] image2;
	private byte[] image3;
	private byte[] image4;
	private byte[] image5;

	/**
	 * @return the rankid
	 */
	public int getRankid() {
		return rankid;
	}

	/**
	 * @param rankid
	 *            the rankid to set
	 */
	@FormParam("rankid")
	public void setRankid(int rankid) {
		this.rankid = rankid;
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
	@FormParam("inventory")
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the keyfeatures
	 */
	public String getKeyfeatures() {
		return keyfeatures;
	}

	/**
	 * @param keyfeatures
	 *            the keyfeatures to set
	 */
	@FormParam("keyfeatures")
	public void setKeyfeatures(String keyfeatures) {
		this.keyfeatures = keyfeatures;
	}

	/**
	 * @return the brandlogo
	 */
	public byte[] getBrandlogo() {
		return brandlogo;
	}

	/**
	 * @param brandlogo
	 *            the brandlogo to set
	 */
	@FormParam("brandlogo")
	@PartType("application/octet-stream")
	public void setBrandlogo(byte[] brandlogo) {
		this.brandlogo = brandlogo;
	}

	/**
	 * @return the categoryid
	 */
	public String getCategoryid() {
		return categoryid;
	}

	/**
	 * @param categoryid
	 *            the categoryid to set
	 */
	@FormParam("categoryid")
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	@FormParam("title")
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the image2
	 */
	public byte[] getImage2() {
		return image2;
	}

	/**
	 * @param image2
	 *            the image2 to set
	 */
	@FormParam("uploadedFile1")
	@PartType("application/octet-stream")
	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}

	/**
	 * @return the image3
	 */
	public byte[] getImage3() {
		return image3;
	}

	/**
	 * @param image3
	 *            the image3 to set
	 */
	@FormParam("uploadedFile2")
	@PartType("application/octet-stream")
	public void setImage3(byte[] image3) {
		this.image3 = image3;
	}

	/**
	 * @return the image4
	 */
	public byte[] getImage4() {
		return image4;
	}

	/**
	 * @param image4
	 *            the image4 to set
	 */
	@FormParam("uploadedFile3")
	@PartType("application/octet-stream")
	public void setImage4(byte[] image4) {
		this.image4 = image4;
	}

	/**
	 * @return the image5
	 */
	public byte[] getImage5() {
		return image5;
	}

	/**
	 * @param image5
	 *            the image5 to set
	 */
	@FormParam("uploadedFile4")
	@PartType("application/octet-stream")
	public void setImage5(byte[] image5) {
		this.image5 = image5;
	}

	public byte[] getData() {
		return image1;
	}

	@FormParam("uploadedFile")
	@PartType("application/octet-stream")
	public void setData(byte[] data) {
		this.image1 = data;
	}

}