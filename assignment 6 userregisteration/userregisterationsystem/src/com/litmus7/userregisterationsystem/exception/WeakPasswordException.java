package com.litmus7.userregisterationsystem.exception;

public class WeakPasswordException extends Exception {
	public WeakPasswordException(String errorMessage) {
		super(errorMessage);
	}
}