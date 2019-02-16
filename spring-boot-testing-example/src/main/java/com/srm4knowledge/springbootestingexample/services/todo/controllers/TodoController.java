package com.srm4knowledge.springbootestingexample.services.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srm4knowledge.springbootestingexample.services.todo.controllers.common.ResponseWrapper;
import com.srm4knowledge.springbootestingexample.services.todo.domain.TodoItem;
import com.srm4knowledge.springbootestingexample.services.todo.services.TodoService;
import com.srm4knowledge.springbootestingexample.services.todo.services.common.TodoServiceException;

/**
 * Todo Service Controller <br>
 * Exception handling is done by a custom exception handler
 * <code>CustomResponseEntityExceptionHandler.java</code><br>
 * 
 * @author srmmbp
 *
 */
@RestController
@RequestMapping(path = "/todos", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public class TodoController {

	@Autowired
	private TodoService todoService;

	// @RequestMapping(path = "/{id}", method = RequestMethod.GET)
	// @GetMapping(path = "/{id}")
	public ResponseEntity<?> getTodoItemById(@PathVariable Long id) throws TodoServiceException {

		TodoItem todItem = todoService.getTodoItemById(id);

		ResponseWrapper responseWrapper = ResponseWrapper.newSuccessInstance();
		responseWrapper.getTodoItems().add(todItem);

		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ResponseWrapper> addTodoItem(@RequestBody TodoItem todoItem) throws TodoServiceException {

		TodoItem saved = todoService.addTodoItem(todoItem);

		ResponseWrapper responseWrapper = ResponseWrapper.newSuccessInstance();
		responseWrapper.getTodoItems().add(saved);

		return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);
	}

}
