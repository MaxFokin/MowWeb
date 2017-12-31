import com.MowWeb.connection.*;
import com.MowWeb.webService.*;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.xml.ws.Endpoint;

public final class mainSRV {
	
	static final wscConnection sfdcConn = new wscConnection();
	
	public static wscConnection get_sfdcConn() {
		return sfdcConn;
	}
	
	public static void main(String[] args) {
		
		//MySQL c3p0 Connection pool init + Check
		Connection sqlConn = null;
		try {
			sqlConn = DataSource.getInstance().getConnection();
			
			System.out.println("*** SQL Connection Succeed ***");
		} catch (PropertyVetoException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
	    } finally {
	    	if (sqlConn != null) try { sqlConn.close(); } catch (SQLException e) {e.printStackTrace();}
	    }
		
		//SFDC Connection
		sfdcConn.setConnection();
		
		//WebService Publish
		Endpoint.publish("http://localhost:8080/WS",new WSImpl());
		System.out.println("*** WebService Has Started ***\n\t@ http://localhost:8080/WS");
	}
}