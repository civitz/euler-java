package civitz.euler;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/*

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.

*/
class Euler1 extends EulerProblem<Integer> {
	int number() {
		return 1;
	}

	Integer calculate() {
		IntPredicate isMultipleOf3 = i -> i % 3 == 0;
		IntPredicate isMultipleOf5 = i -> i % 5 == 0;
		return IntStream.range(1, 1000).filter(isMultipleOf3.or(isMultipleOf5)).sum();
	}
}