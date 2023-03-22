package com.amit.array.problema;

import java.util.Arrays;

//2nd Highest number
public class CSecondHighestNumber {
	public static void main(String[] args) {
		int arr[] = { 11, 1000, 445, 1, 330, 3000 };
		int maximum = Integer.MIN_VALUE;
		int secondMaximum = Integer.MIN_VALUE;
		
		for (int num : arr) {
			if(num > maximum) {
				secondMaximum = maximum;
				maximum = num;
			}else {
				secondMaximum = num;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println("First maximum::"+maximum);
		System.out.println("secondMaximum::"+secondMaximum);
		
	}
}
