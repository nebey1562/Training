package com.litmus7.userregisterationsystem.exception;

public class UserRegistrationException extends Exception {

	public UserRegistrationException(String errorMessage) {
		super(errorMessage);
	}

	public UserRegistrationException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

}
