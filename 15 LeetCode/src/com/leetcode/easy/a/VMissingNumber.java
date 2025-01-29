package com.leetcode.easy.a;

import java.util.Arrays;

// 22.Missing Number | Multiple Approaches | Leetcode 268
public class VMissingNumber {
	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] {3,0,1})); //2
		System.out.println(missingNumber(new int[] {0,1})); //2
		System.out.println(missingNumber(new int[] {9,6,4,2,3,5,7,0,1})); //8
		System.out.println("*****************Using XOR*************************");
		System.out.println(missingNumberUsingXor(new int[] {3,0,1})); //2
		System.out.println(missingNumberUsingXor(new int[] {0,1})); //2
		System.out.println(missingNumberUsingXor(new int[] {9,6,4,2,3,5,7,0,1})); //8
		System.out.println("*****************Using binary search *************************");
		System.out.println(missingNumberUsingBinarySearch(new int[] {3,0,1})); //2
		System.out.println(missingNumberUsingBinarySearch(new int[] {0,1})); //2
		System.out.println(missingNumberUsingBinarySearch(new int[] {9,6,4,2,3,5,7,0,1})); //8
	}
	
	// Approach-1 (Math)
	// T.C: O(n)
	// S.C: O(1)
	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int sum = n * (n + 1) / 2;
		for (int i = 0; i < n; i++) {
			sum = sum - nums[i];
		}
		return sum;
	}
	
	// Approach-2 (XOR)
	// T.C: O(n)
	// S.C: O(1)
	public static int missingNumberUsingXor(int[] nums) {
		int sum = nums.length;
		for (int i = 0; i < nums.length; i++) {
			sum = sum ^ i;
			sum = sum ^ nums[i];
		}
		return sum;
	}
	
	// Approach-3 (Binary Search)
	// T.C: O(nlogn)
	// S.C: O(1)
	public static int missingNumberUsingBinarySearch(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        int mid = nums.length;
        int result = mid;
        
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (nums[mid] > mid) {
				result = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
        return result;
    }
}

/*

268. Missing Number

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

 

Constraints:

    n == nums.length
    1 <= n <= 104
    0 <= nums[i] <= n
    All the numbers of nums are unique.

 

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?


*/
