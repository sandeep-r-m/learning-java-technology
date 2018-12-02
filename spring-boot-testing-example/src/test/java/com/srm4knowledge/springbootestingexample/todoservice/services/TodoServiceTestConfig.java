package com.srm4knowledge.springbootestingexample.todoservice.services;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.srm4knowledge.springbootestingexample.services.todo.services.TodoService;
import com.srm4knowledge.springbootestingexample.services.todo.services.impl.TodoServiceImpl;

@TestConfiguration
public class TodoServiceTestConfig {

	@Bean
	public TodoService todoService() {
		return new TodoServiceImpl();
	}

}
