package bcom.logical.arrays;

import java.util.Arrays;

public class BDutchNationalFlagAlgoritham {
	public static void main(String[] args) {
		int [] arr = {0,1,2,0,0,2,1,2,0,1};
		int [] res = sortUsingDutchNationalFlagAlog(arr);
		System.out.println(Arrays.toString(res));
	}

	private static int[] sortUsingDutchNationalFlagAlog(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;

		while (mid <= end) {
			if (arr[mid] == 0) {
				// swap with mid and start and increment both
				swap(arr, start, mid);
				mid++;
				start++;
			} else if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] == 2) {
				swap(arr, mid, end);
				end--;
				// swap with mid and end, decrement end
			}
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i] ;
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
/*
TC : O(n)
SC : 0(1)

*/
