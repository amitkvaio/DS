package com.coding.interview12025;
import java.util.PriorityQueue;
/*
Using PriorityQueue
Java program to find the sum of the K largest even numbers from the input array. If K is too large, it returns -1.
arr = {1, 2, 4, 6, 34, 8, 10, 9, 56}
k = 2
Sum of 2 largest even numbers: 90
*/

public class AfindKLargestEvenSum2 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 6, 34, 8, 10, 9, 56 };
		int k = 2;

		int result = findKLargestEvenSum(arr, k);
		System.out.println("Sum of " + k + " largest even numbers: " + result);
	}
	
	public static int findKLargestEvenSum(int[] arr, int k) {
		// Min heap to store the k largest even numbers
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		// Iterate through the array to find even numbers
		for (int num : arr) {
			if (num % 2 == 0) { // Check if even
				minHeap.add(num);
				if (minHeap.size() > k) {
					minHeap.poll(); // Remove the smallest element if heap exceeds size k
				}
			}
		}

		// If there are not enough even numbers, return -1
		if (minHeap.size() < k) {
			return -1;
		}

		// Sum the k largest even numbers
		int sum = 0;
		while (!minHeap.isEmpty()) {
			sum = sum + minHeap.poll();
		}

		return sum;
	}
}


/*
using a Min Heap (PriorityQueue) to efficiently find the sum of the K largest even numbers in an array. 
	This approach reduces the sorting overhead from O(N log N) to O(N log K).

*/