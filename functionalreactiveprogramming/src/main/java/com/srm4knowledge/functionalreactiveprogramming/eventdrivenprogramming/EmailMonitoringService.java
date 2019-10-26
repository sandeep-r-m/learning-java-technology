package com.srm4knowledge.functionalreactiveprogramming.eventdrivenprogramming;

import java.util.Arrays;

import com.srm4knowledge.functionalreactiveprogramming.Logger;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class EmailMonitoringService {

	private EmailService emailService;

	public EmailMonitoringService(EmailService emailService, UserService userService) {
		this.emailService = emailService;

		userService.subscribeUserEvent(new Observer<UserEvent>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onNext(UserEvent t) {
				handleUserEvent(t);

			}

			@Override
			public void onError(Throwable e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub

			}
		});
	}

	private void handleUserEvent(UserEvent userEvent) {

		Logger.log("User Event received!");

		EmailDetails emailDetails = new EmailDetails(Arrays.asList(userEvent.getEmailAddress()), Arrays.asList(""),
				Arrays.asList(""), "Hello!", "Good Morning!");

		try {
			emailService.send(emailDetails);
		} catch (Exception e) {
			Logger.log("Error sending email - " + e.getMessage());
		}
	}

}
