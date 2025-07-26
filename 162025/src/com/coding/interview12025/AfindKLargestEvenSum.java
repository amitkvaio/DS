package com.coding.interview12025;
import java.util.*;
/*
Java program to find the sum of the K largest even numbers from the input array. If K is too large, it returns -1.
arr = {1, 2, 4, 6, 34, 8, 10, 9, 56}
k = 2
Sum of 2 largest even numbers: 90
*/
 
public class AfindKLargestEvenSum {

	public static int findKLargestEvenSum(int[] arr, int k) {
		List<Integer> evenNumbers = new ArrayList<>();

		// Collect all even numbers
		for (int num : arr) {
			if (num % 2 == 0) {
				evenNumbers.add(num);
			}
		}

		// If k is greater than the number of even elements, return -1
		if (k > evenNumbers.size()) {
			return -1;
		}

		// Sort even numbers in descending order
		Collections.sort(evenNumbers, Collections.reverseOrder());

		// Sum up the K largest even numbers
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum = sum + evenNumbers.get(i);
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 6, 34, 8, 10, 9, 56 };
		int k = 2;

		int result = findKLargestEvenSum(arr, k);
		System.out.println("Sum of " + k + " largest even numbers: " + result);
	}
}
/*
How would you optimize the solution for a very large array?

Instead of sorting the entire list, we can use a Min Heap (Priority Queue) 
	of size K to store the largest K even numbers. 
This reduces sorting overhead from O(N log N) to O(N log K).
*/
