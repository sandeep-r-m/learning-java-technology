package com.srm4knowledge.functionalreactiveprogramming;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

public class ConnectableObservables {

	public static void main(String[] args) {
		Logger.log("ConnectableObservables::main - Started...");

		// example1();

		// multipleSubscribersExample1();

		// multipleSubscribersExample2();

		// multipleSubscribersExample3();

		multipleSubscribersExample4();

		ThreadUtils.sleep(60);

		Logger.log("ConnectableObservables::main - Finished!");
	}

	static void example1() {
		ConnectableObservable<String> co = Observable.fromIterable(DataGenerator.getGreekAlphabets()).publish();

		co.subscribe(System.out::println); // does not start to publish events

		co.connect(); // starts to publish event
	}

	// All subscribers are on single thread
	static void multipleSubscribersExample1() {

		ConnectableObservable<String> co = Observable.fromIterable(DataGenerator.getGreekAlphabets()).publish();

		co.subscribe(Logger::log);

		co.subscribe(Logger::log);

		co.connect();
	}

	// Subscribers are on different threads
	static void multipleSubscribersExample2() {

		ConnectableObservable<String> co = Observable.fromIterable(DataGenerator.getGreekAlphabets()).publish();

		// Run this subscribers on different thread
		co.observeOn(Schedulers.newThread()).subscribe(Logger::log);

		// Run this subcriber on main thread
		co.subscribe(Logger::log);

		co.connect();
	}

	// Subscribers are on different threads
	static void multipleSubscribersExample3() {

		ConnectableObservable<String> co = Observable.fromIterable(DataGenerator.getGreekAlphabets()).publish();

		// Run this subscriber on different thread
		co.observeOn(Schedulers.computation()).subscribe(Logger::log);

		// Run this subscriber on different thread
		co.observeOn(Schedulers.computation()).subscribe(Logger::log);

		co.connect();
	}

	// One fast and one slow subscriber
	static void multipleSubscribersExample4() {

		ConnectableObservable<String> co = Observable.fromIterable(DataGenerator.getGreekAlphabets()).publish();

		// Run this subscriber on different thread
		co.observeOn(Schedulers.computation()).subscribe(Logger::log);

		// Run this subscriber on different thread
		co.observeOn(Schedulers.computation()).subscribe((a) -> {
			ThreadUtils.sleep(1);
			Logger.log("Slow Subscriber - " + a);
		}, (e) -> {
			Logger.log("Error in Slow Subscriber - " + e);
		}, () -> {
			Logger.log("Unsubscribed called by Slow Observable!");
		});

		co.connect();
	}
}
