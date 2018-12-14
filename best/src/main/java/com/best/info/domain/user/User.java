package com.best.info.domain.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "userId")
	private String userId;

	@Column(name = "firstName")
	private String firstName;

	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phnum")
	private String phnum;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "roleId")
	private String roleId;
	
	@Column(name = "isActive")
	private boolean isActive;

	@Column(name = "createDate")
	private String createDate;


	@Column(name = "modifiedDate")
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
