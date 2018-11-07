package com.srm4knowledge.learningmockitoproject1.todoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srm4knowledge.learningmockitoproject1.todoservice.domain.TodoItem;
import com.srm4knowledge.learningmockitoproject1.todoservice.services.TodoDataService;

@Service
public class TodoService {

	@Autowired
	private TodoDataService dataService;

	public void addTodoItem(TodoItem item) {

	}

	public List<TodoItem> getTodoItemByUserId(Long id) {

		List<TodoItem> todoItemsForUser = this.dataService.getTodoItemByUserId(id);

		return todoItemsForUser;

	}

}
