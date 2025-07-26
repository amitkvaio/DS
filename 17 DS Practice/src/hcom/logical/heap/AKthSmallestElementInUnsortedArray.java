package hcom.logical.heap;

import java.util.PriorityQueue;

public class AKthSmallestElementInUnsortedArray {
	public static void main(String[] args) {
		int[] nums = { 7, 10, 4, 3, 20, 15 };
		int k = 3;

		System.out.println("Kth smallest element is: " + findKthSmallest(nums, k));
	}
	
	public static int findKthSmallest(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
		for (int num : arr) {
			maxHeap.offer(num);

			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return maxHeap.peek();
	}
}
/*
You are given:
    An array of distinct integers
    An integer K such that K < array.length
	Your task is to return the Kth smallest element in the array.

TC : O(nlogk)
SC : O(k)

Kth smallest element is: 7

*/