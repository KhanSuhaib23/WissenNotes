package com.app.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnectionFactory {
	
//	private static Properties props = new Properties();
//	
//	static {
//		
//		try {
//			FileInputStream fis = new FileInputStream("db.properties");
//			props.load(fis);
//			fis.close();
//			//Class.forName(props.getProperty("db.driver"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		} /*catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}*/
//		
//		
//	}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "suhaib";
		String password = "suhaib";

		return DriverManager.getConnection(url, user, password);
	}

}
