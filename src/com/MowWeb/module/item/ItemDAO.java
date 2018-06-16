package com.MowWeb.module.item;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.MowWeb.connection.mySQLDataSource;
import com.google.gson.annotations.SerializedName;

public class ItemDAO {

	Connection conn = null;
	
	public ItemDAO() {
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
	
	
	public List<Item> getAllItems() {
		String sql = "SELECT * FROM item";
		List<Item> itemList = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
		    rs = stmt.executeQuery(sql);
		    
		    while (rs.next()) {
		    	Item item = new Item();
		    	
		    	item.setKey(rs.getInt("key"));
		    	item.setErpKey(rs.getInt("erp_key"));
		    	item.setSfdcKey(rs.getInt("sf_key"));
		    	item.setStepId(rs.getInt("step_id"));
		    	item.setCreatedDate(rs.getDate("created_date"));
		    	item.setCreatedTime(rs.getTime("created_time"));
		    	item.setContainer(rs.getInt("container_key"));
		    	item.setSyncStatus(rs.getString("sync_status").charAt(0));
		    	item.setDecisionKey(rs.getInt("decision_key"));
    			
		    	itemList.add(item);
		    	
            }
		} catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
	 	} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
	        if (stmt != null) try { stmt.close(); } catch (SQLException e) {e.printStackTrace();}
	 	}
	 	
        return itemList;
	}
	
	public Item getItem(int key) {
		Item item = null;
		String sql = "SELECT * FROM item WHERE item.key = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, key);
		    rs = ps.executeQuery();
		    
		    if (rs.next()) {
		    	item = new Item();
		    	
		    	item.setKey(rs.getInt("key"));
		    	item.setErpKey(rs.getInt("erp_key"));
		    	item.setSfdcKey(rs.getInt("sf_key"));
		    	item.setStepId(rs.getInt("step_id"));
		    	item.setCreatedDate(rs.getDate("created_date"));
		    	item.setCreatedTime(rs.getTime("created_time"));
		    	item.setContainer(rs.getInt("container_key"));
		    	item.setSyncStatus(rs.getString("sync_status").charAt(0));
		    	item.setDecisionKey(rs.getInt("decision_key"));
		    	
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
	 	
        return item;
	}
	
	public String updateItemBuildSQL(int key, HashMap<String,String> set) {
		/*UPDATE item SET erp_key=(int), sf_key=(int), step_id=(int),
		created_date='YYYY-MM-DD', created_time='HH:mm:ss',
			container_key=(int), sync_status=(char), decision_key=(cahr)
				WHERE key=(int)
		 */
		String sql = "UPDATE item SET ";
		String sqlEnd = " WHERE item.key=" + key;
		Iterator it = set.entrySet().iterator();
		
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        sql += pair.getKey() + "='" + pair.getValue() + "', ";
	        it.remove();
	    }

		sql = sql.substring(0, sql.length()-2);
		return sql + sqlEnd;
	}
	
	public boolean updateItem(int key, HashMap<String,String> set) {
		boolean ret = false;
		String sql = updateItemBuildSQL(key, set);
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
		    if (stmt.executeUpdate(sql) == 0)
		    	System.out.println("Nothing To Update");
		    ret = true;
		} catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
	 	} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
	 	}
		
		return ret;
	}
	
	public boolean delItem(int key) {
		boolean ret = false;
		String sql = "DELETE FROM item WHERE item.key = ?";
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
	
}
