package com.best.info.model.user;

import java.io.Serializable;

public class UserModel  implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  userId;
	
	private String firstName;
	
	private String lastName;
	private String password;
	private String phnum;
	private String email;
	private String roleId;
	private   boolean isActive;
	private String adminId;
 
	
	private String createDate;
	
	private String modifiedDate;

	

	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPhnum() {
		return phnum;
	}



	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getRoleId() {
		return roleId;
	}



	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public String getAdminId() {
		return adminId;
	}



	public void setAdminId(String adminId) {
		this.adminId = adminId;
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
