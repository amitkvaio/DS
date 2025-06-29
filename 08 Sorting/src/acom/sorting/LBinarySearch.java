package acom.sorting;

public class LBinarySearch {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		 
		int index = binarySearch(arr, arr.length, 30);
		if (index >= 0) {
			System.out.println("Number is present at index values :" + index);
		} else {
			System.out.println("Sorry!! Given number is not present in the list.");
		}
	}

	public static int binarySearch(int[] arr, int size, int target) {
		int low, high, mid;
		low = 0;
		high = size - 1;
		while (low <= high) {
			mid = low + (high - low) / 2; // to avoid potential overflow.
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else if (arr[mid] > target) {
				high = mid - 1;
			}
		}
		return -1;
	}
}
/*
Given array should be in sorted order.
TC: O(N)
SC : O(1)
*/