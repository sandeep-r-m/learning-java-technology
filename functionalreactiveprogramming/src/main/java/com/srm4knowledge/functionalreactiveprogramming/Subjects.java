package com.srm4knowledge.functionalreactiveprogramming;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;

public class Subjects {

	public static void main(String[] args) {
		Logger.log("Subjects::main - Started...");

		// publishSubjectExample1();

		// behaviourSubjectExample1();

		asynchSubjectExample1();

		ThreadUtils.sleep(10);

		Logger.log("Subjects::main - Finished!");
	}

	static void asynchSubjectExample1() {

		AsyncSubject<String> as = AsyncSubject.create();

		as.subscribe(Logger::log);

		Observable<String> glo = Observable.fromIterable(DataGenerator.getGreekAlphabets());

		glo.subscribe((a) -> {
			as.onNext(a);
			ThreadUtils.sleep(1);
		});
	}

	static void behaviourSubjectExample1() {

		// BehaviorSubject<String> bs = BehaviorSubject.create(); // looks like same as

		final BehaviorSubject<String> bs = BehaviorSubject.createDefault("Start state");

		bs.subscribe((item) -> {
			Logger.log("BehaviourSubject 1st subscriber - " + item);
		});

		Observable<String> glo = Observable.fromIterable(DataGenerator.getGreekAlphabets());

		glo.subscribe((a) -> {
			bs.onNext(a);
			ThreadUtils.sleep(1);
		});

		// bs.onNext("Hello!");

		bs.subscribe((item) -> {
			Logger.log("BehaviorSubject's 2nd subscriber - " + item);
		});

		bs.onNext("Hello! Again!");

	}

	static void publishSubjectExample1() {

		final PublishSubject<String> ps = PublishSubject.create();

		ps.subscribe((item) -> {
			Logger.log("PublishSubject's 1st subscriber - " + item);
		});

		Observable<String> glo = Observable.fromIterable(DataGenerator.getGreekAlphabets());

		glo.subscribe((a) -> {
			ps.onNext(a);
			ThreadUtils.sleep(1);
		});

		ps.onNext("Hello!");

		ps.subscribe((item) -> {
			Logger.log("PublishSubject's 2nd subscriber - " + item);
		});

		ps.onNext("Hello! Again!");
	}

}
