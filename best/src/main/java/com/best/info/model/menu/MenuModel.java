package com.best.info.model.menu;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class MenuModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6571816350662122499L;
	private String menuId;
	private String name;
	private MenuTree menuTree;
	private String modifiedDate;
	private String createdDate;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MenuTree getMenuTree() {
		return menuTree;
	}

	public void setMenuTree(MenuTree menuTree) {
		this.menuTree = menuTree;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


}
