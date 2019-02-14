package com.srm4knowledge.springtodoservice.services;

import java.util.List;

import com.srm4knowledge.springtodoservice.repositories.domain.TodoItem;
import com.srm4knowledge.springtodoservice.services.exception.TodoServiceException;

public interface TodoService {

	public List<TodoItem> fetchTodoItemsByUserId(long userId) throws TodoServiceException;

	public TodoItem fetchTodoItemByUserIdAndTodoItemId(long userId, long todoItemId) throws TodoServiceException;

	public Long save(TodoItem todoItem) throws TodoServiceException;

	public void deleteTodoItemById(long id) throws TodoServiceException;

	public void deleteTodoItemsByUserId(long userId) throws TodoServiceException;

}
