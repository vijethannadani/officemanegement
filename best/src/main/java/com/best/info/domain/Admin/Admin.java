package com.best.info.domain.Admin;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"admin\"")
public class Admin  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "adminId")
	private String adminId;

	@Column(name = "firstName")
	private String firstName;


	@Column(name = "password")
	private String password;
	
	@Column(name = "isActive")
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}






	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "mblnum")
	private String mblnum;


	@Column(name = "modifiedDate")
	private String modifiedDate;

	@Column(name = "CreatedDate")
	private String CreatedDate;
	
	
	


	
	public String getAdminId() {
		return adminId;
	}






	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}






	public String getFirstName() {
		return firstName;
	}






	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public String getMblnum() {
		return mblnum;
	}






	public void setMblnum(String mblnum) {
		this.mblnum = mblnum;
	}


	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedDate() {
		return CreatedDate;
	}


	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
