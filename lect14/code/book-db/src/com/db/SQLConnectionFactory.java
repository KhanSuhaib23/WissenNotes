package com.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnectionFactory {

	private static Properties props = new Properties();

	static {

		try {
			FileInputStream fis = new FileInputStream("db.properties");
			props.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {

		String url = props.getProperty("db.url");
		String user = props.getProperty("db.user");
		String password = props.getProperty("db.password");

		return DriverManager.getConnection(url, user, password);
	}

}
