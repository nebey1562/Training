package com.litmus7.userregistrationsystem.exception;

public class InvalidEmailException extends Exception {
	public InvalidEmailException(String errorMessage) {
		super(errorMessage);
	}
}
