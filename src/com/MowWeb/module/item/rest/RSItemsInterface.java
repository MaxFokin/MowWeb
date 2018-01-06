package com.MowWeb.module.item.rest;

import com.MowWeb.module.item.*;
import com.google.gson.Gson;
import java.util.List;

public interface RSItemsInterface {
 
	public Gson getGson();
	public String getItem(int itemId);
	public String getAllItems();
	
}