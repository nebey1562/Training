package com.litmus7.userregisterationsystem.dao;

import java.sql.*;
import com.litmus7.userregisterationsystem.dto.User;
import com.litmus7.userregistrationsystem.exception.InvalidAgeException;
import com.litmus7.userregistrationsystem.exception.InvalidEmailException;
import com.litmus7.userregistrationsystem.exception.InvalidPasswordException;
import com.litmus7.userregistrationsystem.exception.UserAlreadyExistsException;
import com.litmus7.userregistrationsystem.exception.UserRegistrationException;
import com.litmus7.userregisterationsystem.utils.DBUtil;

public class UserDAO {

	public void saveUser(User user) throws UserRegistrationException {
		try (Connection conn = DBUtil.getConnection()) {

			if (user.getUsername().trim().isEmpty()) {
				throw new IllegalArgumentException("Username cannot be empty");
			}
			if (user.getAge() < 18 || user.getAge() > 60) {
				throw new InvalidAgeException("Age must be between 18 and 60.");
			}
			if (!user.getEmail().contains("@") || !user.getEmail().contains(".")) {
				throw new InvalidEmailException("Invalid email format. Must contain '@' and '.'");
			}
			if (user.getPassword().length() < 6) {
				throw new InvalidPasswordException("Password Invalid. Must be at least 6 characters.");
			}

			String checkSql = "SELECT COUNT(*) FROM users WHERE email = ?";
			try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
				checkStmt.setString(1, user.getEmail());
				ResultSet rs = checkStmt.executeQuery();
				if (rs.next() && rs.getInt(1) > 0) {
					throw new UserAlreadyExistsException("A user with this email already exists.");
				}
			}

			String insertSql = "INSERT INTO users (username, age, email, password) VALUES (?, ?, ?, ?)";
			try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
				insertStmt.setString(1, user.getUsername());
				insertStmt.setInt(2, user.getAge());
				insertStmt.setString(3, user.getEmail());
				insertStmt.setString(4, user.getPassword());
				insertStmt.executeUpdate();
			}

		} catch (IllegalArgumentException | InvalidAgeException | InvalidEmailException | InvalidPasswordException
				| UserAlreadyExistsException e) {
			throw new UserRegistrationException(e.getMessage(), e);
		} catch (Exception e) {
			throw new UserRegistrationException("An error occurred while registering user.", e);
		}
	}
}
