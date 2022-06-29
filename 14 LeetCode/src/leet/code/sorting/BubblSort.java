package leet.code.sorting;

import java.util.Arrays;

public class BubblSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 64, 34, 25, 12, 22, 11, 90 };
		bubbleSort(arr);
		System.out.println("*******************************");
		int[] ar = new int[] { 10, 15, 20, 35, 50, 90 };
		bubbleSortForSortedArray(ar);
	}

	private static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp;
		for (int i = 0; i <= n - 1; i++) {
			for (int j = 1; j <= n - 2 - i; j++) {
				if (arr[j-1] > arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	//TC = O(N*N) SC = O(1)
	
	//if the provided array is already shorted then we can optimize the TC
	private static void bubbleSortForSortedArray(int[] arr) {
		int n = arr.length;
		int temp;
		boolean flag = true;
		for (int i = 0; i <= n - 1; i++) {
			for (int j = 1; j <= n - 2 - i; j++) {
				if (arr[j-1] > arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					flag = false;
					System.out.println("Flag ::"+flag);
				}
			}
			if(flag) {
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
