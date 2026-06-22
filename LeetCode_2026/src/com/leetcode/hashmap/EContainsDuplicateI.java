package com.leetcode.hashmap;

import java.util.HashMap;

// 217 Contains Duplicate

public class EContainsDuplicateI {
	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 }));
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 }));
		System.out.println(containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
	}

	public static boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Integer n : nums) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
				if (map.get(n) > 1)
					return true;
			} else {
				map.put(n, 1);
			}
		}
		return false;
	}
}
/*
Given an integer array nums, return true if any value appears at least twice in the array, 
	and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:
All elements are distinct.

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

TC : O(n)
SC : O(n)
*/