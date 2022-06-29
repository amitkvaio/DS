package leet.code.sorting;

import java.util.Arrays;

//45
public class ASelectionSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 64, 34, 25, 12, 22, 11, 90 };
		selectionSort(arr);
	}

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		int smallest;
		for (int i = 0; i <= n - 2; i++) {
			smallest = i;
			for (int j = i + 1; j <= n - 1; j++) {
				if (arr[j] < arr[smallest]) {
					smallest = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
