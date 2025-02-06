//Java Program to Check Whether a Number can be Expressed as Sum of Two Prime Numbers
package com.problem.soving00;

public class NumberCanBeExpAs2PrimeNumber {
	public static void main(String[] args) {
		System.out.println("********11**********");
		checkSumOfTwoPrimes(11);
		System.out.println("********34**********");
		checkSumOfTwoPrimes(34);
		System.out.println("********25**********");
		checkSumOfTwoPrimes(25);
		System.out.println("********19**********");
		checkSumOfTwoPrimes(19);
	}
	
	
	// Function to check if a number can be expressed as the sum of two primes
	public static void checkSumOfTwoPrimes(int n) {
		boolean found = false;
		for (int i = 2; i <= n / 2; i++) {
			int complement = n - i;
			if (isPrime(i) && isPrime(complement)) {
				System.out.println(n + " = " + i + " + " + complement);
				found = true;
			}
		}
		if (!found) {
			System.out.println(n + " cannot be expressed as the sum of two prime numbers.");
		}
	}
	

	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) { // Only check up to sqrt(num)
			if (num % i == 0) {
				return false; // Found a factor, not prime
			}
		}
		return true; // No factors found, it's prime
	}
}

/*
At least one factor must be ≤ sqrt(num).

Example 1: Checking 37
    square root of 37 ≈ 6.0837
    ​≈6.08
    Factors, if any, must be ≤ 6.
    We only check divisibility by 2, 3, 4, 5, 6.
Since none divide 37, it's prime.

Example 2: Checking 36

    square root of 36=6
    ​=6
    Factors of 36: {2, 3, 4, 6, 9, 12, 18}
    We find 2 divides 36, so it isn't prime.
Even if we skipped checking beyond 6, we'd still find a divisor.


Why i <= Math.sqrt(num) in Prime Checking?

When checking if a number num is prime, the most efficient way is not to check divisibility for all numbers from 2 to num-1. 
Instead, we only check up to sqrt(num).

*/