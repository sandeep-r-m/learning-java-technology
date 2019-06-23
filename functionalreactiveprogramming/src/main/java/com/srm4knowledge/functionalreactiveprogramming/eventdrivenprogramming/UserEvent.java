package com.srm4knowledge.functionalreactiveprogramming.eventdrivenprogramming;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String emailAddress;

	private String phoneNumber;

	public UserEvent() {
		// TODO Auto-generated constructor stub
	}

	public static UserEvent newInstance(long id, String emailAddress, String phoneNumber) {
		UserEvent ue = new UserEvent();
		ue.setId(id);
		ue.setEmailAddress(emailAddress);
		ue.setPhoneNumber(phoneNumber);
		return ue;
	}

}
