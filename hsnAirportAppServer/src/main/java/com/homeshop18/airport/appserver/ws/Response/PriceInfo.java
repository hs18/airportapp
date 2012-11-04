/**
 * 
 */
package com.homeshop18.airport.appserver.ws.Response;

/**
 * @author Vinay.Mehta
 *
 */
public class PriceInfo {
	private float mrp;
	private float ourPrice;
    public float getMrp() {
		return mrp;
	}
	public void setMrp(float mrp) {
		this.mrp = mrp;
	}
	public float getOurPrice() {
		return ourPrice;
	}
	public void setOurPrice(float ourPrice) {
		this.ourPrice = ourPrice;
	}
	
}
