package com.leetcode.easy.a;

import java.util.HashSet;
import java.util.Set;

//26. Minimum Common Value | 3 Approaches | Leetcode 2540
public class ZGetCommon {
	public static void main(String[] args) {
		System.out.println(getCommon(new int[] {1,2,3}, new int[] {2,4}));//2
		System.out.println(getCommon(new int[] {1,2,3,6}, new int[] {2,3,4,5}));//2
		System.out.println("*********************Using Binary Search******************************");
		System.out.println(getCommonUsingBSearch(new int[] {1,2,3}, new int[] {2,4}));
		System.out.println(getCommonUsingBSearch(new int[] {1,2,3,6}, new int[] {2,3,4,5}));
		System.out.println("*********************Using Two Pointer******************************");
		System.out.println(getCommonUsingTwoPointer(new int[] {1,2,3}, new int[] {2,4}));
		System.out.println(getCommonUsingTwoPointer(new int[] {1,2,3,6}, new int[] {2,3,4,5}));
		
	}
	
	// Approach-1 (Using set)
	// T.C : O(m+n)
	// S.C : O(m)
	public static int getCommon(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}

		for (int num : nums2) {
			if (set.contains(num)) {
				return num;
			}
		}
		return -1;
	}
	
	// Approach-2 (Using Binary Search)
	// T.C : O(mlogn)
	// S.C : O(1)
	public static boolean binarySearch(int[] nums, int target) {
		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (nums[mid] == target) {
				return true;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return false;
	}
	
	public static int getCommonUsingBSearch(int[] nums1, int[] nums2) {
		for (int num : nums1) {
			if (binarySearch(nums2, num)) {
				return num;
			}
		}
		return -1;
	}
	
	// Approach-3 (Using 2 Pointer)//Best Approach
	// T.C : O(m+n)
	// S.C : O(1)
	public static int getCommonUsingTwoPointer(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		int i = 0; // for nums1
		int j = 0; // for nums2

		while (i < m && j < n) {
			if (nums1[i] == nums2[j]) {
				return nums1[i];
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		return -1;
	}
}
/*
2540. Minimum Common Value.
https://leetcode.com/problems/minimum-common-value/description/
Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.

Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.

 

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4]
Output: 2
Explanation: The smallest element common to both arrays is 2, so we return 2.

Example 2:

Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
Output: 2
Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.

 

Constraints:

    1 <= nums1.length, nums2.length <= 105
    1 <= nums1[i], nums2[j] <= 109
    Both nums1 and nums2 are sorted in non-decreasing order.

*/