package com.best.info.domain.Pay;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Payment\"")
public class Pay  implements Serializable {
	
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "payId")
	private String payId;

	@Column(name = "cost")
	private float cost;

	
	
	@Column(name = "userId")
	private String userId;

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

	

	public String getPayId() {
		return payId;
	}




	public void setPayId(String payId) {
		this.payId = payId;
	}




	public float getCost() {
		return cost;
	}




	public void setCost(float cost) {
		this.cost = cost;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
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
