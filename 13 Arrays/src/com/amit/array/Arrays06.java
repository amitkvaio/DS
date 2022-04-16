package com.amit.array;

import java.util.Arrays;
//Reverse the an elements of an arrays
public class Arrays06 {
	public static void main(String[] args) {
		String[] arr4 = { "Hello", "World", "Amit", "Niraj", "Rakesh","adf" };

		int start = 0;
		int end = arr4.length - 1;

		while (start < end) {
			String temp = arr4[start];
			arr4[start] = arr4[end];
			arr4[end] = temp;
			start++;
			end--;
		}
		
		System.out.println(Arrays.toString(arr4));
	}
}
