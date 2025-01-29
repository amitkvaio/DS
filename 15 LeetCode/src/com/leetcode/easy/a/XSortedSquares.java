package com.leetcode.easy.a;

import java.util.Arrays;

//24. Squares of a Sorted Array | 2 Approaches | Follow Up | Leetcode 977
public class XSortedSquares {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
		System.out.println(Arrays.toString(sortedSquares(new int[] { -7, -3, 2, 3, 11 })));
		System.out.println("***********************************************************");
		System.out.println(Arrays.toString(sortedSquares_(new int[] { -4, -1, 0, 3, 10 })));
		System.out.println(Arrays.toString(sortedSquares_(new int[] { -7, -3, 2, 3, 11 })));
	}
	
	// Approach-1
	// T.C : O(nlogn)
	// S.C : O(1)
	public static int[] sortedSquares(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] * nums[i];
		}

		Arrays.sort(nums); // O(nlogn)
		return nums;
	}
	
	// Approach-2 (Follow Up, without sorting nlogn)
	// T.C : O(n)
	// S.C : O(1) - (Not considering the space taken to store the result)
	
	public static int[] sortedSquares_(int[] nums) {
		int n = nums.length;

		int[] result = new int[n];

		int i = 0, j = n - 1;
		int k = n - 1;

		while (k >= 0) {
			int a = nums[i] * nums[i];
			int b = nums[j] * nums[j];

			if (a > b) {
				result[k] = a;
				i++;
			} else {
				result[k] = b;
				j--;
			}
			k--;
		}
		return result;
	}
}

/*

977. Squares of a Sorted Array.
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
https://leetcode.com/problems/squares-of-a-sorted-array/description/
 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 

Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.

 
Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

*/












