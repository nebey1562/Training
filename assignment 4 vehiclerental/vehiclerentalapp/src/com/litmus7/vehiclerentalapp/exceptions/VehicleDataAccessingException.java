package com.litmus7.vehiclerentalapp.exceptions;

/**
 * Exception thrown when there is an issue accessing or processing vehicle data,
 * such as reading from a file.
 * 
 * @author Eben
 */
public class VehicleDataAccessingException extends Exception {
	
	/**
     * Constructs a new {@code VehicleDataAccessException} with the specified detail message.
     *
     * @param errorMessage the detail message explaining the reason for the exception
     */
	public VehicleDataAccessingException(String errorMessage) {
		super(errorMessage);
	}

	/**
     * Constructs a new {@code VehicleDataAccessException} with the specified detail message and cause.
     *
     * @param errorMessage the detail message explaining the reason for the exception
     * @param cause the cause of the exception (a {@link Throwable} object)
     */
	public VehicleDataAccessingException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}