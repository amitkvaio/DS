package com.amit.array;
/*
Find minimum element in a sorted and rotated array
int arr[]={16,19,21,25,3,5,8,10};
minimum : 3
We need to find minimum element in above array in o(log n) time complexity. 
Assume that duplicates are not allowed in the array.
*/
public class Arrays11 {
	public static void main(String[] args) {
		int arr[] = { 16, 19, 21, 25, 3, 5, 8, 10 };
		System.out.println(
				"Minimum element in the array : " + findMinimumElementRotatedSortedArray(arr, 0, arr.length - 1));
	}

	public static int findMinimumElementRotatedSortedArray(int[] arr, int low, int high) {
		int mid;
		while (low < high) {
			mid = (low+high)/2;
			if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return arr[low];
	}

}
