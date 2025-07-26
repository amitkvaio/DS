package com.sliding.window.variable;

/*

Find the maximum sum in the given array with positive numbers windows size K

Input: arr[] = [10, 5, 2, 7, 1, 2], k = 10
Output: 3

Input: arr[] = [1, 8, 6 , 2, 4, 12], k = 20
Output: 5
Explanation: Only subarray with sum = 15 is [-5, 8, -14, 2, 4] of length 5.

Input: arr[] = [10, 8, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
*/

public class AfindTheLargestSumOfWinK {
	public static void main(String[] args) {
		System.out.println(getLargestSumOfWinK(new int[] { 10, 5, 2, 7, 1, 2 }, 10));
		System.out.println(getLargestSumOfWinK(new int[] { 1, 8, 6, 2, 4, 12 }, 20));
		System.out.println(getLargestSumOfWinK(new int[] { 10, 8, 20, 30 }, 5));
		System.out.println("#######################################################");
		System.out.println(getLargestSubArrayOfSumK_(new int[] { 10, 5, 2, 7, 1, 2 }, 10));
		System.out.println(getLargestSubArrayOfSumK_(new int[] { 1, 8, 6, 2, 4, 12 }, 20));
		System.out.println(getLargestSubArrayOfSumK_(new int[] { 10, 8, 20, 30 }, 5));
	}

	public static int getLargestSumOfWinK(int[] arr, int k) {
		int n = arr.length;
		int i = 0, j = 0, sum = 0;
		int mx = 0; // Initialize to 0, in case no subarray is found

		while (j < n) {
			sum = sum + arr[j];

			// Shrink the window from the left until sum <= k
			while (sum > k && i <= j) {
				sum = sum - arr[i];
				i++;
			}

			// If current sum is equal to k, update max length
			if (sum == k) {
				mx = Math.max(mx, j - i + 1);
			}

			j++;
		}
		return mx == 0 ? 0 : mx; // return -1 if no such subarray is found
	}

	public static int getLargestSubArrayOfSumK_(int[] arr, int k) {
		int n = arr.length;
		int i = 0, j = 0, sum = 0;
		int mx = 0; // To store the maximum length of subarray with sum = k

		// Traverse the array using sliding window technique
		while (j < n) {
			sum = sum + arr[j]; // Add current element to the window sum

			// Case 1: Sum is less than k → increase the window from right
			if (sum < k) {
				j++;
			}

			// Case 2: Sum is exactly equal to k → check max length and slide window
			else if (sum == k) {
				mx = Math.max(mx, j - i + 1); // Update maximum length
				j++; // Move forward
			}

			// Case 3: Sum is greater than k → shrink the window from the left
			else if (sum > k) {
				// Keep removing elements from the left until sum <= k
				while (sum > k && i <= j) {
					sum = sum - arr[i];
					i++; // Shrink the window

					// After shrinking, check again if sum == k
					if (sum == k) {
						mx = Math.max(mx, j - i + 1); // Update max length
					}
				}
				j++; // Move forward
			}
		}

		return mx; // Return the maximum subarray length with sum = k
	}
}
/*
Use a sliding window from index i to j.
Maintain the current sum of elements in that window.
Three cases:

    If sum < k: expand window by moving j forward.
    If sum == k: update max length and expand window.
    If sum > k: shrink window from left by moving i.
*/
