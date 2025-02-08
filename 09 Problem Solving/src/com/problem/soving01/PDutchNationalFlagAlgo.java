package com.problem.soving01;

import java.util.Arrays;

public class PDutchNationalFlagAlgo {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 1, 2, 1, 0, 1, 0, 2, 1, 1, 2, 0 };
		System.out.println("Before Sorting : "+Arrays.toString(arr));
		dutchNationalFlagAlgoritham(arr);
		System.out.println("After Sorting  : "+Arrays.toString(arr));
	}
	
	public static void dutchNationalFlagAlgoritham(int[] arr) {
		int sIdx = 0;
		int mid = 0;
		int eIdx = arr.length - 1;

		while (mid <= eIdx) {
			int num = arr[mid];
			switch (num) {
			case 0:
				int temp = arr[sIdx];
				arr[sIdx] = arr[mid];
				arr[mid] = temp;
				sIdx++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				int temp1 = arr[eIdx];
				arr[eIdx] = arr[mid];
				arr[mid] = temp1;
				eIdx--;
				break;
			default:
				break;
			}
		}
	}
}
