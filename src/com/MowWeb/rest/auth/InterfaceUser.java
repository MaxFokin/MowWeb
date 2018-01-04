package com.MowWeb.rest.auth;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;

final class InterfaceUser {
	
	private String user = null;
	private String pass = null;
	private String role = "INTERFACE";
	
	protected InterfaceUser() {
		Gson ConnData = new Gson();
		
		try {
			HashMap jsonData = ConnData.fromJson(new FileReader("ConnData.json"), HashMap.class);
			LinkedTreeMap userData = (LinkedTreeMap) jsonData.get("InterfaceUser");
			
			this.user = userData.get("user").toString();
			this.pass = userData.get("pass").toString();
			
		} catch (FileNotFoundException | JsonSyntaxException | JsonIOException e) {
			e.printStackTrace();
		}
	}
	
	protected String getUser() {
		return this.user;
	}
	
	protected String getPass() {
		return this.pass;
	}
	
	protected String getRole() {
		return this.role;
	}
	
}