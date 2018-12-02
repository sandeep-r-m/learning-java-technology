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
import org.springframework.web.bind.annotation.RestController;

import com.srm4knowledge.springbootestingexample.services.todo.controllers.common.ResponseWrapper;
import com.srm4knowledge.springbootestingexample.services.todo.domain.TodoItem;
import com.srm4knowledge.springbootestingexample.services.todo.services.TodoService;
import com.srm4knowledge.springbootestingexample.services.todo.services.common.TodoServiceException;

@RestController
@RequestMapping(path = "/todos", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getTodoItemById(@PathVariable Long id) {

		try {

			TodoItem todItem = todoService.getTodoItemById(id);

			ResponseWrapper responseWrapper = ResponseWrapper.newSuccessInstance();
			responseWrapper.getTodoItems().add(todItem);

			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

		} catch (TodoServiceException e) {

			ResponseWrapper responseWrapper = ResponseWrapper.newErrorInstance();
			responseWrapper.setErrorMessage(e.getMessage());

			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping
	public ResponseEntity<ResponseWrapper> addTodoItem(@RequestBody TodoItem todoItem) {

		try {

			System.out.println("todoItem " + todoItem);

			TodoItem saved = todoService.addTodoItem(todoItem);

			ResponseWrapper responseWrapper = ResponseWrapper.newSuccessInstance();
			responseWrapper.getTodoItems().add(saved);

			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.OK);

		} catch (TodoServiceException e) {

			ResponseWrapper responseWrapper = ResponseWrapper.newErrorInstance();
			responseWrapper.setErrorMessage(e.getMessage());

			return new ResponseEntity<ResponseWrapper>(responseWrapper, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
