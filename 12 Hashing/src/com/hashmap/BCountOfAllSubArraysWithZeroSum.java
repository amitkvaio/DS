package com.hashmap;

import java.util.HashMap;

public class BCountOfAllSubArraysWithZeroSum {
	public static void main(String[] args) {
		int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
		int result = countZeroSumSubarrays(arr);
		System.out.println("Total zero-sum subarrays: " + result);
		System.out.println(countZeroSumSubarrays(new int[] { 1, -1 }));
		System.out.println(countZeroSumSubarrays(new int[] { 3, 4, -7, 1, 3, 3, 1, -4 }));
	}
	
	public static int countZeroSumSubarrays(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int prefixSum = 0;
		int count = 0;
		map.put(prefixSum, 1);

		for (int i = 0; i < arr.length; i++) {
			prefixSum = prefixSum + arr[i];

			if (map.containsKey(prefixSum)) {
				count = count + map.get(prefixSum);
				map.put(prefixSum, map.get(prefixSum) + 1);
			} else {
				map.put(prefixSum, 1);
			}
		}
		return count;
	}
}


/*
Count of all subarrays with zero sum
************************************
We will be given an array of integers and we have to find the number of subarrays
in the given array whose sum is zero.

An integer array arr
Goal: Count all subarrays where the sum of elements is 0

Input : n = 8 
arr = {15, -2, 2, -8, 1, 7, 10, 23}
output : 3

TC : O(n)
SC : O(n)
*/
