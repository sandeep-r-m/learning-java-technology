package com.srm4knowledge.functionalreactiveprogramming.eventdrivenprogramming;

import java.util.concurrent.atomic.AtomicLong;

import com.srm4knowledge.functionalreactiveprogramming.Logger;

public class EventDrivenProgramming {

	private AtomicLong counter = new AtomicLong(0);

	private UserService userService = new SimpleUserServiceImpl();

	private EmailService emailService = new SimpleEmailServiceImpl();

	private EmailMonitoringService emailMonitoringService = new EmailMonitoringService(emailService, userService);

	public EventDrivenProgramming() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		EventDrivenProgramming edp = new EventDrivenProgramming();

		edp.addUser();
	}

	public void addUser() {
		Logger.log("Adding new user...");

		User newUser = User.newInstance(getNextId(), "Sandeep", "Misal", "sandeepmisal@foo.com", "1234567890");

		userService.save(newUser);
	}

	private long getNextId() {
		return counter.incrementAndGet();
	}

}
