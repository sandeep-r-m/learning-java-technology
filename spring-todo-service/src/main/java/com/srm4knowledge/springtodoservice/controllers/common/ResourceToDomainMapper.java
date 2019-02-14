package com.srm4knowledge.springtodoservice.controllers.common;

import com.srm4knowledge.springtodoservice.controllers.model.TodoItemResource;
import com.srm4knowledge.springtodoservice.repositories.domain.TodoItem;

public class ResourceToDomainMapper {

	public static TodoItem map(long userId, TodoItemResource todoItemResource) {
		TodoItem ti = TodoItem.newInstance(todoItemResource.getName(), todoItemResource.getDesc(), userId);
		return ti;
	}

}
