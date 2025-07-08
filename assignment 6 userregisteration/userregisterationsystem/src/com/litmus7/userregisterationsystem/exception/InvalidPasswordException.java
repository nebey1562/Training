package com.litmus7.userregisterationsystem.exception;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String errorMessage) {
		super(errorMessage);
	}
}