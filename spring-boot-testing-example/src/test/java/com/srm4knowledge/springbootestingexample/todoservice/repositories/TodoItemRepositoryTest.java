package com.srm4knowledge.springbootestingexample.todoservice.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.srm4knowledge.springbootestingexample.services.todo.domain.TodoItem;
import com.srm4knowledge.springbootestingexample.services.todo.repositories.TodoItemRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoItemRepositoryTest {

	@Autowired
	private TodoItemRepository todoItemRepository;

	@Test
	public void testAddAndRetrive() {

		TodoItem item = new TodoItem();
		item.setName("Test Item 1");
		item.setDescription("Test Item 1 Description");
		item.setCreateDateTime(LocalDateTime.now());

		TodoItem savedItem = todoItemRepository.save(item);

		assertNotNull(savedItem);
		assertThat(savedItem.getName()).isEqualTo(item.getName());

	}

}
