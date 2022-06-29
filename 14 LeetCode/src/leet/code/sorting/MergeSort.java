package leet.code.sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 64, 34, 25, 12, 22, 11, 90, 10, 5 };
		mergeSort(arr);
	}

	private static void mergeSort(int[] arr) {

		if (arr.length < 2) {
			return;
		}

		int n = arr.length;
		int mid = n / 2;

		int[] left = new int[mid];
		int[] right = new int[n - mid];

		for (int i = 0; i <= mid - 1; i++) {
			left[i] = arr[i];
		}

		for (int i = mid; i <= n - 1; i++) {
			right[i - mid] = arr[i];
		}
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		mergeSort(left);
		mergeSort(right);
		sort(arr, left, right);
	}

	private static void sort(int arr[], int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		int l = left.length;
		int r = right.length;
		while (i < l && j < r) {
			if (left[i] < right[j]) {
				arr[k++] = left[i];
				i++;
			} else {
				arr[k++] = right[j];
				j++;
			}
		}

		while (i < l) {
			arr[k++] = left[i];
			i++;
		}

		while (j < r) {
			arr[k++] = right[j];
			j++;
		}
		System.out.println(Arrays.toString(arr));
	}
}
