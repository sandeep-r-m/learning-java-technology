package com.srm4knowledge.springdataelasticsearchexample.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm4knowledge.springdataelasticsearchexample.domain.User;
import com.srm4knowledge.springdataelasticsearchexample.repositories.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/{firstName}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Page<User> getUserByFirstName(@PathVariable("firstName") String firstName) {
		logger.info("findByFirstName - firstName = {}", firstName);
		Page<User> page = userRepository.findByFirstName(firstName, PageRequest.of(0, 10, Direction.DESC, "id"));

		Future<List<User>> future = userRepository.findByLastName("Misal");
		logger.info("future = " + future);
		try {
			future.get().stream().forEach(u -> System.out.println(u));
		} catch (InterruptedException | ExecutionException e) {
			logger.error(e.getMessage(), e);
		}

		return page;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public User saveUser(@RequestBody User user) {
		logger.info("saveUser - user = {}", user);
		return userRepository.save(user);
	}

}
