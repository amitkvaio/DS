package com.amit.array.problemb;

import java.util.Arrays;

public class RCyclicSort {
	static void cyclicSort(int[] arr) {
		int n = arr.length;
		int i = 0;

		while (i < n) {
			// Correct position of arr[i] should be arr[i] - 1
			int correctIndex = arr[i] - 1;

			// Swap if arr[i] is not at its correct position & it's within range [1, n]
			if (arr[i] > 0 && arr[i] <= n && arr[i] != arr[correctIndex]) {
				System.out.println("CorrectedIdx :" + correctIndex + " num1: " + arr[i] + " : " + arr[correctIndex] + "  :Before:" + Arrays.toString(arr));
				swap(arr, i, correctIndex);
				System.out.println("CorrectedIdx :" + correctIndex + " num1: " + arr[i] + " : " + arr[correctIndex] + "  :After:" + Arrays.toString(arr));
				System.out.println("********************");
			} else {
				i++; // Move to next element
			}
		}
	}

	// Swap function
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 2, 7, 6, 4,1 };
		System.out.println("Before sorting: " + Arrays.toString(arr));
		cyclicSort(arr);
		System.out.println("After sorting: " + Arrays.toString(arr));
	}
}
/*

Time Complexity: O(n)
Space Complexity: O(1) (No extra space used, modifies array in-place)

Yes! Cyclic Sort works best when numbers are in the range [1, n].
Number should be consecutive number.
Step	i	arr[i]	correctIndex	Swap?			Array After Swap
1		0	 3			2			✅ Swap 3 & 2	{2, 5, 3, 1, 4}
2		0	 2			1			✅ Swap 2 & 5	{5, 2, 3, 1, 4}
3		0	 5			4			✅ Swap 5 & 4	{4, 2, 3, 1, 5}
4		0	 4			3			✅ Swap 4 & 1	{1, 2, 3, 4, 5}
5		0	 1			0			❌ No Swap		{1, 2, 3, 4, 5}
6		1	 2			1			❌ No Swap		{1, 2, 3, 4, 5}
7		2	 3			2			❌ No Swap		{1, 2, 3, 4, 5}
8		3	 4			3			❌ No Swap		{1, 2, 3, 4, 5}
9		4	 5			4			❌ No Swap		{1, 2, 3, 4, 5}
*/