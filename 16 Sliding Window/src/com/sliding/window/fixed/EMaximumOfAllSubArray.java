package com.sliding.window.fixed;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
Output: [3, 3, 4, 5, 5, 5, 6] 
Explanation: 
1st contiguous subarray = [1 2 3] max = 3
2nd contiguous subarray = [2 3 1] max = 3
3rd contiguous subarray = [3 1 4] max = 4
4th contiguous subarray = [1 4 5] max = 5
5th contiguous subarray = [4 5 2] max = 5
6th contiguous subarray = [5 2 3] max = 5
7th contiguous subarray = [2 3 6] max = 6

Input: arr[] = [5, 1, 3, 4, 2, 6], k = 1
Output: [5, 1, 3, 4, 2, 6]
Explanation: When k = 1, each element in the array is its own subarray, 
	so the output is simply the same array.

Input: arr[] = [1, 3, 2, 1, 7, 3], k = 3
Output: [3, 3, 7, 7]
*/
public class EMaximumOfAllSubArray {
	public static void main(String[] args) {
		
		System.out.println(getMaximumOfAllSubArray(new int[] { 1, 2, 3, 1, 4, 5, 2, 3, 6 }, 3));
		System.out.println(getMaximumOfAllSubArray(new int[] { 5, 1, 3, 4, 2, 6 }, 1));
		System.out.println(getMaximumOfAllSubArray(new int[] { 1, 3, 2, 1, 7, 3 }, 3));
	}

	public static ArrayList<Integer> getMaximumOfAllSubArray(int[] arr, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = arr.length;
		if (n < k) {
			return list;
		}

		int i = 0, j = 0;
		Deque<Integer> queue = new LinkedList<Integer>();

		while (j < n) {

			// Remove all smaller elements from the back
	        while (!queue.isEmpty() && queue.peekLast() < arr[j]) {
	            queue.pollLast();
	        }
			
	        //Add current element to the deque
	        queue.add(arr[j]);

			if ((j - i + 1) < k) {
				j++;
			} else if ((j - i + 1) == k) {

				// Add front of the deque to result (maximum of window)
				list.add(queue.peekFirst());

				// Remove the element going out of window from the front
				if (!queue.isEmpty() && arr[i] == queue.getFirst()) {
					queue.pollFirst();
				}
				
				//Slide the window
				i++;
				j++;
			}
		}
		return list;
	}
}
/*
Time Complexity	O(n)
The Deque stores at most k elements (size of the sliding window).
The ArrayList stores n - k + 1 maximum values.
Space Complexity: O(n - k + 1) for the result list
*/