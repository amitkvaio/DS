package com.recursion;

public class FMergeSort {
	public static void main(String[] args) {
		int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println("Original array:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

		mergeSort(arr, 0, arr.length - 1);

		System.out.println("Sorted array:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	static void  mergeSort(int arr[], int sIdx, int eIdx) {

		if (sIdx >= eIdx) {
			return;
		}

		int mid = sIdx + (eIdx - sIdx) / 2;

		mergeSort(arr, sIdx, mid);
		mergeSort(arr, mid + 1, eIdx);

		merge(arr, sIdx, mid, eIdx);
	}

	static void merge(int arr[], int sIdx, int m, int eIdx) {
		int n1 = m - sIdx + 1;
		int n2 = eIdx - m;

		// Create temporary arrays to store the two halves
		int L[] = new int[n1];
		int R[] = new int[n2];
		int k = sIdx;
		// Copy data to temporary arrays L[] and R[]
		for (int i = 0; i < n1; i++)
			L[i] = arr[k++];
		for (int j = 0; j < n2; j++)
			R[j] = arr[k++];

		// Merge the temporary arrays back into arr[l..r]
		int i = 0; // Initial index of first subarray
		int j = 0; // Initial index of second subarray
		k = sIdx; // Initial index of merged subarray

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy the remaining elements of L[], if there are any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Copy the remaining elements of R[], if there are any
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}

/*
https://www.geeksforgeeks.org/problems/merge-sort/1
*/