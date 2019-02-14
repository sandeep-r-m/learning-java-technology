package com.srm4knowledge.springtodoservice.controllers.common;

import com.srm4knowledge.springtodoservice.controllers.model.TodoItemResource;

public class DomainToResourceMapper {

	public static TodoItemResource map(com.srm4knowledge.springtodoservice.repositories.domain.TodoItem todoItem) {
		TodoItemResource ti = TodoItemResource.newInstance(todoItem.getId(), todoItem.getName(), todoItem.getDesc());
		return ti;
	}

}
