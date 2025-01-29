package com.leetcode.easy.a;

import java.util.Arrays;
//11. Maximum Product Difference Between Two Pairs | 2 Simple Approaches | Leetcode-1913
public class KMaxProductDifference {
	public static void main(String[] args) {
		int [] nums1 = {5,6,2,7,4};
		int [] nums2 = {4,2,5,9,7,4,8};
		
		System.out.println(maxProductDifferenceUsingSort(nums1));
		System.out.println(maxProductDifferenceUsingSort(nums2));
		System.out.println("*************************");
		System.out.println(maxProductDifference(nums1));
		System.out.println(maxProductDifference(nums2));
	}
	
	//Approach-1 (Using sorting)
	//T.C : O(nlogn) 
	//S.C : O(1)
	public static int maxProductDifferenceUsingSort(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		return (nums[n - 1] * nums[n - 2]) - (nums[1] * nums[0]);
	}
	
	//Approach-2 (Without sorting)
	//T.C : O(n) 
	//S.C : O(1)
	public static int maxProductDifference(int[] nums) {
	    int firstHighest = Integer.MIN_VALUE;
	    int secondHighest = Integer.MIN_VALUE ;
	     
	    int firstLowest = Integer.MAX_VALUE ;
	    int secondLowest = Integer.MAX_VALUE  ;
	    
	    for (int i = 0 ; i < nums.length ; i++) {
	    	if(firstHighest < nums[i]) {
	    		secondHighest = firstHighest;
	    		firstHighest = nums[i];
	    	}else if(secondHighest < nums[i]) {
	    		secondHighest = nums[i];
	    	}
	    	
	    	if(nums[i] < firstLowest) {
	    		secondLowest = firstLowest;
	    		firstLowest = nums[i];
	    	}else if(nums[i] < secondLowest) {
	    		secondLowest = nums[i];
	    	}
	    }		
	    return (firstHighest * secondHighest) - (firstLowest * secondLowest);
	}
}


/*
The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).

    For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.

Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference between 
	pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.

Return the maximum such product difference.

 
Example 1:

Input: nums = [5,6,2,7,4]
Output: 34
Explanation: We can choose indices 1 and 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
The product difference is (6 * 7) - (2 * 4) = 34.

Example 2:

Input: nums = [4,2,5,9,7,4,8]
Output: 64
Explanation: We can choose indices 3 and 6 for the first pair (9, 8) and indices 1 and 5 for the second pair (2, 4).
The product difference is (9 * 8) - (2 * 4) = 64.

 

Constraints:

    4 <= nums.length <= 104
    1 <= nums[i] <= 104

*/
