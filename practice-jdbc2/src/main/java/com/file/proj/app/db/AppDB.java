package com.file.proj.app.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class AppDB {

	private static Connection connection = null;

	private AppDB() {

	}

	private static void createConnection() {

		try {
			FileInputStream stream = new FileInputStream("src/main/resources/db.properties");
			Properties prop = new Properties();
			prop.load(stream);
			
			Class.forName(prop.getProperty("mysql.driver"));

			
			connection = DriverManager.getConnection(prop.getProperty("mysql.url"),
													 prop.getProperty("mysql.user"),
													 prop.getProperty("mysql.password"));

		} catch (Exception ex) {
			System.out.println("Business logic issue..");
		} 
	}

	public static Connection getConnection() {
		if(connection==null) {
			createConnection();
		}
		
		return connection;
	}

}
