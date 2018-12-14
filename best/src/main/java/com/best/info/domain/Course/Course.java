package com.best.info.domain.Course;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"course\"")
public class Course  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "curId")
	private String curId;

	@Column(name = "curName")
	private String curName;

	
	@Column(name = "curType")
	private String curType;

	@Column(name = "isActive")
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}






	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
