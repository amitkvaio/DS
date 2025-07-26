package bcom.logical.arrays;

public class JIncreaseTripletSubsequence {
	public static void main(String[] args) {
		int[] nums = {5, 0, 4, 6};
        System.out.println(increasingTriplet(nums)); // Output: true
	}

	private static boolean increasingTriplet(int[] arr) {
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		
		for (int num : arr) {
			if (num <= first)
				first = num; // new smallest
			else if (num <= second)
				second = num; // new second smallest
			else
				return true; // Found third number greater than both
		}
		
		return false;
	}
}


/*
Given an integer array nums, return true if there esists a triple of indices 
(i,j,k) such that i< j < j and num[i] < nums[j] < nums[k]
if no such indices exists, return false.

input = {5, 0, 4, 6 }
output = true

O(n) Time, O(1) Space

first → smallest so far
second → second smallest (larger than first)

Summary Table:
Step	num	first	second	Condition Met
1		5	5		∞		first = 5
2		0	0		∞		first = 0
3		4	0		4		second = 4
4		6	0		4		6 > second → ✅ triplet!

*/
