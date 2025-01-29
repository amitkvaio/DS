package acom.sorting;

import java.util.Arrays;

public class CInsertionSort {
	public static void main(String[] args) {
		int [] arr = new int[] {10, 40, 50, 30, 20};
		//						0    1   2   3   4
		System.out.println("Befor Sorting : " + Arrays.toString(arr));
		insertionSort1(arr);
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
	
	public static void insertionSort1(int[] arr) {
		for (int i = 1 ; i < arr.length; i++) {
			 //lets consider the first index value is already sorted.
			int key = arr[i];
			int j = i - 1 ;
			while(j >=0 && arr[j] > key ) {
				arr[j+1] = arr[j];
				j = j - 1;
			}
			arr[j+1] = key;
		}
	}

}

/*
Time Complexity
Best case: O(n)
Average case: O(n^2)
Worst case: O(n^2)
*/