package com.best.info.model.Pay;

import java.io.Serializable;

public class PayModel  implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  payId;
	
	private float cost;

	private boolean isActive;
	private String userId;
	
	private String subId;


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public String getPayId() {
		return payId;
	}


	public void setPayId(String payId) {
		this.payId = payId;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getSubId() {
		return subId;
	}


	public void setSubId(String subId) {
		this.subId = subId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
