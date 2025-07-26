package com.sliding.window.fixed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CFirstNegNumInEveryWindows {
	public static void main(String[] args) {

		getFirstNegNumInEveryWindowNaiveApproach(new int[] { -8, 2, 3, -6, 10 }, 2);// [-8, 0, -6, -6]
		getFirstNegNumInEveryWindowNaiveApproach(new int[] { 12, -1, -7, 8, -15, 30, 16, 28 }, 3);// [-1, -1, -7, -15,
																									// -15, 0]
		System.out.println("################################################################");
		getFirstNegNumInEveryWindow(new int[] { -8, 2, 3, -6, 10 }, 2);// [-8, 0, -6, -6]
		getFirstNegNumInEveryWindow(new int[] { 12, -1, -7, 8, -15, 30, 16, 28 }, 3);// [-1, -1, -7, -15, -15, 0]
	}

	private static void getFirstNegNumInEveryWindow(int[] arr, int k) {
		int start = 0;
		int n = arr.length;
		List<Integer> output = new ArrayList<>();

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int end = 0; end < n; end++) {

			if (arr[end] < 0) {
				queue.offer(arr[end]);
			}

			if ((end - start + 1) == k) {
				// Add the first negative number in current window, or 0 if none
				if (!queue.isEmpty()) {
					output.add(queue.peek());
				} else {
					output.add(0);
				}

				// Before sliding the window, remove the element at 'start' if it's the same as
				// the front of the queue
				if (!queue.isEmpty() && arr[start] == queue.peek()) {
					queue.poll();
				}

				// Slide the window
				start++;
			}
		}
		System.out.println(output);
	}

	// O(n*k) time and O(1) space
	public static void getFirstNegNumInEveryWindowNaiveApproach(int[] arr, int k) {
		int n = arr.length;
		List<Integer> output = new ArrayList<>();

		for (int i = 0; i <= n - k; i++) {
			boolean found = false;
			for (int j = 0; j < k; j++) {
				if (arr[i + j] < 0) {
					output.add(arr[i + j]);
					found = true;
					break;
				}
			}
			if (!found) {
				output.add(0);
			}
		}
		System.out.println(output);
	}
}
/*
 Time & Space Complexity:
Time Complexity: O(n)
(Each element is visited once and added/removed from the queue at most once.)

Space Complexity: O(k)
(Queue holds at most k negative numbers from the current window.)
*/
