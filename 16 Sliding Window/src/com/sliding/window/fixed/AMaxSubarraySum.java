package com.sliding.window.fixed;

/*
Maximum sum subarray of size k
Input  : arr[] = {2, 3, 4, 2, 9, 7, 10},  k = 3
Output : 26

Input  : arr[] = {100, 200, 300, 400},  k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4 
Output : 39
Explanation: We get maximum sum by adding subarray {4, 2, 10, 23} of size 4.

Input  : arr[] = {2, 3}, k = 3
Output : Invalid
Explanation: There is no subarray of size 3 as size of whole array is 2. 

*/


public class AMaxSubarraySum {
	public static void main(String[] args) {
		System.out.println(getMaxSum(new int[] { 2, 3, 4, 2, 9, 7, 10 }, 3));//26
		System.out.println(getMaxSum(new int[] { 100, 200, 300, 400 }, 2)); //700
		System.out.println(getMaxSum(new int[] { 1, 4, 2, 10, 23, 3, 1, 0, 20 }, 4));//39
		System.out.println(getMaxSum(new int[] { 2, 3 }, 3));//0
	}

	// Method to find the maximum sum of a subarray of size k
	public static int getMaxSum(int[] arr, int k) {
		int maxSum = 0;
		int windowSum = 0;
		int start = 0;

		// Loop through the array
		for (int i = 0; i < arr.length; i++) {
			// Add the current element to the window sum
			windowSum += arr[i];

			// If we have reached the window size k
			if ((i - start + 1) == k) {
				// Update maxSum if current windowSum is greater
				maxSum = Math.max(maxSum, windowSum);

				// Slide the window by removing the first element
				windowSum -= arr[start];

				// Move the window start position
				start++;
			}
		}
		return maxSum;
	}
}
/*
Time Complexity (TC): O(n)
	Why?
    The loop runs once through all n elements of the array.
    All operations inside the loop (addition, subtraction, comparison) take constant time.

So, total time = O(n)
Space Complexity (SC): O(1)
	Why?
    Only a fixed number of variables (maxSum, windowSum, start) are used.
    No extra space is used that grows with input size.
So, total space = O(1)
*/