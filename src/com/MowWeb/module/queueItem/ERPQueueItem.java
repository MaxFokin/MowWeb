package com.MowWeb.module.queueItem;

import java.util.LinkedList;
import com.MowWeb.module.item.Item;
import com.google.gson.JsonObject;

public class ERPQueueItem {
/*
 * 
 */
	private LinkedList<Item> taskList;
	private LinkedList<Item> finishedTaskList;
	private JsonObject erpJson;
	
	/**
	 * @return the erpJson
	 */
	public JsonObject getErpJson() {
		return erpJson;
	}

	/**
	 * @param erpJson the erpJson to set
	 */
	public void setErpJson(JsonObject erpJson) {
		this.erpJson = erpJson;
	}

	/**
	 * @return the taskList
	 */
	public LinkedList<Item> getTaskList() {
		return taskList;
	}

	/**
	 * @param taskList the taskList to set
	 */
	public void setTaskList(LinkedList<Item> taskList) {
		this.taskList = taskList;
	}
	
	/**
	 * @return the finishedTaskList
	 */
	public LinkedList<Item> getFinishedTaskList() {
		return finishedTaskList;
	}
	
	/**
	 * @param finishedTaskList the finishedTaskList to set
	 */
	public void setFinishedTaskList(LinkedList<Item> finishedTaskList) {
		this.finishedTaskList = finishedTaskList;
	}
	
	
	
}
