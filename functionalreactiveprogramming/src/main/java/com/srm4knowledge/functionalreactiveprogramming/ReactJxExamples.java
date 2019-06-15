package com.srm4knowledge.functionalreactiveprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import com.srm4knowledge.functionalreactiveprogramming.domain.User;
import com.srm4knowledge.functionalreactiveprogramming.domain.UserType;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ReactJxExamples {

	public static void main(String[] args) {

		Logger.log("main thread...started");

		// normal();

		// withSchedulers();

		// workflowExample1();

		// 3.Predicate Filtering examples ----

		// filterEven();
		// filterOdd();

		// 4.Positional Filtering examples ----

		// positionalFiltering_take();
		// positionalFiltering_first();
		// positionalFiltering_last();
		// positionalFiltering_takeLast();
		// distinct();

		// 5. Transformations
		// Mapping one to one
		// mapOneToOne();
		// Mapping one to many
		// mapOneToMany();
		// Scanning

		ThreadUtils.sleep();

		Logger.log("main thread...finished!");
	}

	static void mapOneToMany() {
		Observable.fromIterable(DataGenerator.getGreekAlphabets())
				.flatMap((s) -> Observable.fromIterable(Arrays.asList(s.toUpperCase(), s.toLowerCase())))
				.subscribe(System.out::println);
	}

	static void mapOneToOne() {
		Observable.fromIterable(DataGenerator.getGreekAlphabets()).map((s) -> s.toUpperCase())
				.subscribe(System.out::println);
	}

	static void distinct() {
		// Observable.fromIterable(DataGenerator.getGreekAlphabets()).subscribe(System.out::println);

		List<String> shuffled = new ArrayList<String>();
		shuffled.addAll(DataGenerator.getGreekAlphabets());
		shuffled.addAll(DataGenerator.getGreekAlphabets());
		shuffled.addAll(DataGenerator.getGreekAlphabets());
		shuffled.addAll(DataGenerator.getGreekAlphabets());

		Collections.shuffle(shuffled);

		Observable.fromIterable(shuffled).subscribe(System.out::println);

		Logger.log("After distinct and sorted -");

		Observable.fromIterable(shuffled).distinct().sorted().subscribe(System.out::println);
	}

	static void positionalFiltering_takeLast() {
		Observable.fromIterable(DataGenerator.getIntegerList()).takeLast(10).subscribe(System.out::println);
	}

	static void positionalFiltering_last() {
		int defaultValue = 10;
		Observable.fromIterable(DataGenerator.getIntegerList()).last(defaultValue).subscribe(System.out::println);
	}

	static void positionalFiltering_first() {
		int defaultValue = 10;
		Observable.fromIterable(DataGenerator.getIntegerList()).first(defaultValue).subscribe(System.out::println);
	}

	static void positionalFiltering_take() {
		Observable.fromIterable(DataGenerator.getIntegerList()).take(10).subscribe(System.out::println);
	}

	static void filterEven() {
		Observable.fromIterable(DataGenerator.getIntegerList()).filter((num) -> {
			return (num % 2 == 0);
		}).subscribe(System.out::println);
	}

	static void filterOdd() {
		List<Integer> numbers = DataGenerator.getIntegerList();

		Observable.fromIterable(numbers).filter((num) -> {
			return (num % 2 != 0);
		}).subscribe(System.out::println);
	}

	static void normal() {
		Observable<String> observable = null;

		// Observable from single value
		observable = Observable.fromArray(new String[] { "Hello" });
		observable.subscribe((i) -> System.out.println(i));

		observable = Observable.fromIterable(DataGenerator.getStringList());
		observable.subscribe((i) -> System.out.println(i));

		// Future observable

		FutureTask<List<String>> future = DataGenerator.getFutureTask();

		Observable<List<String>> futureObservable = Observable.fromFuture(future);

		Schedulers.computation().scheduleDirect(() -> {
			future.run();
		});

		futureObservable.subscribe((list) -> System.out.print(Arrays.toString(list.toArray())));
	}

	static void withSchedulers() {
		Observable<String> observable = null;

		// With subscribeOn
		/*
		 * observable = Observable.fromIterable(DataGenerator.getStringList());
		 * observable.subscribeOn(Schedulers.newThread()).subscribe((i) ->
		 * Logger.log(i), (t) -> t.printStackTrace(), () -> Logger.log("Completed!"));
		 */

		// With observedOn
		/*
		 * observable = Observable.fromIterable(DataGenerator.getStringList());
		 * observable.observeOn(Schedulers.newThread()).subscribe((i) -> Logger.log(i),
		 * (t) -> t.printStackTrace(), () -> Logger.log("Completed!"));
		 */

		// With both subscribeOn and observeOn
		observable = Observable.fromIterable(DataGenerator.getStringList());
		observable.subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread()).subscribe((i) -> Logger.log(i),
				(t) -> t.printStackTrace(), () -> Logger.log("Completed!"));

	}

	// Filter, Sort, Convert to JSON list of users
	static void workflowExample1() {

		Observable<User> observable = Observable.fromIterable(DataGenerator.getUserList());

		observable.filter((user) -> {
			return UserType.USER.equals(user.getUserType());
		}).sorted((u1, u2) -> {
			return u1.getUserType().compareTo(u2.getUserType());
		}).subscribe((user) -> {
			Logger.log(JsonUtils.toJson(user));
		});

	}

}

class ThreadUtils {
	public static void sleep() {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}