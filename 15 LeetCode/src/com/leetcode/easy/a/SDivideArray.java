package com.leetcode.easy.a;

import java.util.Arrays;

//19. Divide Array Into Arrays With Max Difference| Why Sorting | Google | Leetcode 2966
public class SDivideArray {
	public static void main(String[] args) {
		System.out.println();
		print(divideArray(new int[] {1,3,4,8,7,9,3,5,1}, 2));
		System.out.println("******************************");
		print(divideArray(new int[] {2,4,2,2,5,2}, 2));
	}
	
	public static int[][] divideArray(int[] nums, int k) {
		int n = nums.length;

		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int[][] result = new int[n / 3][3];
		int index = 0;

		for (int i = 0; i <= n - 3; i = i + 3) {
			if ((nums[i + 2] - nums[i]) > k) {
				return new int[0][0];
			}
			result[index++] = new int[] { nums[i], nums[i + 1], nums[i + 2] };
		}
		return result;
	}
	
	public static void print(int[][] out) {
		int row = out.length;
		if (row > 0 && out[0].length > 0) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < out[0].length; j++) {
					System.out.print(out[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}

/*
Leetcode 2966 : divide-array-into-arrays-with-max-difference
https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/


You are given an integer array nums of size n where n is a multiple of 3 and a positive integer k.

Divide the array nums into n / 3 arrays of size 3 satisfying the following condition:

    The difference between any two elements in one array is less than or equal to k.

Return a 2D array containing the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.

 

Example 1:

Input: nums = [1,3,4,8,7,9,3,5,1], k = 2

Output: [[1,1,3],[3,4,5],[7,8,9]]

Explanation:

The difference between any two elements in each array is less than or equal to 2.

Example 2:

Input: nums = [2,4,2,2,5,2], k = 2

Output: []

Explanation:

Different ways to divide nums into 2 arrays of size 3 are:

    [[2,2,2],[2,4,5]] (and its permutations)
    [[2,2,4],[2,2,5]] (and its permutations)

Because there are four 2s there will be an array with the elements 2 and 5 no matter how we divide it. since 5 - 2 = 3 > k, the condition is not satisfied and so there is no valid division.

Example 3:

Input: nums = [4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], k = 14

Output: [[2,2,12],[4,8,5],[5,9,7],[7,8,5],[5,9,10],[11,12,2]]

Explanation:

The difference between any two elements in each array is less than or equal to 14.

 

Constraints:

    n == nums.length
    1 <= n <= 105
    n is a multiple of 3
    1 <= nums[i] <= 105
    1 <= k <= 105



*/