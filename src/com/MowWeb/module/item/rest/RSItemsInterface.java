package com.MowWeb.module.item.rest;

import java.util.HashMap;

import javax.ws.rs.PathParam;

import com.MowWeb.module.item.*;
import com.google.gson.Gson;

public interface RSItemsInterface {
 
	public Gson getGson();
	public String getItem(@PathParam("key") int key);
	public String getAllItems();
	public boolean updateItem(@PathParam("key") int key, HashMap<String,String> jsonBody);
	public boolean delItem(@PathParam("key") int key);
	
}