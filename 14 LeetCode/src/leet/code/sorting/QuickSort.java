package leet.code.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 64, 34, 25, 12, 22, 11, 90, 10, 5 };
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int start, int end) {
		int parIndex = partition(arr, start, end);
		System.out.println(parIndex);
		if (start < parIndex - 1)
			quickSort(arr, start, parIndex - 1);
		if (parIndex < end)
			quickSort(arr, parIndex + 1, end);

	}

	private static int partition(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		int pivot = arr[mid];
		while (start <= end) {
			while (arr[start] < pivot) {
				start++;
			}
			while (arr[end] > pivot) {
				end--;
			}
			if (start <= end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
		return mid;
	}

}
