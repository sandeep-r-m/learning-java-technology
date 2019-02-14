package com.srm4knowledge.springtodoservice.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm4knowledge.springtodoservice.controllers.common.DomainToResourceMapper;
import com.srm4knowledge.springtodoservice.controllers.common.ResourceToDomainMapper;
import com.srm4knowledge.springtodoservice.controllers.model.TodoItemResource;
import com.srm4knowledge.springtodoservice.controllers.model.TodoItemsResource;
import com.srm4knowledge.springtodoservice.controllers.model.TodoUserResource;
import com.srm4knowledge.springtodoservice.repositories.domain.TodoItem;
import com.srm4knowledge.springtodoservice.services.TodoService;

@RestController
@RequestMapping(path = "/todo", produces = { MediaType.APPLICATION_JSON_VALUE })
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping(path = "/{userId}")
	public ResponseEntity<TodoItemsResource> fetchByUserId(@PathVariable("userId") long userId) {

		List<TodoItem> fetchedTodoItems = todoService.fetchTodoItemsByUserId(userId);

		TodoUserResource user = fetchTodoUser(userId);

		List<TodoItemResource> todoItemList = fetchedTodoItems.stream().map(ti -> {
			return DomainToResourceMapper.map(ti);
		}).collect(Collectors.toList());

		TodoItemsResource todoItems = TodoItemsResource.newInstance(user, todoItemList);

		return new ResponseEntity<>(todoItems, HttpStatus.OK);

	}

	@GetMapping(path = "/{userId}/{todoItemId}")
	public ResponseEntity<TodoItemsResource> fetchByUserIdAndTodoItemId(@PathVariable("userId") long userId,
			@PathVariable("todoItemId") long todoItemId) {

		TodoItem savedTodoItem = todoService.fetchTodoItemByUserIdAndTodoItemId(userId, todoItemId);

		TodoItemResource savedTodoItemResource = DomainToResourceMapper.map(savedTodoItem);

		TodoUserResource user = fetchTodoUser(userId);

		TodoItemsResource todoItems = TodoItemsResource.newInstance(user, Arrays.asList(savedTodoItemResource));

		return new ResponseEntity<>(todoItems, HttpStatus.OK);

	}

	@PostMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TodoItemsResource> save(@PathVariable("userId") long userId,
			@RequestBody TodoItemResource todoItemResource) {

		TodoItem todoItem = ResourceToDomainMapper.map(userId, todoItemResource);

		long savedTodoItemId = todoService.save(todoItem);

		TodoItem savedTodoItem = todoService.fetchTodoItemByUserIdAndTodoItemId(userId, savedTodoItemId);

		TodoItemResource savedTodoItemResource = DomainToResourceMapper.map(savedTodoItem);

		TodoUserResource user = fetchTodoUser(userId);

		TodoItemsResource todoItems = TodoItemsResource.newInstance(user, Arrays.asList(savedTodoItemResource));

		return new ResponseEntity<>(todoItems, HttpStatus.OK);

	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<TodoItemsResource> deleteTodoItemsByUserId(@PathVariable("userId") long userId) {

		todoService.deleteTodoItemsByUserId(userId);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(path = "/{userId}/{todoItemId}")
	public ResponseEntity<TodoItemsResource> deleteTodoItemByUserIdAndTodoItemId(@PathVariable("userId") long userId,
			@PathVariable("todoItemId") long todoItemId) {

		TodoItem savedTodoItem = todoService.fetchTodoItemByUserIdAndTodoItemId(userId, todoItemId);

		todoService.deleteTodoItemById(savedTodoItem.getId());

		return new ResponseEntity<>(HttpStatus.OK);

	}

	private TodoUserResource fetchTodoUser(long userId) {
		TodoUserResource user = TodoUserResource.newInstance(userId, "Sandeep", "Misal", "sandeep@misal");
		return user;
	}

}
