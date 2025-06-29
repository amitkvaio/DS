package acom.sorting;

import java.util.Arrays;

public class CInsertionSort {
	public static void main(String[] args) {
		int [] arr = new int[] {10, 40, 50, 30, 20};
		//						0    1   2   3   4
		System.out.println("Befor Sorting : " + Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("After Sorting : " + Arrays.toString(arr));
	}

	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			// Current element to be inserted into the sorted portion
			int key = arr[i];
			int j = i - 1;

			// Move elements of arr[0..i-1] that are greater than key
			// to one position ahead of their current position
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}

			// Place the key in its correct position
			arr[j + 1] = key;
		}
	}

}

/*
Insertion Sorting
******************
Insertion Sort works by virtually dividing the array into a sorted and an unsorted part.
Elements from the unsorted part are picked one by one and inserted into 
	their correct position in the sorted part.

Time Complexity
Best case: O(n)
Average case: O(n^2)
Worst case: O(n^2)
SC : O(1)
*/