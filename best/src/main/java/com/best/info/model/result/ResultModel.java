package com.best.info.model.result;

import java.io.Serializable;

public class ResultModel  implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  resId;
	
	private String marks;
	
	private String subId;
	
	private String userId;
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	private String modifiedDate;
	private String createDate;
	

	
	public String getResId() {
		return resId;
	}



	public void setResId(String resId) {
		this.resId = resId;
	}



	public String getMarks() {
		return marks;
	}



	public void setMarks(String marks) {
		this.marks = marks;
	}



	public String getSubId() {
		return subId;
	}



	public void setSubId(String subId) {
		this.subId = subId;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getModifiedDate() {
		return modifiedDate;
	}



	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}



	public String getCreateDate() {
		return createDate;
	}



	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
