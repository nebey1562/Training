package com.litmus7.userregisterationsystem.exception;

public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}

}
