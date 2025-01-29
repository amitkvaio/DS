package com.dynamic.prog;

import java.util.Arrays;

//House Robber II | Recur + Memo | DP Concepts & Qns - 5 | Leetcode-213
public class DHouseRoberII {
	
	static int t[] = new int [101];
	public static void main(String[] args) {
		System.out.println(robHouse(new int[] {2,3,2}));//3
		System.out.println(robHouse(new int[] {1,2,3,1}));//4
		System.out.println(robHouse(new int[] {1,2,3}));//3
	}
	
	
	public static int solve(int[] nums, int i, int n) {
		if (i > n)
			return 0;

		if (t[i] != -1)
			return t[i];

		int take = nums[i] + solve(nums, i + 2, n); // steals ith house and moves to i+2 (because we can't steal
													// adjacent)
		int skip = solve(nums, i + 1, n); // skips this house, now we can move to adjacent next house

		return t[i] = Math.max(take, skip);
	}
	
	public static int robHouse(int[] nums) {
		int n = nums.length;

		if (n == 1)
			return nums[0];

		if (n == 2)
			return Math.max(nums[0], nums[1]);

		Arrays.fill(t, -1);

		// case-1 - Take first house 0th index wala house
		int take_0th_index_house = solve(nums, 0, n - 2);

		Arrays.fill(t, -1);

		// case-2 - Take second house 1st index wala house
		int take_1st_index_house = solve(nums, 1, n - 1);

		return Math.max(take_0th_index_house, take_1st_index_house);
	}
}
/*

213. House Robber II
https://leetcode.com/problems/house-robber-ii/description/
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:

Input: nums = [1,2,3]
Output: 3

 

Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 1000



*/