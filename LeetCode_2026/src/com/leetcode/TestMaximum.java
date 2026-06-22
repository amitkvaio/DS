package com.leetcode;

public class TestMaximum {
	public static void main(String[] args) {
		int [] arr = {2,3,1,1,4};
		System.out.println(reachedOnLast(new int [] {2,3,1,1,4}));
		System.out.println(reachedOnLast(new int [] {3,2,1,0,4}));
	}

	private static boolean reachedOnLast(int[] arr) {
		int n = arr.length ;
		int destination = arr[n-1];
		int start = arr[0];
		for (int i = start; i < n -1 ; i++) {
			start =  start + arr[i];
			if(start == destination) {
				return true;
			}
		}
		return false;
	}
}
