package com.amit.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
Find a pair with the given sum in an array
Count pairs with given sum
Input:
 
nums = [8, 7, 2, 5, 3, 1]
target = 10
 
Output:
 
Pair found (8, 2)
or
Pair found (7, 3)
 
 
Input:
 
nums = [5, 2, 6, 8, 1, 9]
target = 12
 
Output: Pair not found 

Given array : [2, 4, 3, 5, 6, -2, 4, 7, 8, 9]
Given sum : 7
Integer numbers, whose sum is equal to value : 7
(2, 5) 
(4, 3) 
(-2, 9)



*/
public class Array05 {
	public static void main(String args[]) {
       // int[] nums = { 8, 7, 2, 5, 3, 1 };
	   //int target = 9;
		 
        int[] nums = {2, 4, 3, 5, 6, -2, 7, 8, 9};
        int target = 7;
        findPair(nums, target);
        System.out.println("************ Using Hashmap **************");
        findPairUsingHashMap(nums, target);
        System.out.println("************ using sort **************");
        findPairsUsingSort(nums,target);
        
	}

	// using Using Brute-Force-Naive method to find a pair in an array with a given sum
	// TC : O(n*n)
	public static void findPair(int[] nums, int target) {
		boolean isPairFound =true;
		int pairCount=0;
		// consider each element except the last
		for (int i = 0; i < nums.length - 1; i++) {
			// start from the i'th element until the last element
			for (int j = i + 1; j < nums.length; j++) {
				// if the desired sum is found, print it
				if (nums[i] + nums[j] == target) {
					System.out.println("Pair found (" + nums[i] + "," + nums[j] + ")");
					pairCount++;
					isPairFound=false;
				}
			}
		}
		System.out.println("Total number of pair found::"+pairCount);
		if(isPairFound) {
			System.out.println("Pair not found");
		}
	}
	
	
	// Function to find a pair in an array with a given sum using hashing
	// TC : O(n)
	public static void findPairUsingHashMap(int[] nums, int target) {
		// create an empty HashMap
		Map<Integer, Integer> map = new HashMap<>();
		boolean isPairFound =true;
		int pairCount=0;
		// do for each element
		for (int i = 0; i < nums.length; i++) {
			// check if pair (nums[i], target-nums[i]) exists
			// if the difference is seen before, print the pair
			if (map.containsKey(target - nums[i])) {
				System.out.printf("Pair found (%d, %d)", nums[map.get(target - nums[i])], nums[i]);
				System.out.println();
				pairCount++;
				isPairFound=false;
			}

			// store index of the current element in the map
			map.put(nums[i], i);
		}

		System.out.println("Total number of pair found::"+pairCount);
		if(isPairFound) {
			System.out.println("Pair not found");
		}
	}
	
	//TC : O(nlogn)
	private static void findPairsUsingSort(int[] arr, int target) {
		Arrays.sort(arr);
		int pairCount=0;
		int srt = 0;
		int end = arr.length - 1;
		while (srt < end) {
			int sum = arr[srt] + arr[end];
			if (sum == target) {
				System.out.println("Pair found (" + arr[srt] + "," + arr[end] + ")");
				srt++;
				end--;
				pairCount++;
			} else if (sum > target) {
				end--;
			} else if (sum < target) {
				srt++;
			}
		}
		System.out.println("Total number of pair found::"+pairCount);
	}
}



/*

1. Using Brute-Force
A naive solution is to consider every pair in the given array and return if the desired sum is found. 


*/