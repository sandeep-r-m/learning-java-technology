package com.srm4knowledge.springtodoservice.controllers.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoUserResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String firstName;

	private String lastName;

	private String emailAddress;

	public static TodoUserResource newInstance(Long id, String firstName, String lastName, String emailAddress) {
		TodoUserResource todoUser = new TodoUserResource();
		todoUser.setId(id);
		todoUser.setFirstName(firstName);
		todoUser.setLastName(lastName);
		todoUser.setEmailAddress(emailAddress);
		return todoUser;
	}

}
