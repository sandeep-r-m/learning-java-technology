package com.srm4knowledge.springtodoservice.services.exception;

public class TodoServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TodoServiceException() {
		super();
	}

	public TodoServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TodoServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public TodoServiceException(String message) {
		super(message);
	}

	public TodoServiceException(Throwable cause) {
		super(cause);
	}

	public static TodoServiceException newInstance(String message) {
		return new TodoServiceException(message);
	}

}
