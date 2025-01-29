package com.leetcode.easy.a;

import java.util.Arrays;

//25. Count Elements With Maximum Frequency | One Pass | Two Pass | Leetcode 3005
public class YmaxFrequencyElements {
	public static void main(String[] args) {
		System.out.println(maxFrequencyElements(new int[] {1,2,2,3,1,4}));//4
		System.out.println(maxFrequencyElements(new int[] {1,2,3,4,5}));//5
		System.out.println("***********************************************");
		System.out.println(maxFrequencyElementsUsingOnePass(new int[] {1,2,2,3,1,4}));//4
		System.out.println(maxFrequencyElementsUsingOnePass(new int[] {1,2,3,4,5}));//5
	}
	
	//Approach-1 (Using 2 Pass)
	//T.C : O(n)
	//S.C : O(1)
	public static int maxFrequencyElements(int[] nums) {
		int[] arr = new int[101];

		int maxFreq = 0;

		for (int num : nums) {
			arr[num] = arr[num] + 1;
			maxFreq = Math.max(maxFreq, arr[num]);
		}
		int result = 0 ;
		
		for(int i = 0 ; i < 101 ; i++) {
			if(arr[i] == maxFreq) {
				result = result + maxFreq;
			}
		}
		return result;
		//final int finalMaxFreq = maxFreq; // why final keyword ? To access inside lambda
		//return (int) Arrays.stream(arr).filter(count -> count == finalMaxFreq).count() * finalMaxFreq;
	}
	
	//Approach-2 (Using 1 Pass)
	//T.C : O(n)
	//S.C : O(1)
	public static int maxFrequencyElementsUsingOnePass(int[] nums) {
		int[] arr = new int[101];

		int maxFreq = 0;
		int total = 0;

		for (int num : nums) {
			arr[num] = arr[num] +1;

			int freq = arr[num];

			if (freq > maxFreq) {
				maxFreq = freq;
				total = freq;
			} else if (freq == maxFreq) {
				total = total + freq;
			}
		}
		return total;
	}
}
/*
3005. Count Elements with maximum frequency.

You are given an array nums consisting of positive integers.

Return the total frequencies of elements in nums such that those elements all have the maximum frequency.

The frequency of an element is the number of occurrences of that element in the array.

 

Example 1:

Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.

Example 2:

Input: nums = [1,2,3,4,5]
Output: 5
Explanation: All elements of the array have a frequency of 1 which is the maximum.
So the number of elements in the array with maximum frequency is 5.

 

Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100

*/
