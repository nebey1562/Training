package com.litmus7.retaildiscountsystem.dto;

/**
 * Generic Response class for wrapping API or service responses.
 * <p>
 * This class holds a status code, error message (if any), and response data of
 * a generic type.
 * </p>
 * 
 * @param <T> The type of the response data
 * 
 *            Author: Eben
 */
public class Response<T> {

	private int statusCode;
	private String errorMessage;
	private T data;

	/**
	 * Gets the status code of the response.
	 * 
	 * @return The status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code of the response.
	 * 
	 * @param statusCode The status code to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the error message of the response, if any.
	 * 
	 * @return The error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message of the response.
	 * 
	 * @param errorMessage The error message to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the response data.
	 * 
	 * @return The response data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the response data.
	 * 
	 * @param data The response data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
}
