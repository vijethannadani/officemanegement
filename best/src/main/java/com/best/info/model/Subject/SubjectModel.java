package com.best.info.model.Subject;

import java.io.Serializable;

public class SubjectModel  implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  subId;
	
	private String subName;
	private String cId;
	
	private boolean isActive;
	
	private String createDate;
	
	private String modifiedDate;
	private float cost;

	
	public String getSubId() {
		return subId;
	}


	public void setSubId(String subId) {
		this.subId = subId;
	}


	public String getSubName() {
		return subName;
	}


	public void setSubName(String subName) {
		this.subName = subName;
	}


	public String getcId() {
		return cId;
	}


	public void setcId(String cId) {
		this.cId = cId;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
