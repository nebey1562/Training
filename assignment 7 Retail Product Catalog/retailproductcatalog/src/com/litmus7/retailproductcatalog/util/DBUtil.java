package com.litmus7.retailproductcatalog.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import com.litmus7.retailproductcatalog.exception.DBConnectionException;

public class DBUtil {

	private static String url;
	private static String username;
	private static String password;

	/**
	 * Static initializer block to load database configuration from a properties
	 * file.
	 * 
	 * <p>
	 * This block reads the database connection details such as URL, username, and
	 * password from a properties file at class load time. The file is loaded using
	 * the class loader, and its values are assigned to static fields.
	 * </p>
	 * 
	 * <p>
	 * If the properties file is not found or fails to load, a
	 * {@link RuntimeException} is thrown to prevent the application from running
	 * with invalid or missing DB config.
	 * </p>
	 */
	static {
		try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream(AppConstants.DB_PROPERTIES_FILE)) {
			Properties props = new Properties();
			if (input == null) {
				throw new RuntimeException("Unable to find properties file");
			}
			props.load(input);
			url = props.getProperty(AppConstants.DB_URL_KEY);
			username = props.getProperty(AppConstants.DB_USERNAME_KEY);
			password = props.getProperty(AppConstants.DB_PASSWORD_KEY);

		} catch (IOException e) {
			throw new RuntimeException("Failed to load DB configuration", e);
		}
	}

	/**
	 * Establishes and returns a connection to the database.
	 * 
	 * 
	 * @return a valid {@link Connection} to the database
	 * @throws DBConnectionException if the connection cannot be established
	 */
	public static Connection getConnection() throws DBConnectionException {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new DBConnectionException("Couldn't connect to Database", e);
		}
	}
}
