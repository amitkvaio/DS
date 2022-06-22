package com.amit.array;

import java.util.Arrays;

/*
Problem :
Given a  array,we need to find all pairs whose sum is equal to number X.
array[]={ -40, -5, 1, 3, 6, 7, 8, 20 };
Pair of elements whose sum is equal to 15 :  7, 8 and -5, 20
*/
public class Arrays15 {
	 
	  public static void main(String[] args) {
	        int array[] = { -40, -5, 1, 3, 6, 7, 8, 20 };
	        findPairsWithSumEqualsToXBruteForce(array, 15);
	        findPairsEqualsToX(array, 15);
	       // findPairsEqualsToXUsingHashing(array, 15);
	    }
	public static void findPairsEqualsToX(int arr[], int X) {
		int n = arr.length;
		if (n < 2)
			return;
		Arrays.sort(arr);
		System.out.println("The pair whose sum is equal to 15 : ");
		
		// left and right index variables
		int left = 0, right = n - 1;

		while (left < right) {
			if (arr[left] + arr[right] > X) {
				right--;
			} else if (arr[left] + arr[right] < X) {
				left++;
			} else {
				System.out.println(arr[left] + " " + arr[right]);
				left++;
			}

		}
	}
	
	public static void findPairsWithSumEqualsToXBruteForce(int arr[], int X) {
		if (arr.length < 2)
			return;
		System.out.println("The pair whose sum is closest to 15 using brute force method: ");
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tempSum = arr[i] + arr[j];

				if (tempSum == X) {
					System.out.println(arr[i] + " " + arr[j]);
				}
			}
		}
	}
}
