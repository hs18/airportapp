/**
 * Product.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.homeshop18.airport.appserver.ws.Response;

public class Product  {
    private Long categoryId;
    private int discount;
    private String imgUrl;
    private String inStock;
    private float mrp;
    private float ourPrice;
    private String pdpImageUrl;
    private Long productId;
	private String productTitle;
    private String promoDesc;
    private String shippingInterval;
    private String videoUrl;
    private String description;
    private String itemType;
    private Item[] items;
    private String[] imgList;
    
    //New
    private String author;
//    private Boolean COD;
//    private String cover;
//    private String createDate;
//    private Integer discountPercentage;
    private String edition;
//    private Long groupId;
    private String isbn;
//    private String isPrefDate;
//    private Float ratings;
//    private Float savePrice;
//    private Float score;
    

    public Product() {
    }

    public Product(
           Long categoryId,
           int discount,
           String imgUrl,
           String inStock,
           float mrp,
           float hs18Price,
           String pdpImageUrl,
           Long productId,
           String productTitle,
           String promoDesc,
           String shippingInterval,
           String videoUrl,
           String description,
           String itemType,
           Item[] items,
           String[] imgList) {
           this.categoryId = categoryId;
           this.discount = discount;
           this.imgUrl = imgUrl;
           this.inStock = inStock;
           this.mrp = mrp;
           this.ourPrice = hs18Price;
           this.pdpImageUrl = pdpImageUrl;
           this.productId = productId;
           this.productTitle = productTitle;
           this.promoDesc = promoDesc;
           this.shippingInterval = shippingInterval;
           this.videoUrl = videoUrl;
           this.description = description;
           this.itemType = itemType;
           this.items = items;
           this.imgList = imgList;
    }


    public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public float getHs18Price() {
		return ourPrice;
	}

	public void setHs18Price(float hs18Price) {
		this.ourPrice = hs18Price;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public String[] getImgList() {
		return imgList;
	}

	public void setImgList(String[] imgList) {
		this.imgList = imgList;
	}


    /**
     * Gets the categoryId value for this Product.
     * 
     * @return categoryId
     */
    public Long getCategoryId() {
        return categoryId;
    }


    /**
     * Sets the categoryId value for this Product.
     * 
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


    /**
     * Gets the imgUrl value for this Product.
     * 
     * @return imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }


    /**
     * Sets the imgUrl value for this Product.
     * 
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    /**
     * Gets the inStock value for this Product.
     * 
     * @return inStock
     */
    public String isInStock() {
        return inStock;
    }
    
    public String getInStock() {
		return inStock;
	}

    /**
     * Sets the inStock value for this Product.
     * 
     * @param inStock
     */
    public void setInStock(String inStock) {
        this.inStock = inStock;
    }


    /**
     * Gets the mrp value for this Product.
     * 
     * @return mrp
     */
    public float getMrp() {
        return mrp;
    }


    /**
     * Sets the mrp value for this Product.
     * 
     * @param mrp
     */
    public void setMrp(float mrp) {
        this.mrp = mrp;
    }


    /**
     * Gets the ourPrice value for this Product.
     * 
     * @return ourPrice
     */
    public float getOurPrice() {
        return ourPrice;
    }


    /**
     * Sets the ourPrice value for this Product.
     * 
     * @param ourPrice
     */
    public void setOurPrice(float ourPrice) {
        this.ourPrice = ourPrice;
    }


    /**
     * Gets the pdpImageUrl value for this Product.
     * 
     * @return pdpImageUrl
     */
    public String getPdpImageUrl() {
        return pdpImageUrl;
    }


    /**
     * Sets the pdpImageUrl value for this Product.
     * 
     * @param pdpImageUrl
     */
    public void setPdpImageUrl(String pdpImageUrl) {
        this.pdpImageUrl = pdpImageUrl;
    }


    /**
     * Gets the productId value for this Product.
     * 
     * @return productId
     */
    public Long getProductId() {
        return productId;
    }


    /**
     * Sets the productId value for this Product.
     * 
     * @param productId
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }


    /**
     * Gets the promoDesc value for this Product.
     * 
     * @return promoDesc
     */
    public String getPromoDesc() {
        return promoDesc;
    }


    /**
     * Sets the promoDesc value for this Product.
     * 
     * @param promoDesc
     */
    public void setPromoDesc(String promoDesc) {
        this.promoDesc = promoDesc;
    }


    /**
     * Gets the shippingInterval value for this Product.
     * 
     * @return shippingInterval
     */
    public String getShippingInterval() {
        return shippingInterval;
    }


    /**
     * Sets the shippingInterval value for this Product.
     * 
     * @param shippingInterval
     */
    public void setShippingInterval(String shippingInterval) {
        this.shippingInterval = shippingInterval;
    }

    /**
     * Gets the videoUrl value for this Product.
     * 
     * @return videoUrl
     */
    public String getVideoUrl() {
        return videoUrl;
    }


    /**
     * Sets the videoUrl value for this Product.
     * 
     * @param videoUrl
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    
    
    /*********************************************/
    /*************New*****************************/

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

//	public Boolean getCOD() {
//		return COD;
//	}
//
//	public void setCOD(Boolean cOD) {
//		COD = cOD;
//	}
//
//	public String getCover() {
//		return cover;
//	}
//
//	public void setCover(String cover) {
//		this.cover = cover;
//	}
//
//	public String getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(String createDate) {
//		this.createDate = createDate;
//	}
//
//	public Integer getDiscountPercentage() {
//		return discountPercentage;
//	}
//
//	public void setDiscountPercentage(Integer discountPercentage) {
//		this.discountPercentage = discountPercentage;
//	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

//	public Long getGroupId() {
//		return groupId;
//	}
//
//	public void setGroupId(Long groupId) {
//		this.groupId = groupId;
//	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

//	public String getIsPrefDate() {
//		return isPrefDate;
//	}
//
//	public void setIsPrefDate(String isPrefDate) {
//		this.isPrefDate = isPrefDate;
//	}
//
//	public Float getRatings() {
//		return ratings;
//	}
//
//	public void setRatings(Float ratings) {
//		this.ratings = ratings;
//	}
//
//	public Float getSavePrice() {
//		return savePrice;
//	}
//
//	public void setSavePrice(Float savePrice) {
//		this.savePrice = savePrice;
//	}
//
//	public Float getScore() {
//		return score;
//	}
//
//	public void setScore(Float score) {
//		this.score = score;
//	}
}