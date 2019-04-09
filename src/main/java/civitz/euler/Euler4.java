package civitz.euler;

import io.vavr.collection.Stream;

/*
 

A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 
 *
 */
public class Euler4 extends EulerProblem {

	@Override
	int number() {
		return 4;
	}

	@Override
	Integer calculate() {
		return functional();
	}
	
	static Integer functional() {
		return Stream.range(100, 1000).crossProduct(Stream.range(100, 1000))
			.map(couple -> couple._1 * couple._2)
			.filter(Euler4::isPalindrome)
			.max()
			.getOrElse(0);
	}
	 
	static Integer iterative() {
		int maxPalindrome = 0;
		for(int a = 100; a<1000;a++) {
			for(int b=100; b<1000;b++) {
				int product = a*b;
				if(product > maxPalindrome && isPalindrome(product)) {
					maxPalindrome = product;
				}
			}
		}
		return maxPalindrome;
	}
	
	static boolean isPalindrome(int number) {
		String string = Integer.toString(number);
		return new StringBuilder(string).reverse().toString().equals(string);
	}

}
