package com.amit.array.problemb;

import java.util.Iterator;

/*
Largest sum contiguous subarray
For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; 
	the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.
	
Kadane’s algorithm:

    Initialize maxSoFar= 0 and maxEndingHere = 0
    Iterate over each element of the array
        maxEndingHere = maxEndingHere + a[i]
        if(maxEndingHere < 0)
             maxEndingHere = 0
        
        if(maxSoFar < maxEndingHere)
     		maxSoFar = maxEndingHere

		return maxSoFar
*/
public class ELargetSumInArray {
	public static void main(String[] args) {
		int arr[]= {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		int sum = largetSumInSumArray(arr);
		System.out.println("Larget Sum ::"+sum);
		System.out.println(dynamicProgramForMaxSubArray(arr));
	}

	private static int largetSumInSumArray(int[] arr) {
		 int n = arr.length;
		 int sum = 0;
		 int start =0;
		 int end = 0;
		 int s = 0;
		 int maxSum = arr[0];
		 for (int i = 1; i < n ; i++) {
			sum = sum + arr[i];
			if (sum > maxSum) {
				maxSum = sum;
				//start = s;
				//end = i;
			}
			
			if(sum < 0) {
				sum = 0;
				//s = i + 1;
			}
		}
		
		 /*
		 System.out.println(maxSum);
		
		for (int i = start; i <= end ; i++) {
			System.out.print(arr[i] +"\t");
		}
		
		*/
		return maxSum;
	}
	
	public static int dynamicProgramForMaxSubArray(int[] arr) {
		int[] result = new int[arr.length];
		result[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result[i] = Math.max(result[i - 1] + arr[i], arr[i]);
		}
		int maxSumArray = result[0];
		for (int j = 1; j < result.length; j++) {
			if (maxSumArray < result[j])
				maxSumArray = result[j];
		}

		return maxSumArray;
	}
}
