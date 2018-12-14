package com.best.info.domain.Feedback;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"feedback\"")
public class Feedback  implements Serializable {
	
	/**
	 * 
	 */



	@Id
	@Column(name = "feeId")
	private String feeId;

	

	@Column(name = "userId")
	private String userId;

	
	
	@Column(name = "feedback")
	private  String feedback;

	@Column(name = "createdDate")
	private String createDate;


	

	@Column(name = "modifiedDate")
	private String modifiedDate;

	@Column(name = "isActive")
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}






	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	

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
		return getSerialversionuid();
	}


}
