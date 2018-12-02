package com.srm4knowledge.springbootestingexample.services.todo.services.common;

public class TodoServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TodoServiceException() {
	}

	public TodoServiceException(String message) {
		super(message);
	}

	public TodoServiceException(Throwable cause) {
		super(cause);
	}

	public TodoServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public TodoServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
