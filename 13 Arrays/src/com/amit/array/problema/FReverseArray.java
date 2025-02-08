package com.amit.array.problema;

import java.util.Arrays;
//Reverse the an elements of an arrays
public class FReverseArray {
	public static void main(String[] args) {
		String[] arr = { "Hello", "World", "Amit", "Niraj", "Rakesh","adf" };

		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			String temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		System.out.println(Arrays.toString(arr));
	}
}
