package com.srm4knowledge.springbootestingexample.todoservice.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.srm4knowledge.springbootestingexample.services.todo.domain.TodoItem;
import com.srm4knowledge.springbootestingexample.services.todo.repositories.TodoItemRepository;
import com.srm4knowledge.springbootestingexample.services.todo.services.TodoService;
import com.srm4knowledge.springbootestingexample.services.todo.services.impl.TodoServiceImpl;

@RunWith(SpringRunner.class)
public class TodoServiceTest {

	@TestConfiguration
	public static class TodoServiceTestConfig {

		@Bean
		public TodoService todoService() {
			return new TodoServiceImpl();
		}

	}

	@MockBean
	private TodoItemRepository todoItemRepository;

	@Autowired
	private TodoService todoService;

	@Test
	public void testAddTodoItem() throws Exception {

		TodoItem todoItem = new TodoItem();
		todoItem.setName("Testing");
		todoItem.setDescription("Test Description");

		Mockito.when(todoItemRepository.save(todoItem)).thenReturn(todoItem);

		TodoItem savedItem = todoService.addTodoItem(todoItem);

		assertNotNull(savedItem);
		assertThat(savedItem.getName()).isEqualTo(todoItem.getName());

	}

}
