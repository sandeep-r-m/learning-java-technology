package com.srm4knowledge.springtodoservice.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srm4knowledge.springtodoservice.repositories.TodoItemRepository;
import com.srm4knowledge.springtodoservice.repositories.domain.TodoItem;
import com.srm4knowledge.springtodoservice.services.TodoService;
import com.srm4knowledge.springtodoservice.services.exception.TodoServiceException;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoItemRepository todoItemRespository;

	@Override
	public List<TodoItem> fetchTodoItemsByUserId(long userId) throws TodoServiceException {

		Iterable<TodoItem> todoItemsIter = todoItemRespository.findAll();

		Predicate<TodoItem> filter = new Predicate<TodoItem>() {
			@Override
			public boolean evaluate(TodoItem todoItem) {
				if ((null == todoItem) || (null == todoItem.getUserId()))
					return false;
				return (userId == todoItem.getUserId().longValue());
			}
		};

		Optional<List<TodoItem>> todoItemsOpt = collect(todoItemsIter, filter);

		List<TodoItem> todoItemList = todoItemsOpt
				.orElseThrow(() -> TodoServiceException.newInstance("No Todo items found!"));

		return todoItemList;
	}

	@Override
	public TodoItem fetchTodoItemByUserIdAndTodoItemId(long userId, long todoItemId) throws TodoServiceException {

		Iterable<TodoItem> todoItemsIter = todoItemRespository.findAll();

		Predicate<TodoItem> filter = new Predicate<TodoItem>() {
			@Override
			public boolean evaluate(TodoItem todoItem) {
				if ((null == todoItem) || (null == todoItem.getUserId()))
					return false;

				return ((userId == todoItem.getUserId().longValue()) && (todoItemId == todoItem.getId().longValue()));
			}
		};

		Optional<List<TodoItem>> todoItemsOpt = collect(todoItemsIter, filter);

		List<TodoItem> todoItemList = todoItemsOpt
				.orElseThrow(() -> TodoServiceException.newInstance("No Todo items found!"));

		return todoItemList.get(0);
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
		// TODO
	}

	private Optional<List<TodoItem>> collect(Iterable<TodoItem> todoItemsIter, Predicate<TodoItem> filter) {

		CollectionUtils.filter(todoItemsIter, filter);

		Collection<TodoItem> collected = CollectionUtils.collect(todoItemsIter, new Transformer<TodoItem, TodoItem>() {
			@Override
			public TodoItem transform(TodoItem input) {
				return input;
			}
		});

		if (CollectionUtils.isEmpty(collected)) {
			return Optional.empty();
		}

		List<TodoItem> todoItems = new ArrayList<>();
		todoItems.addAll(collected);

		return Optional.of(todoItems);
	}

}
