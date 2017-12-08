import connection.*;

public class mainSRV {
	
	public static void main(String[] args) {
		mysqlConnection sqlConn = new mysqlConnection();
		sqlConn.setConnection();
		
		wscConnection sfdcConn = new wscConnection();
		sfdcConn.setConnection();
	}
}