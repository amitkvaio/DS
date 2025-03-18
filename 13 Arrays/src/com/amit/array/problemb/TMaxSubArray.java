package com.amit.array.problemb;

public class TMaxSubArray {
	static int maxSumSubarray(int[] arr, int k) {
        int windowSum = 0, maxSum = 0;
        
        // First, sum up the first 'k' elements
		for (int i = 0; i < k; i++) {
			System.out.println("Before Sum sum ::" + windowSum + " ::" + arr[i]);
			windowSum = windowSum + arr[i];
			System.out.println("After Sum sum ::" + windowSum);
		}
        maxSum = windowSum;

         
        // Slide the window forward
        System.out.println("Value of k :" + k);
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k]; // Add new element & remove old
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max Sum: " + maxSumSubarray(arr, k));  // Output: 9
    }
}
