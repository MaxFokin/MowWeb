package com.MowWeb.module.container;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.MowWeb.connection.mySQLDataSource;

public class ContainerDAO {
	
	Connection conn = null;
	
	public ContainerDAO() {
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
	
	public Container getContainer(int key) {
		Container container = null;
		String sql = "SELECT * FROM item WHERE dataContainer.key = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, key);
		    rs = ps.executeQuery();
		    
		    if (rs.next()) {
		    	container = new Container();
		    	
		    	container.setKey(rs.getInt("key"));
		    	container.setDataKey(rs.getInt("data_key"));
		    	container.setType(rs.getString("type"));
		    }
		} catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
	 	} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
	        if (ps != null) try { ps.close(); } catch (SQLException e) {e.printStackTrace();}
	 	}
	 	
        return container;
	}

	public boolean updateContainer(Container container) {
		//UPDATE dataContainer SET `data_key`='4' WHERE `key`='1'
		boolean ret = false;
		String sql = "UPDATE dataContainer SET `data_key`=' " + container.getDataKey() + "' WHERE `key`='" + container.getKey() + "'";
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
