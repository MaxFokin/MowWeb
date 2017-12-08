package connection;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

final public class wscConnection {

	static final String USERNAME = "";
    static final String PASSWORD = "";
    static EnterpriseConnection connection;

    public static void main(String[] args) {

        ConnectorConfig config = new ConnectorConfig();
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);

        try {

            connection = Connector.newConnection(config);

            // display some current settings
            System.out.println("Auth EndPoint: "+config.getAuthEndpoint());
            System.out.println("Service EndPoint: "+config.getServiceEndpoint());
            System.out.println("Username: "+config.getUsername());
            System.out.println("SessionId: "+config.getSessionId());

        } catch (ConnectionException e1) {
            e1.printStackTrace();
        } 
    }	
	
/*	private Connection conn = null;
	final private SFDCConnData dbConnData = new SFDCConnData();
	
	public void setConnection(){
		try {
		      // This will load the SFDC driver, each DB has its own driver
		      Class.forName("com.sforce.ws.tools.wsdlc");
		
		      // Setup the connection with SFDC
		      conn = DriverManager.getConnection("jdbc:mysql://"
		    		  		+ dbConnData.getHost() , dbConnData.getUser() , dbConnData.getPass() );
		      System.out.println("SQL connection succeed");
		}
		catch (SQLException ex) {
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("VendorError: " + ex.getErrorCode());
	    } catch (Exception ex) {
	    	System.out.println("mysql.jdbc.Driver Error: " + ex.getStackTrace());
	    }
	}
*/	
}