package com.srm4knowledge.functionalreactiveprogramming.eventdrivenprogramming;

import java.io.Serializable;

import lombok.Getter;

/**
 * Immutable User class. <br>
 * Setting any property returns new User.class object which is copy of referred
 * object with respective property set to new value.<br>
 * 
 * @author srmmbp
 *
 */
@Getter
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

	public User setId(long id) {
		User newUser = copy();
		newUser.id = id;
		return newUser;
	}

	public User setFirstName(String firstName) {
		User newUser = copy();
		newUser.firstName = firstName;
		return newUser;
	}

	public User setLastName(String lastName) {
		User newUser = copy();
		newUser.lastName = lastName;
		return newUser;
	}

	public User setEmailAddress(String emailAddress) {
		User newUser = copy();
		newUser.emailAddress = emailAddress;
		return newUser;
	}

	public User setPhoneNumber(String phoneNumber) {
		User newUser = copy();
		newUser.phoneNumber = phoneNumber;
		return newUser;
	}

	private User copy() {
		User copy = new User();
		copy.id = this.id;
		copy.firstName = this.firstName;
		copy.lastName = this.lastName;
		copy.emailAddress = this.emailAddress;
		copy.phoneNumber = this.phoneNumber;
		return copy;
	}

}
