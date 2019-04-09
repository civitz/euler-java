package civitz.euler;

import java.util.stream.IntStream;

/*
 * 

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

 */
public class Euler5 extends EulerProblem {

	@Override
	int number() {
		return 5;
	}

	@Override
	Integer calculate() {
		return IntStream.iterate(2520, i -> i + 1)
				.filter(Euler5::isDivisibleForAll20)
				.findFirst()
				.orElse(0);
	}

	static boolean isDivisibleForAll20(int number) {
		for (int i = 20; i >= 1; i--) {
			if (number % i != 0) {
				return false;
			}
		}
		return true;
	}

	// this version is the best i could do, but still very slow comparing to
	// iterative
	static boolean isDivisibleForAll20Functional(int number) {
		return IntStream.rangeClosed(2, 20).allMatch(factor -> number % (22 - factor) == 0);
	}

}
