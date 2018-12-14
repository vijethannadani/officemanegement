package com.best.info.model.Course;

import java.io.Serializable;

public class CourseModel  implements Serializable{

	

	private static final long serialVersionUID = 1L;

	private String  curId;
	
	private String curName;
	
	private String curType;
	
	
	private boolean isActive;
	
	

	public String getCurId() {
		return curId;
	}



	public void setCurId(String curId) {
		this.curId = curId;
	}



	public String getCurName() {
		return curName;
	}



	public void setCurName(String curName) {
		this.curName = curName;
	}



	public String getCurType() {
		return curType;
	}



	public void setCurType(String curType) {
		this.curType = curType;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
