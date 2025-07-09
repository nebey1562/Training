package com.litmus7.userregisterationsystem.service;

import static com.litmus7.userregisterationsystem.util.AppConstants.EMAIL_REGEX;
import static com.litmus7.userregisterationsystem.util.AppConstants.MAX_AGE;
import static com.litmus7.userregisterationsystem.util.AppConstants.MIN_AGE;
import static com.litmus7.userregisterationsystem.util.AppConstants.MIN_PASSWORD_LENGTH;

import java.util.regex.Pattern;

import com.litmus7.userregisterationsystem.dao.UserDAO;
import com.litmus7.userregisterationsystem.dto.User;
import com.litmus7.userregisterationsystem.exception.DBConnectionException;
import com.litmus7.userregisterationsystem.exception.EmptyUsernameException;
import com.litmus7.userregisterationsystem.exception.InvalidAgeException;
import com.litmus7.userregisterationsystem.exception.InvalidEmailException;
import com.litmus7.userregisterationsystem.exception.UserRegistrationException;
import com.litmus7.userregisterationsystem.exception.WeakPasswordException;

public class UserRegistration {

	private UserDAO userDAO = new UserDAO();

	public User registerUser(String username, int age, String email, String password) throws UserRegistrationException, DBConnectionException {

		try {
			if (username == null || username.trim().isEmpty()) {
				throw new EmptyUsernameException("Username cannot be empty");
			}
			if (age < MIN_AGE || age > MAX_AGE) {
				throw new InvalidAgeException("Age must be between " + MIN_AGE + " and " + MAX_AGE);
			}
			if (!Pattern.matches(EMAIL_REGEX, email)) {
				throw new InvalidEmailException("Invalid email format.");
			}
			if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
				throw new WeakPasswordException("Password must be at least " + MIN_PASSWORD_LENGTH + " characters.");
			}
			User user = new User(username, age, email, password);
			userDAO.saveUser(user);
			return user;
		} catch (IllegalArgumentException | EmptyUsernameException | InvalidAgeException | InvalidEmailException
				| WeakPasswordException e) {
			throw new UserRegistrationException(((Throwable) e).getMessage());
		}

	}
}