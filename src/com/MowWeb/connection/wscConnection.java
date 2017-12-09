package com.MowWeb.connection;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

final public class wscConnection {

	final private SFDCConnData connData = new SFDCConnData();
	private EnterpriseConnection conn;
    final private ConnectorConfig config = new ConnectorConfig();
    
    public void setConnection(){
        config.setUsername(connData.getUser());
        config.setPassword(connData.getPass() + connData.getToken());

        try {
            this.conn = Connector.newConnection(config);

            // display some current settings
            System.out.println("Auth EndPoint: "+config.getAuthEndpoint());
            System.out.println("Service EndPoint: "+config.getServiceEndpoint());
            System.out.println("Username: "+config.getUsername());
            System.out.println("SessionId: "+config.getSessionId());

        } catch (ConnectionException e1) {
            e1.printStackTrace();
        }
    }
}