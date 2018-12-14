package com.best.info.domain.Question;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"question\"")
public class Question  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "qusId")
	private String qusId;

	@Column(name = "qusTxt")
	private String qusTxt;

	
	@Column(name = "isRightans")
	private String isRightans;

	@Column(name = "subId")
	private String subId;
	
	
	
	
	@Column(name = "isActive")
	private boolean isActive;

	public String getQusId() {
		return qusId;
	}

	public void setQusId(String qusId) {
		this.qusId = qusId;
	}

	public String getQusTxt() {
		return qusTxt;
	}

	public void setQusTxt(String qusTxt) {
		this.qusTxt = qusTxt;
	}

	public String getIsRightans() {
		return isRightans;
	}

	public void setIsRightans(String isRightans) {
		this.isRightans = isRightans;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
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

	@Column(name = "createdDate")
	private String createDate;


	

	@Column(name = "modifiedDate")
	private String modifiedDate;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
