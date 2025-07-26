package bcom.logical.arrays;

import java.util.PriorityQueue;

public class IKthLargestElementInAnArray {
	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		int result = findKthLargest(nums, k);
		System.out.println("The " + k + "th largest element is: " + result);
	}

	private static int findKthLargest(int[] nums, int k) {
		//Min-heap to store k largest elements
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for (int num : nums) {
			minHeap.offer(num); // add to heap
			if (minHeap.size() > k) {
				minHeap.poll(); // remove smallest
			}
		}
		
		// Top of heap is kth largest
        return minHeap.peek();
	}
}

/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

use a min-heap of size k to track the k largest elements.
    If heap size > k → remove the smallest
    The top of the heap will be the kth largest element

Time: O(n log k)
Space: O(k)

*/
