package hcom.logical.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CFindKClosest {
	public static void main(String[] args) {
        int[] arr = {10, 2, 14, 4, 7, 6};
        int x = 5, k = 3;

        List<Integer> res = findKClosest(arr, x, k);
        System.out.println("K closest elements: " + res);
    }

	private static List<Integer> findKClosest(int[] arr, int x, int k) {
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.diff - a.diff // Max heap based on difference
		);

		for (int num : arr) {
			int diff = Math.abs(num - x);
			maxHeap.offer(new Pair(num, diff));

			if (maxHeap.size() > k) {
				maxHeap.poll(); // remove farthest
			}
		}

		// Extract results
		List<Integer> result = new ArrayList<>();
		for (Pair p : maxHeap) {
			result.add(p.val);
		}
		return result;
	}

	
	static class Pair {
		int val;
		int diff;

		Pair(int val, int diff) {
			this.val = val;
			this.diff = diff;
		}
	}
	 
}
/*
Given an unsorted array arr[] and two number X and K, the task is to find K closest values
to X in arr[]


Given:
    An unsorted array arr[]
    A number X
    A number K
Your task is to find the K elements in the array that are closest to X (based on absolute difference).
Sort this array in O(n log k) time.
Space Complexity	O(k)


We can use a max heap of size K to keep track of the K closest elements based on absolute difference from X.
*/