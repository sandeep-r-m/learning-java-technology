package com.srm4knowledge.springbootestingexample.services.todo.controllers.common;

import lombok.Data;

@Data
public class ExceptionResponse {

	private String status;

	private String errorMessage;

	private String httpErrorMessage;

	private Integer httpErrorCode;

	public static ExceptionResponse newInstance(String status, String errorMessage, String httpErrorMessage,
			Integer httpErrorCode) {
		ExceptionResponse er = new ExceptionResponse();
		er.setStatus(status);
		er.setErrorMessage(errorMessage);
		er.setHttpErrorMessage(httpErrorMessage);
		er.setHttpErrorCode(httpErrorCode);
		return er;
	}

}
