package com.best.info.model.Feedback;

import java.io.Serializable;

public class FeedbackModel  implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  feeId;
	private String  userId;
	
	private String feedback;
	
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	private String createDate;
	
	private String modifiedDate;

	
	public String getFeeId() {
		return feeId;
	}


	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
