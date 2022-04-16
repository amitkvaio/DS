package com.amit.array;
/*
Find first repeating element in an array of integers
Input: array[] = {10, 7, 8, 1, 8, 7, 6}
Output: 7 [7 is the first element actually repeats]
**********************************************************
Simple solution will be use two loops. 
Outer loop will iterate through loop and inner loop will check if element is repeated or not 
but time complexity of this solution will be o(n^2)
********************************************************
Another solution will be to create another array and sort it.
Pick element from original array and find the element in sorted array using binary search 
but time complexity of this solution will be o(n^logn).
********************************************************
we can iterate from right to left and use HashSet to keep track for minimumIndex
The time complexity of this solution is O(n) and space complexity is also O(n).
*/

import java.util.HashSet;

public class Arrays22 {
	
	public static void main(String[] args) throws java.lang.Exception {
		int array[] = { 10, 7, 8, 1, 8, 7, 6 };
		int min = getFirstRepeatingElementArray(array);
		// Print the result
		if (min != -1)
			System.out.println("The first repeating element in array is " + array[min]);
		else
			System.out.println("There are no repeating elements");
	}
	
	static int getFirstRepeatingElementArray(int arr[]) {
		// Initialize index of first repeating element
		int minimumIndex = -1;

		// Creates an empty hashset
		HashSet<Integer> set = new HashSet<>();

		// Iterate over the input array from right to left
		for (int i = 0; i < arr.length ; i++) {
			// If set contains the element, update minimum index
			if (set.contains(arr[i])) {
				minimumIndex = i;
				break;
			}else // Else add element to hash set
				set.add(arr[i]);
		}
		return minimumIndex;
	}

	
}
