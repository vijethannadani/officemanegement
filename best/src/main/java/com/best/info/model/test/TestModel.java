package com.best.info.model.test;

import java.io.Serializable;
import java.sql.Time;

public class TestModel  implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String  testId;
	
	private String testName;
	

	
	private Time testdue;
	
	private String subId;
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



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
