import connection.*;

public class mainSRV {
	
	public static void main(String[] args) {
		//mySQL Server Connection
		mysqlConnection sqlConn = new mysqlConnection();
		sqlConn.setConnection();
		
		//SFDC Connection
		wscConnection sfdcConn = new wscConnection();
		sfdcConn.setConnection();
	}
}