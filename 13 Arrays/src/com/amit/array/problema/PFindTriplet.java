package com.amit.array.problema;

import java.util.Arrays;
import java.util.HashSet;

/*

Find a triplet with the given sum in an array
Given an unsorted integer array, find a triplet with a given sum in it.
Input:
nums = [ 2, 7, 4, 0, 9, 5, 1, 3 ]
target = 6
Output: Triplet exists. 
The triplets with the given sum 6 are {0, 1, 5}, {0, 2, 4}, {1, 2, 3}


There are three methods through which you can find array triplets whose sum is equal to given number.

Brute Force Method
	Complexity Analysis: 
	Time Complexity: O(n3). 
	As three nested for loops have been used.
	Auxiliary Space: O(1). 
	As no data structure has been used for storing values.
*************************************************************
Using HashSet
	Time complexity: O(N^2) 
	Auxiliary Space: O(N)
************************************************************
Using Sorting
  This method uses the method of Sorting and Two-pointer Technique to solve the above problem. 
  This execution will involve O(n2)) time complexity and O(1) space complexity.   
   

*/
public class PFindTriplet {
	
	public static void main(String[] args) {
		getArrayTripletsUsingBruteForceMethod(new int[] { 7, 5, 9, 3, 0, 8, 6 }, 12);
		System.out.println("===========================");
		getArrayTripletsUsingBruteForceMethod(new int[] { -3, 7, -1, -5, 2, -9, 1 }, 0);
		System.out.println("===========================");
		getArrayTripletsUsingBruteForceMethod(new int[] { 17, 51, 39, 29, 33, 21, 65 }, 89);
		System.out.println("\n >>>>>>>>>>>>>>>>>>>>Using Hashset >>>>>>>>>>>>>>>>>>>>>>>>>\n");
		getArrayTripletsUsingHashSet(new int[] { 7, 5, 9, 3, 0, 8, 6 }, 12);
		System.out.println("===========================");
		getArrayTripletsUsingHashSet(new int[] { -3, 7, -1, -5, 2, -9, 1 }, 0);
		System.out.println("===========================");
		getArrayTripletsUsingHashSet(new int[] { 17, 51, 39, 29, 33, 21, 65 }, 89);
		System.out.println("\n>>>>>>>>>>>>>>>>>>>>Using Sorting >>>>>>>>>>>>>>>>>>>>>>>>>\n");
		getArrayTripletsUsingSorting(new int[] { 7, 5, 9, 3, 0, 8, 6 }, 12);
		System.out.println("===========================");
		getArrayTripletsUsingSorting(new int[] { -3, 7, -1, -5, 2, -9, 1 }, 0);
		System.out.println("===========================");
		getArrayTripletsUsingSorting(new int[] { 17, 51, 39, 29, 33, 21, 65 }, 89);
		
	}
	
	private static void getArrayTripletsUsingBruteForceMethod(int[] arr, int sum) {
		System.out.println("Array triplets whose sum is " + sum + " are :");

		// Method 1 : Using Brute Force Method
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == sum) {
						System.out.println("[" + arr[i] + ", " + arr[j] + ", " + arr[k] + "]");
					}
				}
			}
		}
	}
	
	private static void getArrayTripletsUsingHashSet(int[] arr, int sum) {
		System.out.println("Array triplets whose sum is " + sum + " are :");
		// Method 2 : Using HashSet
		for (int i = 0; i < arr.length - 1; i++) {
			HashSet<Integer> set = new HashSet<>();
			for (int j = i + 1; j < arr.length; j++) {
				if (set.contains(sum - arr[i] - arr[j])) {
					System.out.println("[" + arr[i] + ", " + arr[j] + ", "
							+ (sum - arr[i] - arr[j]) + "]");
				} else {
					set.add(arr[j]);
				}
			}
		}
	}
	
	private static void getArrayTripletsUsingSorting(int[] arr, int sum) {
		System.out.println("Array triplets whose sum is " + sum + " are :");
		// Method 3 : Using Sorting
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			int left = i + 1;
			int right = arr.length - 1;
			while (left < right) {
				if (arr[i] + arr[left] + arr[right] == sum) {
					System.out.println("[" + arr[i] + ", " + arr[left] + ", " + arr[right] + "]");
					left++;
					right--;
				} else if (arr[i] + arr[left] + arr[right] < sum) {
					left++;
				} else {
					right--;
				}
			}
		}
	}
}          
