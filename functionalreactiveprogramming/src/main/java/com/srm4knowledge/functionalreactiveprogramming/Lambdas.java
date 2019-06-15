package com.srm4knowledge.functionalreactiveprogramming;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

	public static void main(String[] args) {

		// 1
		Function<String, String[]> toArray = s -> {
			if (null == s || s.isEmpty())
				return new String[] {};

			String[] strArray = new String[s.length()];
			int i = 0;
			for (char c : s.toCharArray()) {
				strArray[i++] = c + "";
			}
			return strArray;
		};

		System.out.println(Arrays.toString(toArray.apply("Sandeep")));

		// 2
		BiFunction<Integer, Integer, Long> add = (a, b) -> {
			return (long) (a + b);
		};
		System.out.println(add);
		System.out.println(add.apply(3, 4));

		add = Lambdas::add_2;
		System.out.println(add);
		System.out.println(add.apply(5, 4));

	}

	static Long add_2(Integer a, Integer b) {
		System.out.println("add_2");
		return (long) (a + b);
	}

	static Long add_3(Integer a, Integer b, Integer c) {
		return (long) (a + b + c);
	};

}
