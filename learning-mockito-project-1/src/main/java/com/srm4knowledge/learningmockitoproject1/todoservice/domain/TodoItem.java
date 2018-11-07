package com.srm4knowledge.learningmockitoproject1.todoservice.domain;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(includeFieldNames = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TodoItem {

	@EqualsAndHashCode.Include
	private @Getter @Setter Long id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String description;

	@Getter
	@Setter
	private LocalDateTime dateTime;

	@Getter
	@Setter
	private Boolean alarm;

	@Getter
	@Setter
	private Boolean repeat;

	@Getter
	@Setter
	private Long userId;

	public static TodoItem newInstance(String name, String description, LocalDateTime dateTime, Boolean alarm,
			Boolean repeat) {
		TodoItem item = new TodoItem();
		item.setId(null);
		item.setName(name);
		item.setDescription(description);
		item.setDateTime(dateTime);
		item.setAlarm(alarm);
		item.setRepeat(repeat);
		return item;
	}

}
