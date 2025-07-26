package hcom.logical.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BKSortedArraySorter  {
	 public static void main(String[] args) {
	        int[] arr = {6, 5, 3, 2, 8, 10, 9};
	        int k = 3;

	        sortKSortedArray(arr, k);

	        System.out.println("Sorted array:");
	        System.out.println(Arrays.toString(arr));
	    }

		private static void sortKSortedArray(int[] arr, int k) {
			PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
			int index = 0;
			// Step 1: Add first k+1 elements to heap
			for (int i = 0; i <= k && i < arr.length; i++) {
				minHeap.add(arr[i]);
			}

			// Step 2: For remaining elements
			for (int i = k + 1; i < arr.length; i++) {
				arr[index++] = minHeap.poll(); // extract min
				minHeap.add(arr[i]); // insert current
			}

			// Step 3: Extract remaining elements from heap
			while (!minHeap.isEmpty()) {
				arr[index++] = minHeap.poll();
			}
		}
}

/*
You are given an array of N elements.
Each element is at most K positions away from its correct sorted position.
Sort this array in O(n log k) time.
Space Complexity	O(k + 1)
*/
