package com.litmus7.userregisterationsystem.util;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class DBUtil {

	private static String dbUrl;
	private static String dbUsername;
	private static String dbPassword;

	static {
		try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("db.properties")) {

			if (input == null) {
				throw new RuntimeException("Unable to find db.properties");
			}

			Properties prop = new Properties();
			prop.load(input);

			dbUrl = prop.getProperty("db.url");
			dbUsername = prop.getProperty("db.username");
			dbPassword = prop.getProperty("db.password");

		} catch (Exception e) {
			throw new RuntimeException("Failed to load database properties", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	}
}
