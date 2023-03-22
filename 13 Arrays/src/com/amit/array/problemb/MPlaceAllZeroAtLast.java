package com.amit.array.problemb;

import java.util.Arrays;

/*
int[] arr = { 7, 0, 6, 0, 1, 0, 0, 2 };
output = arr = {7,6,1,2,0,0,0,0}
Time Complexity: O(n) where n is number of elements in input array.
Auxiliary Space: O(1)
*/
public class MPlaceAllZeroAtLast {
	public static void main(String[] args) {
		int[] arr = { 7, 0, 6, 0, 1, 0, 0, 2 };
		int n = arr.length;
		int count = 0;
		
        // Traverse the array. If element encountered is non-zero, then replace the element at index 'count'
        // with this element
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}

		
		/*
		  Now all non-zero elements have been shifted to front and 'count' is set as
		  index of first 0. Make all elements 0 from count to end.
		 */
		while (count < n) {
			arr[count++] = 0;
		}
		System.out.println(Arrays.toString(arr));
	}
}
