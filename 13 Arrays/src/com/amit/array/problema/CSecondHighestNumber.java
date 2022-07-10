package com.amit.array.problema;

import java.util.Arrays;

//2nd Highest number
public class CSecondHighestNumber {
	public static void main(String[] args) {
		int arr[] = { 11, 1000, 445, 1, 330, 3000 };
		int maximum, secondMaximum;
		int len = arr.length;
		
		//if only one elements are present then that becomes maximum and 2nd highest
		if(len==1) {
			maximum=arr[0];
			return;
		}
		
		if(arr[0]>arr[1]) {
			maximum=arr[0];
			secondMaximum=arr[1];
		}else {
			maximum=arr[1];
			secondMaximum=arr[0];
		}
		int i=2;
		while(i<len) {
			if(arr[i]>maximum) {
				secondMaximum=maximum;
				maximum=arr[i];
			}
			i++;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("First maximum::"+maximum);
		System.out.println("secondMaximum::"+secondMaximum);
		
	}
}
