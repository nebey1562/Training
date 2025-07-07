package com.litmus7.userregisterationsystem.service;

import com.litmus7.userregisterationsystem.dao.UserDAO;
import com.litmus7.userregisterationsystem.dto.User;
import com.litmus7.userregistrationsystem.exception.UserRegistrationException;

public class UserRegistration {

	private UserDAO userDAO = new UserDAO();

	public User registerUser(String username, int age, String email, String password) throws UserRegistrationException {

		User user = new User(username, age, email, password);
		userDAO.saveUser(user);
		return user;
	}
}