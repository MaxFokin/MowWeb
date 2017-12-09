package com.MowWeb.connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;

final class SFDCConnData {	
	
	final private LinkedTreeMap ConnData;
	final private ConnDataHandle ConnJson = new ConnDataHandle();
	  
	protected SFDCConnData() {
		LinkedTreeMap ConnData = ConnJson.getKey("SFDC");
		this.ConnData = ConnData;
	}
	
	protected String getUser() {
		return this.ConnData.get("user").toString();
	}
	
	protected String getPass() {
		return this.ConnData.get("pass").toString();
	}
	
	protected String getToken() {
		return this.ConnData.get("token").toString();
	}
}