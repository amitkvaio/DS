package com.recursion;

public class ARecursion {
	
	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(factorialUsingTailRecursion(5, 1));
	}
	
	public static int factorial(int n) {
		
		//base case
		if(n==1)
			return 1;
		if(n==0)
			return 1;
		
		return n * factorial(n-1);
	}
	
	//Using tail recursion
	public static int factorialUsingTailRecursion(int n, int fact) {
		// base case
		if (n == 1)
			return fact;
		return factorialUsingTailRecursion((n - 1), n * fact);
	}
	
}
