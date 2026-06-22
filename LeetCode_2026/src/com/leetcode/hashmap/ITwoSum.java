package com.leetcode.hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class ITwoSum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getTwoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(getTwoSum(new int[] { 3, 2, 4 }, 6)));
		System.out.println(Arrays.toString(getTwoSum(new int[] { 3, 3 }, 6)));
	}

	public static int[] getTwoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
			} else {
				map.put(nums[i], i);
			}

		}
		return result;
	}
}
/*
1. Two Sum

Given an array of integers nums and an integer target, 
	return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, 
	and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]


*/