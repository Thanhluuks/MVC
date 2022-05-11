package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcontext {
	//Method to connect Postgres database for single or multiple instance
	public Connection getConnectio() throws Exception {
 		String url="jdbc:sqlserver://" + serverName +";databaseName="+ dbName +";encrypt = true;trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url,userID,password);
	}
	//Change or update bellow value for connection establish
	private final String serverName ="localhost";
	private final String portNumber = "";
	private final String instance="";//default for signle sql instance
	private final String dbName ="ShoppingDB";
	private final String userID="sa";
	private final String password="admin";
	
	
}
