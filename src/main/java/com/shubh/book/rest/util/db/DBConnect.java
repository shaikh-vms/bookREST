package com.shubh.book.rest.util.db;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {

	private static DBConnect instance = new DBConnect();
	private static Properties props;
	private static Connection con = null;

	// get properties
	static {
		props = new Properties();
		FileReader fileReader;
		try {
			fileReader = new FileReader("./src/main/resources/db.properties");
			props.load(fileReader);
			// load driver
			Class.forName(props.getProperty("DRIVER"));
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private Connection createConnection() {
		try {
			con = DriverManager.getConnection(props.getProperty("URL"), props.getProperty("USER"),
					props.getProperty("PASSWORD"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}
}
