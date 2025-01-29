package com.leetcode.easy.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//27. Intersection of Two Arrays | 4 Approaches | Leetcode 349
public class Aintersection {
	public static void main(String[] args) {
		System.out.println("***************Using two set*******************************");
		System.out.println(Arrays.toString(intersectionUsingTwoSet(new int[] {1,2,2,1}, new int[] {2,2})));//[2]
		System.out.println(Arrays.toString(intersectionUsingTwoSet(new int[] {4,9,5}, new int[] {9,4,9,8,4})));//[9,4]
		System.out.println("***************Using one set*******************************");
		System.out.println(Arrays.toString(intersectionOneSet(new int[] {1,2,2,1}, new int[] {2,2})));
		System.out.println(Arrays.toString(intersectionOneSet(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
		System.out.println("*********************Using Binary Search*************************");
		System.out.println(Arrays.toString(intersectionUsingBinarySearch(new int[] {1,2,2,1}, new int[] {2,2})));
		System.out.println(Arrays.toString(intersectionUsingBinarySearch(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
		System.out.println("***************Using two pointer*******************************");
		System.out.println(Arrays.toString(intersectionUsingTwoPointer(new int[] {1,2,2,1}, new int[] {2,2})));
		System.out.println(Arrays.toString(intersectionUsingTwoPointer(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
	}
	
	//Approach-1 (Using two sets)
	//T.C : O(m+n)
	//S.C : O(m+n)
	public static int[] intersectionUsingTwoSet(int[] nums1, int[] nums2) {
		Set<Integer> st1 = new HashSet<>();
		Set<Integer> st2 = new HashSet<>();

		for (int i = 0; i < nums1.length; i++) {
			st1.add(nums1[i]);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (st1.contains(nums2[i])) {
				st2.add(nums2[i]);
			}
		}

		int[] result = new int[st2.size()];
		int i = 0;
		for (Integer num : st2) {
			result[i++] = num;
		}
		return result;
	}
	
	//Approach-2 (Using one set)
	//T.C : O(m+n)
	//S.C : O(m+n)
	public static int[] intersectionOneSet(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
		List<Integer> result = new ArrayList<>();

		for (int num : nums1) {
			set.add(num);
		}

		for (int num : nums2) {
			if (set.contains(num)) {
				result.add(num);
				set.remove(num);
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	
	//Approach-3 (Sorting and binary search)
	//T.C : O(n + mlogm)
	//S.C : O(n)
	public static boolean binarySearch(List<Integer> nums, int target) {
		int l = 0, r = nums.size() - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (nums.get(mid) == target) {
				return true;
			} else if (nums.get(mid) < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return false;
	}
	
	public static int[] intersectionUsingBinarySearch(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        List<Integer> nums1List = new ArrayList<>();
        for (int num : nums1) {
            nums1List.add(num);
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums2) {
            if (binarySearch(nums1List, num)) {
                set.add(num);
            }
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }
	
	//Approach-4 (Sorting and two-pointers)
	//T.C : O(n + m)
	//S.C : O(1)
	
	public static int[] intersectionUsingTwoPointer(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int m = nums1.length;
		int n = nums2.length;

		List<Integer> result = new ArrayList<>();
		int i = 0, j = 0;

		while (i < m && j < n) {
			if (nums1[i] == nums2[j]) {
				result.add(nums1[i]);

				while (i < m - 1 && nums1[i] == nums1[i + 1]) {
					i++;
				}
				while (j < n - 1 && nums2[j] == nums2[j + 1]) {
					j++;
				}
				i++;
				j++;

			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}
/*

https://leetcode.com/problems/intersection-of-two-arrays/description/
349. Intersection of Two Arrays.
Given two integer arrays nums1 and nums2, return an array of their
intersection
. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

 

Constraints:

    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000

*/