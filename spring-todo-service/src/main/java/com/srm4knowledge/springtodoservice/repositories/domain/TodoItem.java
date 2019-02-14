package com.srm4knowledge.springtodoservice.repositories.domain;

import java.io.Serializable;
import java.time.Clock;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "TODO_ITEMS")
public class TodoItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TODO_ID")
	private Long id;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "DESC", length = 255)
	private String desc;

	@Column(name = "DATE_CREATED", updatable = false)
	private ZonedDateTime dateCreated;

	@Column(name = "USER_ID", updatable = false)
	private Long userId;

	public static TodoItem newInstance(String name, String desc, Long userId) {
		TodoItem todoItem = new TodoItem();
		todoItem.setName(name);
		todoItem.setDesc(desc);
		todoItem.setDateCreated(ZonedDateTime.now(Clock.systemUTC()));
		todoItem.setUserId(userId);
		return todoItem;
	}

}
