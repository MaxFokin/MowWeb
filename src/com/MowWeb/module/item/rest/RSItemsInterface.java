package com.MowWeb.module.item.rest;

import com.MowWeb.module.item.*;
import com.google.gson.Gson;

public interface RSItemsInterface {
 
	public Gson getGson();
	public String getItem(int itemId);
	public String getAllItems();
	
}