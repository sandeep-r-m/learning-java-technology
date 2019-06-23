package com.srm4knowledge.functionalreactiveprogramming.eventdrivenprogramming;

import com.srm4knowledge.functionalreactiveprogramming.Logger;

public class SimpleEmailServiceImpl implements EmailService {

	public SimpleEmailServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(EmailDetails emailDetails) throws Exception {

		if (null == emailDetails)
			throw new Exception("Email Details are null");

		Logger.log("Email sending..." + emailDetails.toString());
		Logger.log("Email sent successfully!");

	}

}
