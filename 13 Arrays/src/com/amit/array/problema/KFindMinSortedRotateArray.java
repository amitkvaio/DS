package com.amit.array.problema;

/*
Find minimum element in a sorted and rotated array
int arr[]={16,19,21,25,3,5,8,10};
minimum : 3
We need to find minimum element in above array in o(log n) time complexity. 
Assume that duplicates are not allowed in the array.
*/
public class KFindMinSortedRotateArray {
	public static void main(String[] args) {
		int arr[] = { 16, 19, 21, 25, 3, 5, 8, 10 };
		System.out
				.println("Minimum element in the array : " + findMinimumElementRotatedSortedArray(arr, 0, arr.length));
		System.out
		.println("Minimum element in the array : " + findMinimumElementRotatedSortedArray1(arr));
	}

	public static int findMinimumElementRotatedSortedArray(int[] arr, int low, int high) {
		int mid;
		high = high - 1;
		while (low < high) {
			mid = (low + high) / 2;
			if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return arr[low];
	}

	public static int findMinimumElementRotatedSortedArray1(int[] arr) {
		int mid;
		int n = arr.length;
		int start = 0;
		int end = n - 1;
		int pre;
		int next;
		while (start <= end) {
			mid = (start + end) / 2;
			pre = (mid - 1);
			next = (mid + 1);
			if (arr[mid] <= arr[pre] && arr[mid] <= arr[next]) {
				return arr[mid];
			} if (arr[mid] <= arr[end]) {
				end = mid - 1;
			} else if (arr[mid] >= arr[start]) {
				start = mid + 1 ;
			}
		}
		return -1;
	}

}
