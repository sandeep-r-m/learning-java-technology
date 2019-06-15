package com.srm4knowledge.functionalreactiveprogramming.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private UserType userType;

	public static User newInstance(long id, String firstName, String lastName, String email, UserType userType) {
		User newUser = new User();
		newUser.setId(id);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setUserType(userType);
		return newUser;
	}

}
