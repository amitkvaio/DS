package acom.sorting;

import java.util.Arrays;

public class BSelectionSort {
	public static void main(String[] args) {
		int [] arr = new int[] {64, 34, 25, 12, 22, 11, 90};
		System.out.println("Before Sorting : " + Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("After  Sorting : " + Arrays.toString(arr));
	}
	
	public static void selectionSort(int[] arr) {
		int n = arr.length;

		// Outer loop for each element in the array
		System.out.println("****************Outer loop Start*********************");
		for (int i = 0; i < n - 1; i++) {
			// Find the index of the minimum element in the unsorted portion
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			// Swap the found minimum element with the first unsorted element
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
			
			System.out.println("Smallest Number : " + temp + " : " + Arrays.toString(arr));
		}
		System.out.println("****************Outer loop end*********************");
	}
}

/*

How Selection Sort Works:
========================

Start with the first element and assume it is the minimum.

Compare it with all other elements in the unsorted portion of the array.

If a smaller element is found, update the minimum index.

At the end of the pass, swap the smallest element with the first unsorted element.

Move the boundary between the sorted and unsorted portions of the array by one element.
Repeat until the entire array is sorted.

Best case : O(N^2)
Average case : O(N^2)
Worst case : O(N^2)

*/


