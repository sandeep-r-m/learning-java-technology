package com.srm4knowledge.functionalreactiveprogramming.eventdrivenprogramming;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EmailDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id = 0L;

	private List<String> toList = new ArrayList<String>();

	private List<String> ccList = new ArrayList<String>();

	private List<String> bccList = new ArrayList<String>();

	private String subject = "";

	private String body = "";

	public EmailDetails() {
		// TODO Auto-generated constructor stub
	}

	public EmailDetails(List<String> toList, List<String> ccList, List<String> bccList, String subject, String body) {
		this.toList = Collections.unmodifiableList(toList);
		this.ccList = Collections.unmodifiableList(ccList);
		this.bccList = Collections.unmodifiableList(bccList);
		this.subject = subject;
		this.body = body;
	}
}
