/**
 * 
 */
package com.srm4knowledge.springbootestingexample.services.todo.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import com.srm4knowledge.springbootestingexample.services.todo.domain.TodoItem;
import com.srm4knowledge.springbootestingexample.services.todo.repositories.TodoItemRepository;
import com.srm4knowledge.springbootestingexample.services.todo.services.TodoService;
import com.srm4knowledge.springbootestingexample.services.todo.services.common.TodoServiceException;

/**
 * @author sandeep-r-m
 *
 */
@Service
@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class TodoServiceImpl implements TodoService {

	private final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);

	@Autowired
	private TodoItemRepository todoItemRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.srm4knowledge.springbootestingexample.services.todo.services.TodoService#
	 * addTodoItem(com.srm4knowledge.springbootestingexample.services.todo.domain.
	 * TodoItem)
	 */
	@Override
	public TodoItem addTodoItem(TodoItem todoItem) throws TodoServiceException {

		logger.debug("Entering...");

		if (null == todoItem)
			throw new TodoServiceException("todoItem is null");

		todoItem.setCreateDateTime(LocalDateTime.now());

		TodoItem saved = todoItemRepository.save(todoItem);

		logger.debug("Exiting...");

		return saved;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.srm4knowledge.springbootestingexample.services.todo.services.TodoService#
	 * updateTodoItem(com.srm4knowledge.springbootestingexample.services.todo.domain
	 * .TodoItem)
	 */
	@Override
	public TodoItem updateTodoItem(TodoItem todoItem) throws TodoServiceException {

		logger.debug("Entering...");

		if (null == todoItem)
			throw new TodoServiceException("todoItem is null");

		todoItem.setUpdateDateTime(LocalDateTime.now());

		TodoItem saved = todoItemRepository.save(todoItem);

		logger.debug("Exiting...");

		return saved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.srm4knowledge.springbootestingexample.services.todo.services.TodoService#
	 * deleteTodoItem(com.srm4knowledge.springbootestingexample.services.todo.domain
	 * .TodoItem)
	 */
	@Override
	public void deleteTodoItem(TodoItem todoItem) throws TodoServiceException {

		logger.debug("Entering...");

		if (null == todoItem || null == todoItem.getId())
			throw new TodoServiceException("todoItem is null");

		todoItemRepository.deleteById(todoItem.getId());

		logger.debug("Exiting...");

	}

	@Override
	public List<TodoItem> getTodoItemByUser(String username) throws TodoServiceException {

		logger.debug("Entering...");

		if (null == username || username.isEmpty())
			throw new TodoServiceException("username is not provided");

		List<TodoItem> todoItems = todoItemRepository.findAll();

		logger.debug("Exiting...");

		return todoItems;

	}

	@Override
	public TodoItem getTodoItemById(Long id) throws TodoServiceException {

		logger.debug("Entering...");

		if (null == id)
			throw new TodoServiceException("id is not provided");

		Optional<TodoItem> todoItemOptional = todoItemRepository.findById(id);

		TodoItem todoItem = todoItemOptional.orElseThrow(() -> {
			logger.debug("Exiting...");
			return new TodoServiceException("Todo Item with id = " + id + " not found!");
		});

		logger.debug("Exiting...");

		return todoItem;

	}

}
