package com.srm4knowledge.springtodoservice.controllers.model;

import java.io.Serializable;
import java.time.Clock;
import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoItemResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String desc;

	// @JsonSerialize(using = ZonedDateTimeSerializer.class)
	private ZonedDateTime dateCreated;

	public static TodoItemResource newInstance(Long id, String name, String desc) {
		TodoItemResource todoItem = new TodoItemResource();
		todoItem.setId(id);
		todoItem.setName(name);
		todoItem.setDesc(desc);
		todoItem.setDateCreated(ZonedDateTime.now(Clock.systemUTC()));
		return todoItem;
	}

}
