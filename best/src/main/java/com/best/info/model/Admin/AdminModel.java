package com.best.info.model.Admin;

import java.io.Serializable;
import java.sql.Date;

public class AdminModel  implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String adminId;
	private String firstName;
	private String password;
	private String mblnum;
	private boolean isActive;
	private String modifiedDate;
	private String CreatedDate;
	public String getModifiedDate() {
		return modifiedDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	private String emailId;
	private String RoleId;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRoleId() {
		return RoleId;
	}

	public void setRoleId(String roleId) {
		RoleId = roleId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
