package com.srm4knowledge.functionalreactiveprogramming.eventdrivenprogramming;

import java.util.concurrent.atomic.AtomicLong;

import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class SimpleUserServiceImpl implements UserService {

	private AtomicLong counter = new AtomicLong(0);

	private PublishSubject<UserEvent> userEventPublisher = PublishSubject.create();

	public SimpleUserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User save(User newUser) {
		if (null == newUser)
			return null;

		userEventPublisher
				.onNext(UserEvent.newInstance(getNextId(), newUser.getEmailAddress(), newUser.getPhoneNumber()));

		return newUser;
	}

	@Override
	public User update(User user) {
		if (null == user)
			return null;

		return user;
	}

	@Override
	public void delete(User user) {
		if (null == user)
			return;

	}

	@Override
	public void subscribeUserEvent(Observer<UserEvent> subscriber) {
		userEventPublisher.subscribe(subscriber);
	}

	private long getNextId() {
		return counter.incrementAndGet();
	}

}
