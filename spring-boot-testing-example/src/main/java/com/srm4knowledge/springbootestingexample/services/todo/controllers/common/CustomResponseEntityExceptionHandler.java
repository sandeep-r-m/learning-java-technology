package com.srm4knowledge.springbootestingexample.services.todo.controllers.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.srm4knowledge.springbootestingexample.services.todo.services.common.TodoServiceException;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public CustomResponseEntityExceptionHandler() {
		super();
	}

	@ExceptionHandler(value = TodoServiceException.class)
	public final ResponseEntity<ExceptionResponse> handleServiceException(TodoServiceException e, WebRequest request) {

		ExceptionResponse response = ExceptionResponse.newInstance("ERROR", e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
