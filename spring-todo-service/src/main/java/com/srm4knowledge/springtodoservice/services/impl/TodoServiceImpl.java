package com.srm4knowledge.springtodoservice.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srm4knowledge.springtodoservice.repositories.TodoItemRepository;
import com.srm4knowledge.springtodoservice.repositories.domain.TodoItem;
import com.srm4knowledge.springtodoservice.services.TodoService;
import com.srm4knowledge.springtodoservice.services.exception.TodoServiceException;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoItemRepository todoItemRespository;

	@Override
	public List<TodoItem> fetchTodoItemsByUserId(long userId) throws TodoServiceException {

		Optional<List<TodoItem>> todoItemsOpt = todoItemRespository.findByUserId(userId);

		List<TodoItem> todoItemList = todoItemsOpt
				.orElseThrow(() -> TodoServiceException.newInstance("No Todo items found!"));

		return todoItemList;
	}

	@Override
	public TodoItem fetchTodoItemByUserIdAndTodoItemId(long userId, long todoItemId) throws TodoServiceException {

		Optional<TodoItem> todoItemOpt = todoItemRespository.findByIdAndUserId(todoItemId, userId);

		TodoItem todoItem = todoItemOpt.orElseThrow(() -> TodoServiceException.newInstance("No Todo item found!"));

		return todoItem;
	}

	@Override
	public Long save(TodoItem todoItem) {
		TodoItem savedTodoItem = todoItemRespository.save(todoItem);
		return savedTodoItem.getId();
	}

	@Override
	public void deleteTodoItemById(long id) {
		todoItemRespository.deleteById(id);
	}

	@Override
	public void deleteTodoItemsByUserId(long userId) {
		todoItemRespository.deleteByUserId(userId);
	}

}
