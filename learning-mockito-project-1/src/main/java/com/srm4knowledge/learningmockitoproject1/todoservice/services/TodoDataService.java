package com.srm4knowledge.learningmockitoproject1.todoservice.services;

import java.util.List;

import com.srm4knowledge.learningmockitoproject1.todoservice.domain.TodoItem;

public interface TodoDataService {

	public void addTodoItem(TodoItem todoItem);

	public void updateTodoItem(TodoItem todoItem);

	public void deleteTodoItem(Long id);

	public TodoItem getTodoItemById(Long id);

	public List<TodoItem> getTodoItemByUserId(Long id);

}
