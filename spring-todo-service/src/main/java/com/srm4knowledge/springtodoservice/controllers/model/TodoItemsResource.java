package com.srm4knowledge.springtodoservice.controllers.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoItemsResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TodoUserResource user;

	private List<TodoItemResource> todoItemList = new ArrayList<>();

	public static TodoItemsResource newInstance(TodoUserResource user, List<TodoItemResource> todoItemList) {
		TodoItemsResource todoItems = new TodoItemsResource();
		todoItems.setUser(user);
		todoItems.setTodoItemList(todoItemList);
		return todoItems;
	}

}
