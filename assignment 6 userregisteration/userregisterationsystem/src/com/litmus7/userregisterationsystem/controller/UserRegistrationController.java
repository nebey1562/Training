package com.litmus7.userregisterationsystem.controller;

import com.litmus7.userregisterationsystem.service.UserRegistration;
import com.litmus7.userregisterationsystem.dto.Response;
import com.litmus7.userregisterationsystem.dto.User;
import com.litmus7.userregisterationsystem.exception.DBConnectionException;
import com.litmus7.userregisterationsystem.exception.UserRegistrationException;

public class UserRegistrationController {

	public static final int SUCCESS_CODE = 200;
	public static final int ERROR_CODE = 400;

	private UserRegistration userRegistration = new UserRegistration();

	public Response<User> registerUser(String username, int age, String email, String password){
		Response<User> response = new Response<>();
		if (username == null || email == null || password == null || age <= 0) {
			response.setErrorMessage("Invalid value for parameters");
			response.setStatusCode(ERROR_CODE);
		} else {
			try {
				response.setData(userRegistration.registerUser(username, age, email, password));
				response.setStatusCode(SUCCESS_CODE);
			} catch (UserRegistrationException | DBConnectionException e) {
				response.setErrorMessage(e.getMessage());
				response.setStatusCode(ERROR_CODE);
			}
		}
		return response;
	}
}