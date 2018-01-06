import com.MowWeb.connection.*;
import com.MowWeb.services.rest.*;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.xml.ws.Endpoint;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public final class mainSRV {
	
	static final wscConnection sfdcConn = new wscConnection();
	static final RSPublisher rsApp = new RSPublisher();
	
	public static void main(String[] args) {
		
		//MySQL c3p0 Connection pool init + Check
		Connection sqlConn = null;
		try {
			sqlConn = mySQLDataSource.getInstance().getConnection();
			
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
		
		//SFDC Connection Test
		sfdcConn.setConnection();
		
		//RESTful Service Publish
		rsApp.run();
	}
}