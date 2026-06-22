package com.leetcode.hashmap;
// 219 Contains Duplicate II

import java.util.HashMap;

public class FEContainsDuplicateII {
	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
		System.out.println(containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
		System.out.println(containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));

	}

	private static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
				return true;
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}
}
/*
Given an integer array nums and an integer k, return true if there are two 
	distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

TC : O(n)
SC : O(n)
*/