package com.srm4knowledge.springbootestingexample.services.todo.services;

import java.util.List;

import com.srm4knowledge.springbootestingexample.services.todo.domain.TodoItem;
import com.srm4knowledge.springbootestingexample.services.todo.services.common.TodoServiceException;

public interface TodoService {

	public TodoItem addTodoItem(TodoItem todoItem) throws TodoServiceException;

	public TodoItem updateTodoItem(TodoItem todoItem) throws TodoServiceException;

	public void deleteTodoItem(TodoItem todoItem) throws TodoServiceException;

	public List<TodoItem> getTodoItemByUser(String username) throws TodoServiceException;

	public TodoItem getTodoItemById(Long id) throws TodoServiceException;

}
