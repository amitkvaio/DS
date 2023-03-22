package com.amit.array.problema;
/*
You are given an sorted and rotated array as below

int arr[]={16,19,21,25,3,5,8,10};
We need to search an element in above array in o(log n) time complexity.
*/
public class JSeachAnInSortedRotatedArray {
	public static void main(String[] args) {
		int arr[] = { 16, 19, 21, 25, 3, 5, 8, 10 };
		int value = 10;
		int index = findElementRotatedSortedArraytest(arr, 0, arr.length - 1, value);
		System.out.println("Index of element : " + value + "@" + index);
	}

	public static int findElementRotatedSortedArray(int[] arr, int low, int high, int number) {
		int mid;
		while (low < high) {
			mid = (low + high)/2 ;

			if (arr[mid] == number) {
				return mid;
			}
			if (arr[mid] <= arr[high]) {
				// Right part is sorted
				if (number > arr[mid] && number <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				// Left part is sorted
				if (number>=arr[low] && number < arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
	
	public static int findElementRotatedSortedArraytest
		(int[] arr, int low, int high, int number) {
		int mid;
		while (low <= high) {
			mid = (low + high)/2 ;

			if (arr[mid] == number) {
				return mid;
			}
			if(arr[mid] > arr[high]) {
				// Right part is sorted
					if(arr[mid] > number && number <= arr[high]) {
						low = mid +1;
					}else 
						high = mid -1;
			} else {
				// Left part is sorted
				if(number >= arr[low] && number < arr[mid]) {
					high = mid-1;
				}else 
					low = mid +1;
			}
		}
		return -1;
	}
}
