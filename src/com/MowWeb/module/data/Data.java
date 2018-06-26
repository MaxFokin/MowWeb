package com.MowWeb.module.data;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Data {
	/* key int(15)
	 * doc_data Json
	 */
	
	@SerializedName("key")
	private int key;
	@SerializedName("doc_data")
	private JsonObject data;
	
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
	 * @return the data
	 */
	public JsonObject getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(JsonObject data) {
		this.data = data;
	}
}
