package com.amit.array.problema;

import java.util.Arrays;

/*
Maximum and minimum of an array using minimum number of comparisons
*/
public class BFindMaxAndMinFromArray {
	public static void main(String[] args) {
		int arr[] = { 11, 1000, 445, 1, 330, 3000 };
		int maximum = Integer.MIN_VALUE;
		int minimum = Integer.MAX_VALUE;
		 
		for (int num : arr) {
			if(num > maximum) {
				maximum = num;
			}else if(num < minimum) {
				minimum = num;
			}
		}

		System.out.println("Given Arrays Elements are::"+Arrays.toString(arr));
		System.out.println("Maximum number::"+maximum);
		System.out.println("Minimum number::"+minimum);
		//Time Complexity: O(n)
	}
	
}
