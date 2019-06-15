package com.srm4knowledge.functionalreactiveprogramming;

public class PureFunctions {

	public static void main(String[] args) {

		PureFunctions pf = new PureFunctions();

		long output = pf.add(10, 10);
		System.out.println("output = " + output);
	}

	public long add(int a, int b) {
		return (a + b);
	}

}
