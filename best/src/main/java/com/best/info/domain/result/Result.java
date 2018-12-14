package com.best.info.domain.result;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"result\"")
public class Result  implements Serializable {
	
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "resId")
	private String resId;

	@Column(name = "marks")
	private String marks;

	
	
	@Column(name = "subId")
	private String subId;

	@Column(name = "userId")
	private String userId;

	@Column(name = "createDate")
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
