package com.amit.array;

public class Arrays17 {

	public static void main(String[] args) {
		//int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] arr = { -2, 1, -3, 4,-1,2};
		long maxSum = maxSubarraySum(arr, arr.length);
		System.out.println("\nMax sum would be::" + maxSum);
	}

	static long maxSubarraySum(int arr[], int n) {
		long max = arr[0], sum = 0;

		int start = 0, end = 0, s = 0;

		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
			if (sum > max) {
				max = sum;
				start = s;
				end = i;
			}
			if (sum < 0) {
				sum = 0;
				s = i + 1;
			}
		}

		System.out.println("Start::"+start);
		System.out.println("End::"+end);
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i] + ",");
		}

		return max;
	}
}
