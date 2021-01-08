package spencer.revature.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {
	// this class follows singleton design pattern
	private static ConnectionUtil cu = null;
	private static Properties properties;
	
	private ConnectionUtil() {
		properties = new Properties();
		
		try {
			// use the class loader to load the properties file
			// so that we don't have to rely on the file system
			InputStream dbProperties = ConnectionUtil.class.getClassLoader().
					getResourceAsStream("database.properties");
			properties.load(dbProperties);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized ConnectionUtil getConnectionUtil() {
		if (cu == null) {
			cu = new ConnectionUtil();
		}
		return cu;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			// the properties are used to make a connection
			// to the database, so we need the same information
			// that we needed to connect in DBeaver
			
			// registering the postgres JDBC Driver class
			Class.forName(properties.getProperty("drv"));
			conn = DriverManager.getConnection(
						properties.getProperty("url"),
						properties.getProperty("usr"),
						properties.getProperty("psw")
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
