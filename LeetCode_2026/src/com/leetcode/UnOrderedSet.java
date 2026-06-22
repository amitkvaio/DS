package com.leetcode;

import java.util.Arrays;

public class UnOrderedSet {
	public static void main(String[] args) {
		printUnOrderedSet(new int[] { 1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11 });
		printUnOrderedSet(new int[] { 1, 2, 3, 7, 5, 6, 8, 9 });
		printUnOrderedSet(new int[] { 4, 1, 2, 3, 5, 6 });
		printUnOrderedSet(new int[] { 1, 2, 3, 4, 10, 9, 8 });
		printUnOrderedSet(new int[] { 5, 4, 3, 2, 1 });
		printUnOrderedSet(new int[] { 1, 2, 3, 4, 5 });
		printUnOrderedSet(new int[] { 1, 2, 3, 7, 5, 6, 4, 8, 9 });
	}

	private static void printUnOrderedSet(int[] arr) {
		int startIndx = 0;
		int endIdx = 0;
		int[] result = new int[2];

		int fixedPlace = arr[0];
		// int[] arr1 = { 1, 2, 3, 7, 5, 6, 8, 9 };
		boolean doesSortedElements = true;
		for (int i = 1; i < arr.length; i++) {
			if (fixedPlace < arr[i]) {
				fixedPlace = arr[i];
				continue;
			} else {
				doesSortedElements = false;
				startIndx = i - 1;
				while (i < arr.length && fixedPlace > arr[i]) {
					i++;
				}
				endIdx = i - 1;
			}
			break;
		}
		if (doesSortedElements) {
			result[0] = -1;
			result[1] = -1;
		} else {
			result[0] = startIndx;
			result[1] = endIdx;
		}
		System.out.println(Arrays.toString(result));
	}
}
