package com.srm4knowledge.functionalreactiveprogramming;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public static final String EMPTY_JSON = "{}";

	private static ObjectMapper objectMapper = new ObjectMapper();

	private JsonUtils() {

		// empty
	}

	public static String toJson(Object obj) {

		String output = EMPTY_JSON;

		if (null == obj)
			return EMPTY_JSON;

		try {
			output = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return output;
	}

}
