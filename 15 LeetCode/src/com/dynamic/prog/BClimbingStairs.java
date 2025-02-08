package com.dynamic.prog;

import java.util.Arrays;

//Climbing Stairs | Recur + Memo | Bottom Up | DP Concepts & Qns - 3 | Leetcode-70
public class BClimbingStairs {
	public static void main(String[] args) {
		System.out.println(climbingStairs(2));//2
		System.out.println(climbingStairs(3));//3
		System.out.println(climbingStairs(4));//5
		
		System.out.println("********* Using Memoization **************");
		System.out.println(climbStairsUsingMemoization(2));//2
		System.out.println(climbStairsUsingMemoization(3));//3
		System.out.println(climbStairsUsingMemoization(4));//5
		
		System.out.println("**********Using Bottom Up Approach *************");
		System.out.println(climbStairsUsingBottomUpApproach(2));//2
		System.out.println(climbStairsUsingBottomUpApproach(3));//3
		System.out.println(climbStairsUsingBottomUpApproach(4));//5
		
		System.out.println("**********Optimized*************");
		System.out.println(climbStairsOptimized(2));//2
		System.out.println(climbStairsOptimized(3));//3
		System.out.println(climbStairsOptimized(4));//5
		 
	}
	
	
	private static int climbingStairs(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		int oneStep = climbingStairs(n - 1);
		int twoStep = climbingStairs(n - 2);
		return oneStep + twoStep;
	}
	
	private static int solve(int n, int[] t) {
		if (n < 0)
			return 0;

		if (n == 0)
			return 1;

		if (t[n] != -1)
			return t[n];
		
		int oneStep = solve(n - 1, t);
		int twoStep = solve(n - 2, t);
		return t[n] = oneStep + twoStep;

	}

	//Approach-1 (Recursion with Memo) : Top Down
	public static int climbStairsUsingMemoization(int n) {
		int[] t = new int[n + 1];
		Arrays.fill(t, -1);
		return solve(n, t);
	}
	
	
	// Approach-2 (Using Bottom Up DP)
	public static int climbStairsUsingBottomUpApproach(int n) {
		if (n == 1 || n == 2)
			return n;

		int[] t = new int[n + 1];

		// t[i] = total ways to climb i stairs
		t[0] = 0;
		t[1] = 1;
		t[2] = 2;

		for (int i = 3; i <= n; i++) {
			t[i] = t[i - 1] + t[i - 2];
		}
		return t[n];
	}
	
	//Approach-3 (Improving approach-2) -
	//See that it looks nothing but a fibonacci sequence. You just have to store last 2 values (t[i-1] & t[i-2]) to find current value (t[i])
	public static int climbStairsOptimized(int n) {
		if (n == 1 || n == 2 || n == 3)
			return n;

		int a = 1;
		int b = 2;
		int c = 3;

		for (int i = 3; i <= n; i++) {
			c = a + b;

			int temp_b = b;
			b = c;
			a = temp_b;

		}
		return c;
	}

}
/*

70. Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

 

Constraints:

    1 <= n <= 45





*/