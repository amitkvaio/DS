package com.leetcode.general;

import java.util.Arrays;

/*
single-number/
Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
*/
public class LSingleNumber {
	public static void main(String[] args) {
		int[] arr1 = {2,2,1};
		int[] arr2 = {4,1,2,1,2};
		int[] arr3 = {1};
		usingXOR(arr1);usingXOR(arr2);usingXOR(arr3);
	}
	
	//Firt way TO-DO
	public static void usingSort(int [] arr) {
		int n = arr.length;
		Arrays.sort(arr);

		for (int i = 1; i < n; i++) {
			if(arr[i-1]==arr[i]) {
				
			}
		}
	}
	
	//TC=O(n) sc=O(1) : this is better way of doing this.
	public static void usingXOR(int[]arr) {
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum^arr[i];
		}
		System.out.println("Single Number:"+sum);
	}
	
	
}
