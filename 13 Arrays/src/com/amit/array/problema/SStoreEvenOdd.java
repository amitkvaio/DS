package com.amit.array.problema;
/*
Java Program to Store Even & Odd Elements of an Array into Separate Arrays
Even Array contains: 54 76 66 2 
Odd Array contains: 23 55 9 91 
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Arrays;

public class SStoreEvenOdd {

	public static void main(String[] args) {
		int n = 8;
		// array with N size
		int array[] = { 23, 55, 54, 9, 76, 66, 2, 91 };

		int evenSize = 0;
		int oddSize = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] % 2 == 0)
				evenSize++;
			else
				oddSize++;
		}
		// odd and even arrays with size
		int[] even = new int[evenSize];
		int[] odd = new int[oddSize];
		// odd and even array iterator
		int j = 0, k = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] % 2 == 0)
				even[j++] = array[i];
			else
				odd[k++] = array[i];
		}
		System.out.print("Even Array contains: \n" + Arrays.toString(even));
		System.out.print("\nOdd Array contains: \n" + Arrays.toString(odd));
	}
}
