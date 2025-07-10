package com.litmus7.retailproductcatalog.exception;

public class ProductDataAccessException extends Exception {
	/**
	 * Constructs a new {@code ProductDataAccessException} with the specified detail
	 * message.
	 * 
	 * @param errorMessage the detail message explaining the data access failure
	 */
	public ProductDataAccessException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Constructs a new {@code ProductDataAccessException} with the specified detail
	 * message and cause.
	 * 
	 * @param errorMessage the detail message explaining the data access failure
	 * @param cause        the underlying cause of the exception
	 */
	public ProductDataAccessException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
