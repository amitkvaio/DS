package com.amit.array.problema;

import java.util.Arrays;

/*
Maximum and minimum of an array using minimum number of comparisons
*/
public class BFindMaxAndMinFromArray {
	public static void main(String[] args) {
		int arr[] = { 11, 1000, 445, 1, 330, 3000 };
		int maximum, minimum;
		int len = arr.length;
		int i = 2;

		// if there is only one elements
		if (len == 1) {
			maximum = arr[0];
			minimum = arr[0];
		}
		// more than one
		if (arr[0] > arr[1]) {
			maximum = arr[0];
			minimum = arr[1];
		} else {
			maximum = arr[1];
			minimum = arr[0];
		}

		while (i < len) {
			if (arr[i] > maximum) {
				maximum = arr[i];
			} else if (arr[i] < minimum) {
				minimum = arr[i];
			}
			i++;
		}
		System.out.println("Given Arrays Elements are::"+Arrays.toString(arr));
		System.out.println("Maximum number::"+maximum);
		System.out.println("Minimum number::"+minimum);
		//Time Complexity: O(n)
	}
	
}
