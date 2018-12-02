package com.srm4knowledge.springbootestingexample.services.todo.controllers.common;

import java.util.ArrayList;
import java.util.List;

import com.srm4knowledge.springbootestingexample.services.todo.domain.TodoItem;

import lombok.Data;

@Data
public class ResponseWrapper {

	private String status = "";

	private String errorMessage = "";

	private List<TodoItem> todoItems = new ArrayList<>();

	private ResponseWrapper() {
	}

	public static ResponseWrapper newSuccessInstance() {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setStatus("SUCCESS");
		return responseWrapper;
	}

	public static ResponseWrapper newErrorInstance() {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setStatus("ERROR");
		return responseWrapper;
	}

}
