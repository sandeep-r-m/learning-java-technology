package com.srm4knowledge.functionalreactiveprogramming.eventdrivenprogramming;

import io.reactivex.Observer;

public interface UserService {

	public User save(User newUser);

	public User update(User user);

	public void delete(User user);

	public void subscribeUserEvent(Observer<UserEvent> subscriber);

}
