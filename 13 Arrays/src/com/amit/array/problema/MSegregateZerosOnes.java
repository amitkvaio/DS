package com.amit.array.problema;

import java.util.Arrays;

/*
Segregate 0s and 1s in an array

You are given an array of 0s and 1s in random order. 
Segregate 0s on left side and 1s on right side of the array [Basically you have to sort the array]. 
Traverse array only once. 

Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] 
Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] 
Time Complexity : O(n) 
***********************************************
Use two indexes to traverse

*/
public class MSegregateZerosOnes {
	
	
	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 0, 1, 1, 1 };
		int n = arr.length;
		
		System.out.println(">>>>>>>>>>>>>>> Count Total number of zero >>>>>>>>>>>>>>>>");
		segregate0and1(arr, n);
		System.out.println(">>>>>>>>>>>>>>> Using two index >>>>>>>>>>>>>>>>");
		segregate0and1UsingTwoIndex(arr,n);
	}

	static void segregate0and1(int arr[], int n) {
		int count = 0; // counts the no of zeros in arr

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				count++;
		}

		// loop fills the arr with 0 until count
		for (int i = 0; i < count; i++)
			arr[i] = 0;

		// loop fills remaining arr space with 1
		for (int i = count; i < n; i++)
			arr[i] = 1;
		
		System.out.println("Array after segregation is "+Arrays.toString(arr));
	}
	
	
	public static void segregate0and1UsingTwoIndex(int arr[], int size) {
		/* Initialize left and right indexes */
		int left = 0, right = size - 1;

		while (left <= right) {
			/* Increment left index while we see 0 at left */
			while (arr[left] == 0 && left < right)
				left++;

			/* Decrement right index while we see 1 at right */
			while (arr[right] == 1 && left < right)
				right--;

			/*
			 * If left is smaller than right then there is a 1 at left and a 0 at right.
			 * Exchange arr[left] and arr[right]
			 */
			if (left < right) {
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
		}
		System.out.println("Array after segregation is "+Arrays.toString(arr));
	}

}

