package com.MowWeb.module.queueItem;

import java.util.LinkedList;
import com.MowWeb.module.item.Item;

public class ERPQueueItem {
/*
 * 
 */
	private LinkedList<Item> taskList;
	private LinkedList<Item> finishedTaskList;
	
	
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
