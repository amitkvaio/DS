package com.dynamic.prog;

import java.util.Arrays;

//House Robber | Recursion | Memo | Bottom Up | Leetcode 198
public class CHouseRobber {
	public static void main(String[] args) {
		System.out.println(houseRob_UsingRecursion(new int [] {1,2,3,1}));//4
		System.out.println(houseRob_UsingRecursion(new int [] {2,7,9,3,1}));//12
		System.out.println("**************** Using Memoization ***********");
		System.out.println(houseRob_UsingRecursionMemoization(new int [] {1,2,3,1}));//4
		System.out.println(houseRob_UsingRecursionMemoization(new int [] {2,7,9,3,1}));//12
		System.out.println("****************Bottom Up ***********");
		System.out.println(houseRob_bottom_up(new int [] {1,2,3,1}));//4
		System.out.println(houseRob_bottom_up(new int [] {2,7,9,3,1}));//12
		System.out.println("****************Bottom Up optimized***********");
		System.out.println(houseRob_bottom_up_optimized(new int [] {1,2,3,1}));//4
		System.out.println(houseRob_bottom_up_optimized(new int [] {2,7,9,3,1}));//12
	}
	
	//Approach-0 Using Recursion
	public static int solve(int[] nums, int i, int n) {
		if(i >=n) {
			return 0;
		}
		//steals ith house and moves to i+2 (because we can't steal adjacent)
		int steal = nums[i] + solve(nums,i + 2, n);
		////skips this house, now we can move to adjacent next house
		int skip = solve (nums, i +1, n);
		return  Math.max(steal, skip);
	}
	
	public static int houseRob_UsingRecursion (int[] nums) {
		int n = nums.length;
		return solve(nums, 0 , n);
	}
	
	//Approach-1 Using Recursion
	public static int solveUsingMemoization(int[] nums, int i, int n, int[] dp) {
		if(i >=n) {
			return 0;
		}
		
		if(dp[i] !=-1) {
			return dp[i];
		}
		
		int steal = nums[i] + solveUsingMemoization(nums,i + 2, n, dp);
		int skip = solveUsingMemoization (nums, i +1, n, dp);
		return  dp[i] = Math.max(steal, skip);
	}
	
	public static int houseRob_UsingRecursionMemoization (int[] nums) {
		int n = nums.length;
		int[] dp = new int [101];
		Arrays.fill(dp, -1);
		return solveUsingMemoization(nums, 0 , n, dp);
	}
	
	// Approach-2 (Using Bottom Up DP)
	public static int houseRob_bottom_up(int[] nums) {
		int n = nums.length;

		if (n == 1)
			return nums[0];

		int[] dp = new int[n + 1];
		// t[i] = max profit till house i

		dp[0] = 0;
		dp[1] = nums[0];

		for (int i = 2; i <= n; i++) {

			int skip = dp[i - 1];
			int steal = nums[i - 1] + dp[i - 2];

			dp[i] = Math.max(skip, steal); // max(skip, steal)
			/*
            SKIP  : If we skip this house,  then we have money till previous house  =  t[i-1]
            STEAL : If we steal this house, then we can't take prev profit, we can take till (i-2)th house profit = t[i-2]
			 */
		}
		return dp[n];
	}
	
	//Approach-3 (Space Optimized Bottom Up - Converting Approach-2)
	public static int houseRob_bottom_up_optimized(int[] nums) {
		int n = nums.length;

		int prevPrev = 0;
		int prev = nums[0];

		for (int i = 2; i <= n; i++) {
			int skip = prev;

			int take = nums[i - 1] + prevPrev;

			int temp = Math.max(skip, take);

			prevPrev = prev;
			prev = temp;
		}
		return prev;
	}
}

/*
https://leetcode.com/problems/house-robber/
198. House Robber.

You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is 
that adjacent houses have security systems connected and it will automatically contact the police if two 
adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of 
money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

 

Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 400




*/