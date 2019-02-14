package com.srm4knowledge.springtodoservice.controllers.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.srm4knowledge.springtodoservice.services.exception.TodoServiceException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TodoServiceException.class)
	protected ResponseEntity<ApiError> handleTodoServiceException(TodoServiceException tse) {

		ApiError error = ApiError.newInstance(HttpStatus.INTERNAL_SERVER_ERROR, tse.getMessage());

		return new ResponseEntity<ApiError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
