package com.MowWeb.connection;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

final public class wscConnection {

	final private SFDCConnData connData = new SFDCConnData();
	private EnterpriseConnection conn;
    final private ConnectorConfig config = new ConnectorConfig();
    
    public EnterpriseConnection setConn(){
        config.setUsername(connData.getUser());
        config.setPassword(connData.getPass() + connData.getToken());

        try {
            this.conn = Connector.newConnection(config);
            return conn;
            
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        
        System.out.println("*** Enterprise Connection ERROR! ***");
        return null;
    }
    
    public void printSettings() {
    		System.out.println("*** SFDC Connection ***");
        System.out.println("\tAuth EndPoint: "+config.getAuthEndpoint());
        System.out.println("\tService EndPoint: "+config.getServiceEndpoint());
        System.out.println("\tUsername: "+config.getUsername());
        System.out.println("\tSessionId: "+config.getSessionId());
    }
    
    public boolean closeConn() {
    		boolean ret = false;
    		
		try {
			this.conn.logout();
			ret = true;
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		
		return ret;
    }
}