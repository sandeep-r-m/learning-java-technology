package com.srm4knowledge.functionalreactiveprogramming.eventdrivenprogramming;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {
		// TODO Auto-generated constructor stub
	}

	private long id;

	private String firstName;

	private String lastName;

	private String emailAddress;

	private String phoneNumber;

	public static User newInstance(long id, String firstName, String lastName, String emailAddress,
			String phoneNumber) {

		User user = new User();
		user.setId(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailAddress(emailAddress);
		user.setPhoneNumber(phoneNumber);
		return user;
	}

}
