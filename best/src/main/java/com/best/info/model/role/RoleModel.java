package com.best.info.model.role;

import java.io.Serializable;
import java.sql.Date;

public class RoleModel  implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  roleId;
	
	private String roleName;
	
	private boolean isActive;
	
	private Date createDate;
	
	private Date modifiedDate;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
