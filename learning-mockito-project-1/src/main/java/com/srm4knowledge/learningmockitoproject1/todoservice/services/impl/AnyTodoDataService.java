package com.srm4knowledge.learningmockitoproject1.todoservice.services.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.srm4knowledge.learningmockitoproject1.todoservice.domain.TodoItem;
import com.srm4knowledge.learningmockitoproject1.todoservice.services.TodoDataService;

@Service
public class AnyTodoDataService implements TodoDataService {

	@Override
	public void addTodoItem(TodoItem todoItem) {

	}

	@Override
	public void updateTodoItem(TodoItem todoItem) {

	}

	@Override
	public void deleteTodoItem(Long id) {

	}

	@Override
	public TodoItem getTodoItemById(Long id) {
		return null;
	}

	@Override
	public List<TodoItem> getTodoItemByUserId(Long id) {
		return Collections.emptyList();
	}

}
