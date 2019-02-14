package com.srm4knowledge.springtodoservice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.srm4knowledge.springtodoservice.controllers.model.TodoItemResource;

public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();

	static {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		objectMapper.registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module())
				.registerModule(new JavaTimeModule());

	}

	public static String toJson(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "{}";
	}

	public static void main(String[] args) {
		TodoItemResource todoItemResource = TodoItemResource.newInstance(null, "Learn Spring AWS",
				"Microservices on AWS");
		String output = JsonUtil.toJson(todoItemResource);
		System.out.println(output);

	}

}
