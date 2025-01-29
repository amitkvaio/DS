package com.dynamic.prog;

import java.util.Arrays;

//Fibonacci Number | Recur + Memo | Bottom Up | DP Concepts & Qns - 2 | Leetcode-509

public class AFabonacci {
	public static void main(String[] args) {
		System.out.println(fabonacci_Simple(2));//1
		System.out.println(fabonacci_Simple(3));//2
		System.out.println(fabonacci_Simple(4));//3
		System.out.println(fabonacci_Simple(5));//5
		
		System.out.println("********Using Memoization***************");
		System.out.println(fabonacci_memoization(2));//1
		System.out.println(fabonacci_memoization(3));//2
		System.out.println(fabonacci_memoization(4));//3
		System.out.println(fabonacci_memoization(5));//5
		
		System.out.println("**************Using Constant space ***************");
		System.out.println(fabonacci_constantSpace(2));//1
		System.out.println(fabonacci_constantSpace(3));//2
		System.out.println(fabonacci_constantSpace(4));//3
		System.out.println(fabonacci_constantSpace(5));//5
	}
	
	
	//TC O(2^n) SC : O(n)
	public static int fabonacci_Simple(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fabonacci_Simple(n-1) + fabonacci_Simple(n-2);
	}
	
	
	//TC o(n)
	//Total space complexity: O(n) for the dp array + O(n) for the stack = O(n)
	public static int fabonacci_memoization(int n) {
		int dp[] = new int [n+1];
		Arrays.fill(dp, -1);
		
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		
		if(dp[n] !=-1) {
			return dp[n];
		}
		return fabonacci_memoization(n-1) + fabonacci_memoization(n-2);
	}
	
	//TC : O(n) and SC : O(1)
	public static int fabonacci_constantSpace(int n) {
		if (n <= 1)
			return n;

		int c = 0;
		int a = 0, b = 1;

		for (int i = 1; i < n; i++) {
			c = a + b;

			a = b;
			b = c;
		}
		return c;
	}
	
}

/*
509. Fibonacci Number
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.

Given n, calculate F(n).

 

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

 

Constraints:

    0 <= n <= 30



*/