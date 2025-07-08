package com.litmus7.userregisterationsystem.exception;

public class InvalidEmailException extends Exception {
	public InvalidEmailException(String errorMessage) {
		super(errorMessage);
	}
}
