package com.MowWeb.module.data;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.MowWeb.connection.mySQLDataSource;
import com.google.gson.JsonObject;

public class DataDAO {

	Connection conn = null;
	
	public DataDAO() {
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
	
	public Data getData(int key) {
		
		Data data = null;
		String sql = "SELECT * FROM data WHERE data.key = " + key;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				data = new Data();
				
				//data.setData(rs.getString("doc_data"));
			}
		} catch (SQLException ex) {
			 // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
	        if (ps != null) try { ps.close(); } catch (SQLException e) {e.printStackTrace();}
	 	}
		
		return data;
	}
	
	public boolean insertData(Data data) {
		
		boolean ret = false;
		PreparedStatement ps = null;
		String sql = "INSERT INTO data (`key`";
		
		if(data.getData() == null) {
			sql += ") VALUES ('" + data.getKey() + "')";
		}
		else {
			sql += ",`doc_data`) VALUES ('" + data.getKey() + "','" + data.getData() + "')";
		}
		
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 0)
		    	System.out.println("Key Not Found");
			else
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
	
	public boolean deleteData(int key) {
		boolean ret = false;
		String sql = "DELETE FROM data WHERE data.key = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, key);
			
			if (ps.executeUpdate() == 0)
		    	System.out.println("Key Not Found");
			else
				ret = true;
		} catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
	 	} finally {
	        if (ps != null) try { ps.close(); } catch (SQLException e) {e.printStackTrace();}
	 	}
		
		return ret;
	}
	
	public boolean updateData(int key , JsonObject json) {
		boolean ret = false;
		String sql = "UPDATE data SET `doc_data`='" + json + "' WHERE `key`='" + key + "'";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			if (ps.executeUpdate() == 0)
		    	System.out.println("Key Not Found");
			else
				ret = true;
		} catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
	 	} finally {
	        if (ps != null) try { ps.close(); } catch (SQLException e) {e.printStackTrace();}
	 	}
		
		return ret;
	}
	
}
