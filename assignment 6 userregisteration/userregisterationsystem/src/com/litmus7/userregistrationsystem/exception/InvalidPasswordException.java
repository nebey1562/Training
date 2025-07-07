package com.litmus7.userregistrationsystem.exception;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String errorMessage) {
		super(errorMessage);
	}
}