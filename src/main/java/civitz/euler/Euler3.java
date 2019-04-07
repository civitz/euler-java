package civitz.euler;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.Test;

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Euler3 extends EulerProblem<Long> {
	int number() {
		return 3;
	}

	Long calculate() {
		return functionalStyle(600851475143L);
	}

	/*
	 * This variant is definitely less readable, will need a better approach
	 */
	static Long functionalStyle(long start) {
		return Stream.iterate(new State(2, start), State::maxDivide)
			.takeWhile(state -> state.current>=1L && state.divisor<=state.current)
			.mapToLong(state-> state.divisor)
			.max()
			.orElse(start);
	}

	static class State {
		long divisor;
		long current;

		public State(long divisor, long current) {
			super();
			this.divisor = divisor;
			this.current = current;
		}

		boolean isDivisible() {
			return current % divisor == 0;
		}

		State maxDivide() {
			return isDivisible() ? new State(divisor, current / divisor) : new State(divisor + 1, current);
		}
	}

	static Long iterative(long start) {
		// iterate over numbers from 2
		// when it divisible, divide until no longer divisible, then try the next number
		// keep largest divisor, it will be prime
		// this is not a general solution
		var current = start;
		var divisor = 2L;
		while (current > 1L & divisor <= current) {
			if (current % divisor == 0) {
				current /= divisor;
			} else {
				divisor++;
			}
		}

		return divisor;
	}

	@Test
	public void shouldBeValidForExampleValues() throws Exception {
		assertThat(iterative(13195)).isEqualTo(29);
	}

	@Test
	public void shouldHaveSameValuesForFunctionalAndIterative() throws Exception {
		assertThat(iterative(13195)).isEqualTo(functionalStyle(13195));
	}
}