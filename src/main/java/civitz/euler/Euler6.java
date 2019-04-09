package civitz.euler;

import java.util.stream.LongStream;

/*
 * 

The sum of the squares of the first ten natural numbers is,
1^2 + 2^2 + ... + 10^2 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)^2 = 552 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

 */
public class Euler6 extends EulerProblem {

	@Override
	int number() {
		return 6;
	}

	@Override
	Number calculate() {
		return square(LongStream.rangeClosed(1, 100).sum()) - LongStream.rangeClosed(1, 100).map(x -> x * x).sum();
	}

	static long square(long x) {
		return x * x;
	}

}
