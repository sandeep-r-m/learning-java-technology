package com.srm4knowledge.functionalreactiveprogramming;

public class Logger {

	private Logger() {
		// empty
	}

	public static void log(String msg) {
		System.out.println("\n" + Thread.currentThread().getName() + " - " + msg + "\n");
	}

}
