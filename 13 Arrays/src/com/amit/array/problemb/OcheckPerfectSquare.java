package com.amit.array.problemb;

/*
Check if a number is perfect square without finding square root
Input: n = 36 
Output: Yes

Input: n = 12 
Output: No 
Time Complexity : O(log(N))
Auxiliary Space: O(1)
*/
public class OcheckPerfectSquare {
	public static void main(String[] args) {
		int x = 25;
		// Function Call
		if (x == 0 || isPerfectSquare(x))
			System.out.print("Yes");
		else
			System.out.print("No");
	}

	static boolean isPerfectSquare(int num) {
		long left = 1, right = num;
		
		while (left <= right) {
			long mid = (left + right) / 2;

			// Check if mid is perfect square
			if (mid * mid == num) {
				return true;
			}

			// Mid is small -> go right to increase mid
			if (mid * mid < num) {
				left = mid + 1;
			}
			// Mid is large -> to left to decrease mid
			else {
				right = mid - 1;
			}
		}
		return false;
	}
}
