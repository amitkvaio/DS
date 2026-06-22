package com.leetcode;

import java.util.Arrays;

public class MinimumSwap {
	public static void main(String[] args) {
		//System.out.println(getMinimumSwap(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(getMinimumSwap(new int[] { 10, 11, 5, 4, 3, 2, 1 }));
	}

	private static int getMinimumSwap(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length ;
		int leftPtr  = 0 ;
		int rightPtr = n -1;
		int minimumSwapRequired = 0;
		
		while (leftPtr < 3 ) {
			System.out.println("Before::" + Arrays.toString(arr));
			if(arr[rightPtr] < arr[leftPtr]) {
				swap(leftPtr, rightPtr, arr);
				minimumSwapRequired ++;
				
				//To Insure that swapped elements are in proper position
				
				//For the left elements
				if(leftPtr == 0 || arr[leftPtr] > arr[leftPtr - 1]) {
					leftPtr++;
				}
					
				// For Right Elements
				if (rightPtr == n - 1 || arr[rightPtr + 1] > arr[rightPtr]) {
					rightPtr--;
				} else {
					swap(arr[rightPtr+1], arr[rightPtr], arr);
					rightPtr--;
				}
			}
			System.out.println("After::" + Arrays.toString(arr));
		}
		return minimumSwapRequired;
	}
	
	public static void swap(int leftIdx, int rightIdx, int[] arr) {
		int temp = arr[leftIdx];
		arr[leftIdx] = arr[rightIdx];
		arr[rightIdx] = temp;
	}
}
