package com.srm4knowledge.springbootestingexample.services.todo.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TODO_ITEM")
public class TodoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TODO_ITEM_ID")
	private Long id;

	@Column(name = "TODO_ITEM_NAME", length = 100, nullable = false, updatable = true, insertable = true)
	private String name;

	@Column(name = "TODO_ITEM_DESCRIPTION", length = 250, nullable = true, updatable = true, insertable = true)
	private String description;

	@Column(name = "TODO_ITEM_CREATED_DATETIME", nullable = false, updatable = false, insertable = true)
	private LocalDateTime createDateTime;

	@Column(name = "TODO_ITEM_UPDATED_DATETIME", nullable = false, updatable = true, insertable = true)
	private LocalDateTime updateDateTime;

	public static TodoItem newInstance(String name, String description) {
		TodoItem item = new TodoItem();
		item.setName(name);
		item.setDescription(description);
		item.setCreateDateTime(LocalDateTime.now());
		return item;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoItem other = (TodoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

}
