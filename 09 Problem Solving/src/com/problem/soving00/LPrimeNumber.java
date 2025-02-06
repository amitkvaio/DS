package com.problem.soving00;

public class LPrimeNumber {
	public static void main(String[] args) {
		int num = 93;
		//checkPriveNumber(num);
		printNPrimeNumber(1,100);
	}
	
	/*
	We only have to loop through 2 to half of num, 
		because no number is divisible by more than its half
	*/
	public static void printNPrimeNumber(int low, int high) {
		while(low < high) {
			if(isPrime(low)) {
				System.out.print(low +" ");
			}
			low++;
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
