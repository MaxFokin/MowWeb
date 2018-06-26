package com.MowWeb.module.container;

import com.google.gson.annotations.SerializedName;

public class Container {
	/* key int(15)
	 * type varchar(8)
	 * data_key int(15)
	 */
	
	@SerializedName("key")
	private int key;
	@SerializedName("type")
	private String type;
	@SerializedName("data_key")
	private int data;
	
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the dataKey
	 */
	public int getDataKey() {
		return data;
	}
	/**
	 * @param dataKey the dataKey to set
	 */
	public void setDataKey(int data) {
		this.data = data;
	} 
}
