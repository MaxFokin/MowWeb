package com.MowWeb.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public final class mysqlConnection {
	
	  private Connection conn = null;
	  final private DBConnData dbConnData = new DBConnData();
	  
	  public void setConnection(){
	    try {
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      
	      // Setup the connection with the DB
	      conn = DriverManager.getConnection("jdbc:mysql://"
	    		  		+ dbConnData.getHost() , dbConnData.getUser() , dbConnData.getPass() );
	      System.out.println("SQL connection succeed");
	    
	    } catch (SQLException ex) {
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("VendorError: " + ex.getErrorCode());
	    } catch (Exception ex) {
	    	System.out.println("mysql.jdbc.Driver Error: " + ex.getStackTrace());
	    }
	  }
}