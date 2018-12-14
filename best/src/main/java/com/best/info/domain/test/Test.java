package com.best.info.domain.test;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"test\"")
public class Test  implements Serializable {
	
	/**
	 * 
	 */


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "testId")
	private String testId;

	@Column(name = "testName")
	private String testName;

	
	
	@Column(name = "testdue")
	private Time testdue;

	@Column(name = "subId")
	private String subId;


	
	@Column(name = "isActive")
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}






	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getTestId() {
		return testId;
	}


	public void setTestId(String testId) {
		this.testId = testId;
	}


	public String getTestName() {
		return testName;
	}


	public void setTestName(String testName) {
		this.testName = testName;
	}


	public Time getTestdue() {
		return testdue;
	}


	public void setTestdue(Time testdue) {
		this.testdue = testdue;
	}


	public String getSubId() {
		return subId;
	}


	public void setSubId(String subId) {
		this.subId = subId;
	}


	public String getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	@Column(name = "modifiedDate")
	private String modifiedDate;

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
