package com.best.info.domain.options;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"option\"")
public class Option  implements Serializable {
	
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "optId")
	private String optId;

	@Column(name = "qusId")
	private String qusId;

	
	
	@Column(name = "isActive")
	private boolean isActive;

	@Column(name = "opt1")
	private String opt1;
	
	@Column(name = "opt2")
	private String opt2;
	
	@Column(name = "opt3")
	private String opt3;


	

	@Column(name = "rightopt")
	private String rightopt;

	
	public String getOptId() {
		return optId;
	}


	public void setOptId(String optId) {
		this.optId = optId;
	}


	public String getQusId() {
		return qusId;
	}


	public void setQusId(String qusId) {
		this.qusId = qusId;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public String getOpt1() {
		return opt1;
	}


	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}


	public String getOpt2() {
		return opt2;
	}


	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}


	public String getOpt3() {
		return opt3;
	}


	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}


	public String getRightopt() {
		return rightopt;
	}


	public void setRightopt(String rightopt) {
		this.rightopt = rightopt;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
