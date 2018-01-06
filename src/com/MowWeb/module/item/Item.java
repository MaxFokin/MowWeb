package com.MowWeb.module.item;

import java.sql.Date;
import java.sql.Time;

import com.google.gson.annotations.SerializedName;

public class Item {
/*	key int(15) AI PK 
	erp_key int(15) 
	sf_key int(15) 
	step_id int(10) 
	created_date date 
	created_time time 
	container_key int(15) 
	sync_status char(1) 
	decision_key int(3)*/
	
	@SerializedName("key")
	private int key;
	@SerializedName("erp_key")
	private int erpKey;
	@SerializedName("sf_key")
	private int sfdcKey;
	@SerializedName("step_id")
	private int stepId;
	//@TODO Object Step ???
	@SerializedName("created_date")
	private Date createdDate;
	@SerializedName("created_time")
	private Time createdTime;
	@SerializedName("container_key")
	private int container;
	//@TODO Object Container ???
	@SerializedName("sync_status")
	private char syncStatus;
	@SerializedName("decision_key")
	private int decisionKey;
	//@TODO Object Decision ???

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}
	/**
	 * @return the erpKey
	 */
	public int getErpKey() {
		return erpKey;
	}
	/**
	 * @param erpKey the erpKey to set
	 */
	public void setErpKey(int erpKey) {
		this.erpKey = erpKey;
	}
	/**
	 * @return the sfdcKey
	 */
	public int getSfdcKey() {
		return sfdcKey;
	}
	/**
	 * @param sfdcKey the sfdcKey to set
	 */
	public void setSfdcKey(int sfdcKey) {
		this.sfdcKey = sfdcKey;
	}
	/**
	 * @return the stepId
	 */
	public int getStepId() {
		return stepId;
	}
	/**
	 * @param stepId the stepId to set
	 */
	public void setStepId(int stepId) {
		this.stepId = stepId;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the createdTime
	 */
	public Time getCreatedTime() {
		return createdTime;
	}
	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Time createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * @return the container
	 */
	public int getContainer() {
		return container;
	}
	/**
	 * @param container the container to set
	 */
	public void setContainer(int container) {
		this.container = container;
	}
	/**
	 * @return the syncStatus
	 */
	public char getSyncStatus() {
		return syncStatus;
	}
	/**
	 * @param syncStatus the syncStatus to set
	 */
	public void setSyncStatus(char syncStatus) {
		this.syncStatus = syncStatus;
	}
	/**
	 * @return the decisionKey
	 */
	public int getDecisionKey() {
		return decisionKey;
	}
	/**
	 * @param decisionKey the decisionKey to set
	 */
	public void setDecisionKey(int decisionKey) {
		this.decisionKey = decisionKey;
	}
	
}
