package com.leetcode;

import java.util.HashSet;

public class A {
	public static void main(String[] args) {
		int [] arr = {1, 9, 3, 0, 18, 5, 2, 4, 10, 7, 12, 6};
		int max = findlongestSubLength(arr);
		System.out.println(max);
	}

	private static int findlongestSubLength(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		
		//O(N)
		
		//AGAIN FOR 
		//o(n)
		//O(2n)
		//O(n)
		
		int maxLength = 0;
		
		for (int i = 0; i < arr.length; i++) {
			// if the arr[i]-1 is not present in the set then arr[i] considered as entry
			// point
			int num = arr[i];
			if (!set.contains(num - 1)) {
				int count = 1;
				while (set.contains(num + 1)) {
					count++;
					num++;
				}
				maxLength = Math.max(maxLength, count);
			}
		}
		return maxLength;
	}
}
