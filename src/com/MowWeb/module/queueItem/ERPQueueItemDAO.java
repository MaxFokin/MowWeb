package com.MowWeb.module.queueItem;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import com.MowWeb.connection.mySQLDataSource;
import com.MowWeb.module.item.Item;
import com.MowWeb.module.item.ItemDAO;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sforce.soap.enterprise.sobject.MowWeb_Item__c;

public class ERPQueueItemDAO {

	Connection conn = null;
	
	public ERPQueueItemDAO() {
		super();
		try {
			this.conn = mySQLDataSource.getInstance().getConnection();
		} catch (PropertyVetoException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
	    }
	}
	
	public void closeConn() {
		if (this.conn != null) try { this.conn.close(); } catch (SQLException e) {e.printStackTrace();}
	}
	
	public boolean handleTaskList(LinkedList<Item> erpQueue) {
		
		boolean ret = false;
		int size = erpQueue.size();
		String sql = "INSERT INTO item (`erp_key`, `sf_key`, `step_id`, `created_date`, "
				+ "`created_time`, `container_key`, `sync_status`, `decision_key`)VALUES ";
		PreparedStatement ps = null;
		Item item = null;
		
		for(int i = 0 ; i < size ; i++) {
			sql += "(?,?,?,?,?,?,?,?),";
		}
		sql = sql.substring(0, sql.length()-1);
		
		try {
			ps = conn.prepareStatement(sql);
			int i = 0;
			while((!erpQueue.isEmpty())) {
				item = erpQueue.getFirst();
				
				ps.setInt(i+1 , item.getErpKey());
				ps.setInt(i+2 , item.getSfdcKey());
				ps.setInt(i+3 , item.getStepId());
				ps.setDate(i+4 , item.getCreatedDate());
				ps.setTime(i+5 , item.getCreatedTime());
				ps.setInt(i+6 , item.getContainer());
				ps.setString(i+7 , String.valueOf(item.getSyncStatus()));
				ps.setInt(i+8, item.getDecisionKey());
				
				i += 8;
				erpQueue.removeFirst();
			}
			ps.executeUpdate();
			
			ret = true;
		} catch (SQLException ex) {
			// handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
	 	} finally {
	        if (ps != null) try { ps.close(); } catch (SQLException e) {e.printStackTrace();}
	 	}
		
		return ret;
	}

	  @SuppressWarnings("resource")
	  public JsonObject jsonGetRequest(String urlQueryString) {
		  String json = null;
		  JsonObject jsonObj = null;
		  
		  try {
			  URL url = new URL(urlQueryString);
			  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			  connection.setDoOutput(true);
			  connection.setInstanceFollowRedirects(false);
			  connection.setRequestMethod("GET");
			  connection.setRequestProperty("Content-Type", "application/json");
			  connection.setRequestProperty("charset", "utf-8");
			  connection.connect();
			  InputStream inStream = connection.getInputStream();
			  json = new Scanner(inStream, "UTF-8").useDelimiter("\\Z").next(); // input stream to string
			  jsonObj = new JsonParser().parse(json).getAsJsonObject();
			  
		  } catch (IOException ex) {
			  ex.printStackTrace();
		  }
	    
		  return jsonObj;
	  }
}
