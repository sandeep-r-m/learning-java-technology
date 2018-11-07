package com.srm4knowledge.learningmockitoproject1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.srm4knowledge.learningmockitoproject1.todoservice.TodoService;
import com.srm4knowledge.learningmockitoproject1.todoservice.domain.TodoItem;
import com.srm4knowledge.learningmockitoproject1.todoservice.services.TodoDataService;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class LearningMockitoProject1ApplicationTests {

	@Mock
	TodoDataService dataService;

	@InjectMocks
	TodoService todoService;

	@Test
	public void testGetTodoItemsByUserId() {

		List<TodoItem> todoItems = org.assertj.core.util.Lists.list(
				TodoItem.newInstance("Learn Mockito Basics", "Learn Mockito basics to implement in project",
						LocalDateTime.now(), Boolean.TRUE, Boolean.TRUE),
				TodoItem.newInstance("Learn Mockito with Spring", "Learn Mockito with Spring to implement in project",
						LocalDateTime.now(), Boolean.TRUE, Boolean.TRUE));

		// TodoDataService dataService = mock(TodoDataService.class);

		when(dataService.getTodoItemByUserId(1L)).thenReturn(todoItems);

		assertEquals(2, todoService.getTodoItemByUserId(1L).size());

	}

}
