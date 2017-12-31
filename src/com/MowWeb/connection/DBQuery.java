package com.MowWeb.connection;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBQuery {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private int updateCnt = 0;
	
	public List<HashMap<String,Object>> execute(String query) {
		
		//get connection from data source pool
		try {
			conn = DataSource.getInstance().getConnection();
			stmt = conn.createStatement();
			
			if (stmt.execute(query)) {
				//TRUE if SELECT
				//FALSE if UPDATE, INSERT, or DELETE statement
		        rs = stmt.getResultSet();
		    } else {
		    	//get update count
		    	updateCnt = stmt.getUpdateCount();
		    }
			
			return ( (rs != null) ? convertResultSetToList(rs) : null ); 
			
		} catch (PropertyVetoException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
	    } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) {e.printStackTrace();}
            if (stmt != null) try { stmt.close(); } catch (SQLException e) {e.printStackTrace();}
            if (conn != null) try { conn.close(); } catch (SQLException e) {e.printStackTrace();}
	    }
		
		return null;
	}
	
	
	public List<HashMap<String,Object>> convertResultSetToList(ResultSet rs) throws SQLException {
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();

	    while (rs.next()) {
	        HashMap<String,Object> row = new HashMap<String, Object>(columns);
	        for(int i=1; i<=columns; ++i) {
	            row.put(md.getColumnName(i),rs.getObject(i));
	        }
	        list.add(row);
	    }

	    return list;
	}
}
