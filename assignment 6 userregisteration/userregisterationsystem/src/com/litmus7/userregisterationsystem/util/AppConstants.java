package com.litmus7.userregisterationsystem.util;

public class AppConstants {
	
	public static final int MIN_AGE = 18;
	public static final int MAX_AGE = 60;
	public static final int MIN_PASSWORD_LENGTH = 6;
	
	public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
	
	public static final String CHECK_SQL = "SELECT COUNT(*) FROM users WHERE email = ?";
	public static final String INSERT_SQL = "INSERT INTO users (username, age, email, password) VALUES (?, ?, ?, ?)";
	
	AppConstants() {}
}
