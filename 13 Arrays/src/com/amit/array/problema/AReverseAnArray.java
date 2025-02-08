package com.amit.array.problema;

import java.util.Arrays;
import java.util.Collections;

/*
Reverse an array in Java
Input : 1, 2, 3, 4, 5
Output :5, 4, 3, 2, 1

Input :  10, 20, 30, 40
Output : 40, 30, 20, 10

There are numerous approaches to reverse an array in Java. These are:

Using Temp array
Using Swapping
Using Collections.reverse() method
Using StringBuilder.append() method
*/

public class AReverseAnArray {
	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 5 };
		reverseArraysUsingTempArray(arr1);
		System.out.println("********************");
		int arr2[] = { 10, 20, 30, 40, 50 };
		reverseArraysUsingSwap(arr2);
		System.out.println(Arrays.toString(arr2));
		System.out.println("******************");
		Integer [] arr3 = {10, 20, 30, 40, 50};
		reverseUsingCollections(arr3); 
		System.out.println("*******************");
		String[] arr4 = {"Hello", "World","Amit","Niraj","Rakesh"};
		reverseUsingStringBuilder(arr4);

	}

	private static void reverseUsingStringBuilder(String[] arr) {
		StringBuilder rev = new StringBuilder();
	      for (int i = arr.length; i > 0; i--) {
	          rev.append(arr[i - 1]).append(" ");
	      }
	      String[] revArray = rev.toString().split(" ");
	      System.out.println(Arrays.toString(revArray));
	}

	private static void reverseUsingCollections(Integer[] arr2) {
		Collections.reverse(Arrays.asList(arr2));
		System.out.println(Arrays.asList(arr2));
		
	}

	private static void reverseArraysUsingTempArray(int[] arr) {
		int len = arr.length;
		int n = len;
		int temp[] = new int[len];
		for (int i = 0; i < len; i++) {
			temp[n - 1] = arr[i];
			n--;
		}
		System.out.println(Arrays.toString(temp));
	}

	public static void reverseArraysUsingSwap(int arr[]) {
		int sIdx = 0;
		int eIdx = arr.length - 1;
		while (sIdx < eIdx) {
			int temp = arr[sIdx];
			arr[sIdx] = arr[eIdx];
			arr[eIdx] = temp;
			sIdx++;
			eIdx--;
		}
	}
	
	/*
	 TC : O(n/2) ~=O(n)
	 Space complexity ~=O(1)
	 */
}
