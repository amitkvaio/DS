package com.leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EThreeSum {
	public static void main(String[] args) {
		System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
		System.out.println(threeSum(new int[] {0,1,1}));
		System.out.println(threeSum(new int[] {0,0,0}));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1])
				continue; // skip duplicate i

			int start = i + 1;
			int end = nums.length - 1;

			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];

				if (sum > 0) {
					end--;
				} else if (sum < 0) {
					start++;
				} else {
					result.add(Arrays.asList(nums[i], nums[start], nums[end]));

					start++;
					end--;

					// skip duplicate at start
					while (start < end && nums[start] == nums[start - 1]) {
						start++;
					}

					// skip duplicate at end
					while (start < end && nums[end] == nums[end + 1]) {
						end--;
					}
				}
			}
		}
		return result;
	}
}

/*
Given an integer array nums, return all the triplets [nums[i], 
nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

*/
