package com.leetcode.math;

import java.util.Arrays;

public class ASieveOfEratosthenes {
	public static void main(String[] args) {
		int num = 50;
		sieveOfEratosthenes(num);
	}

	public static void sieveOfEratosthenes(int num) {
		boolean[] isPrime = new boolean[num + 1];
		// isPrime true --> i is a prime number, else i is not prime
		Arrays.fill(isPrime, true);

		for (int i = 2; i * i <= num; i++) {
			// If isPrime[p] is still true, then p is a prime number
			if (isPrime[i]) {
				// Update all multiples of p to false
				for (int j = 2; i * j <= num; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		
		System.out.println("Prime numbers up to " + num + ":");
		for (int i = 2; i <= num; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
	}
}

/*
The Sieve of Eratosthenes is an efficient algorithm to find all prime numbers up to a specified integer n.

Time Complexity:
O(nlog⁡(log⁡(n)))



*/
