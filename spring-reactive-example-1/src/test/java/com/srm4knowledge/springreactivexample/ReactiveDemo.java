package com.srm4knowledge.springreactivexample;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ReactiveDemo {

	public static void main(String[] args) {

		Observable<String> observable = Observable.just("Hello", "World");

		// onNext
		observable.subscribe(s -> {
			System.out.println("result = " + s);
		});

		printLine();

		// onNext, onError
		observable.subscribe(s -> {
			System.out.println("onNext = " + s);
		}, s -> {
			System.out.println("onError = " + s);
		});

		printLine();

		observable.subscribe(s -> {
			System.out.println("onNext = " + s);
		}, s -> {
			System.out.println("onError = " + s);
		}, () -> {
			System.out.println("onComplete");
		});

		printLine();

		observable.subscribe(s -> {
			System.out.println("onNext = " + s);
			throw new Exception("error in onNext");
		}, e -> {
			System.out.println("onError - errorMessage = " + e.getMessage());
		}, () -> {
			System.out.println("onComplete");
		}, s -> {
			System.out.println("onSubscribe = " + s);
		});

		printLine("Map Operations");

		observable.map(s -> s.toUpperCase()).subscribe(s -> {
			System.out.println("onNext = " + s);
			// throw new Exception("error in onNext");
		}, e -> {
			System.out.println("onError - errorMessage = " + e.getMessage());
		});

		printLine("Flat Map Operations");

		observable.flatMap(s -> Observable.just(s)).subscribe(c -> System.out.println(c));

		printLine("Scan Operations");

		observable = Observable.just("1", "2", "3", "4", "5");

		observable.scan(new StringBuilder(), StringBuilder::append).subscribe(s -> System.out.println(s.toString()));

		printLine("Group By Operations");

		Observable<Integer> numbersObservable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9);

		numbersObservable.groupBy(i -> (i % 2) == 0 ? "EVEN" : "ODD")
				.subscribe(g -> g.subscribe(n -> System.out.println(g.getKey() + "-" + n)));

		printLine("Filter Operations");

		// Even Numbers
		numbersObservable.filter(n -> n % 2 == 0).subscribe(n -> System.out.println(n));

		printLine("TakeWhile Operations");

		// Only numbers greater than 6
		numbersObservable.takeWhile(n -> n < 5).subscribe(n -> System.out.println(n));

		printLine("Connectable Observable");

		ConnectableObservable<Long> connectableObservable = ConnectableObservable.interval(200, TimeUnit.MILLISECONDS)
				.publish();
		connectableObservable.subscribe(n -> System.out.println(n));
		connectableObservable.connect();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}

	public static void printLine() {
		System.out.println("----------------------------------------");
	}

	public static void printLine(String msg) {
		System.out.println("----" + msg + "------------------------------------");
	}
}
