package com.leetcode.easy.a;
// 21. Power of Two | Multiple Approaches | Leetcode 231
public class UisPowerOfTwo {
	public static void main(String[] args) {
		System.out.println(isPowerOfTwoUsingRecursion(1));
		System.out.println(isPowerOfTwoUsingRecursion(16));
		System.out.println(isPowerOfTwoUsingRecursion(3));
		System.out.println("***********************************");
		System.out.println(isPowerOfTwoUsingBit(1));
		System.out.println(isPowerOfTwoUsingBit(16));
		System.out.println(isPowerOfTwoUsingBit(3));
		System.out.println("***********************************");
		System.out.println(isPowerOfTwoUsingBuiltIn(1));
		System.out.println(isPowerOfTwoUsingBuiltIn(16));
		System.out.println(isPowerOfTwoUsingBuiltIn(3));
		System.out.println("***********************************");
	}
	
	// Approach-1 (Using normal division) - Can also write iterative version
	// T.C : O(log(n))
	// S.C : O(1)
	public static boolean isPowerOfTwoUsingRecursion(int n) {
		if (n <= 0)
			return false;
		if (n == 1)
			return true;

		return n % 2 == 0 && isPowerOfTwoUsingRecursion(n / 2);
	}
	
	// Approach-2 (Using bit magic)
	// T.C : O(1)
	// S.C : O(1)
	 public static boolean isPowerOfTwoUsingBit(int n) {
	        return (n > 0) && ((n & (n - 1)) == 0);
	 }
	 
	// Approach-3 (__builtin_popcount)
	// T.C : O(1)
	// S.C : O(1)
	public static boolean isPowerOfTwoUsingBuiltIn(int n) {
		if (n <= 0)
			return false;
		return Integer.bitCount(n) == 1;
	}
}

/*
Leetcode 231 Power of two
https://leetcode.com/problems/power-of-two/description/
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

 

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1

Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16

Example 3:

Input: n = 3
Output: false

 

Constraints:

    -231 <= n <= 231 - 1

 
Follow up: Could you solve it without loops/recursion?


*/