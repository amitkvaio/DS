package com.recursion;

//https://www.geeksforgeeks.org/problems/quick-sort/1
public class GQuickSort {
	public static void main(String[] args) {
		int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println("Original array:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

		quickSort(arr, 0, arr.length - 1);

		System.out.println("Sorted array:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	// Function to sort an array using quick sort algorithm.
	static void quickSort(int arr[], int low, int high) {
		if (low >= high) {
			return;
		}

		int pivotIndex = partition(arr, low, high);

		quickSort(arr, low, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, high);
	}

	static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int pivotIndex = low;

		for (int i = low; i < high; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, pivotIndex);
				pivotIndex++;
			}
		}

		swap(arr, pivotIndex, high);

		return pivotIndex;
	}

	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

//T.C : O(nlogn) in Average case, O(n^2) in worst case
//S.C : O(1) Auxiliary space