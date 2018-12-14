package com.best.info.model.Question;

import java.io.Serializable;

public class QuestionModel  implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  qusId;
	
	private String qusTxt;

	private String  isRightans;
	
	private String subId;
	
	private boolean isActive;
	
	private String createDate;
	
	private String modifiedDate;

	
	public String getQusId() {
		return qusId;
	}


	public void setQusId(String qusId) {
		this.qusId = qusId;
	}


	public String getQusTxt() {
		return qusTxt;
	}


	public void setQusTxt(String qusTxt) {
		this.qusTxt = qusTxt;
	}


	public String getIsRightans() {
		return isRightans;
	}


	public void setIsRightans(String isRightans) {
		this.isRightans = isRightans;
	}


	public String getSubId() {
		return subId;
	}


	public void setSubId(String subId) {
		this.subId = subId;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
