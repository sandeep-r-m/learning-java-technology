package com.srm4knowledge.functionalreactiveprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.srm4knowledge.functionalreactiveprogramming.domain.User;
import com.srm4knowledge.functionalreactiveprogramming.domain.UserType;

public class DataGenerator {

	private DataGenerator() {
		// empty
	}

	private static Supplier<List<String>> greekAlphabetSupplier = new Supplier<List<String>>() {

		@Override
		public List<String> get() {
			return Arrays.asList("alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta", "theta", "iota", "kappa",
					"lamda", "mu", "nu", "xi", "omicron", "pi", "rho", "sigma", "tau", "upsilon", "phi", "chi", "psi",
					"omega");
		}
	};

	private static Supplier<List<Integer>> intSupplier = new Supplier<List<Integer>>() {

		@Override
		public List<Integer> get() {
			return IntStream.range(0, 100).boxed().collect(Collectors.toList());
		}
	};

	private static Supplier<List<User>> userListSupplier = new Supplier<List<User>>() {

		@Override
		public List<User> get() {
			List<User> userList = new ArrayList<User>();
			userList.add(User.newInstance(1, "Sunil", "Gavaskar", "sunil.gavaskar@test.com", UserType.ADMIN));
			userList.add(User.newInstance(1, "Rahul", "Dravid", "rahul.dravid@test.com", UserType.USER));
			userList.add(User.newInstance(1, "Sachin", "Tendulkar", "sachin.tendulkar@test.com", UserType.USER));
			userList.add(User.newInstance(1, "Anil", "Kumble", "sandeep.misal@test.com", UserType.GUEST));
			return userList;
		}
	};

	private static Supplier<List<String>> stringListSupplier = new Supplier<List<String>>() {

		@Override
		public List<String> get() {
			return Arrays.asList("Hello", "Good Morning!", "How", "are", "you");
		}

	};

	private static Supplier<FutureTask<List<String>>> futureTaskSupplier = new Supplier<FutureTask<List<String>>>() {

		@Override
		public FutureTask<List<String>> get() {
			Logger.log("FutureSupplier::get()");
			return new FutureTask<List<String>>(new Callable<List<String>>() {

				@Override
				public List<String> call() throws Exception {
					Logger.log("FutureTask::call()");
					return Arrays.asList("Hello", "Good Morning!", "How", "are", "you");
				}
			});
		}
	};

	public static List<String> getGreekAlphabets() {
		return greekAlphabetSupplier.get();
	}

	public static List<Integer> getIntegerList() {
		return intSupplier.get();
	}

	public static List<User> getUserList() {
		return userListSupplier.get();
	}

	public static List<String> getStringList() {
		return stringListSupplier.get();
	}

	public static FutureTask<List<String>> getFutureTask() {
		return futureTaskSupplier.get();
	}

}
