package com.problem.soving01;

import java.util.Arrays;

public class NMoveZerosToEnd {
	
	public static void main(String[] args) {
		int arr[] = { 2, 0, 5, 2, 0, 3, 1 };
		String sArray = Arrays.toString(arr);
		System.out.printf("1. Move zeros of array %s to end :", sArray);
		moveZeroToEnd(arr);

		arr = new int[] { 1, 0, 2, 3, 0, 4, 0 };
		sArray = Arrays.toString(arr);
		System.out.printf("\n2. Move zeros of array %s to end :", sArray);
		moveZeroToEnd(arr);
	}
	
	//Time Complexity  = O(n)
	private static void moveZeroToEnd(int[] arr) {
		int index =0 ;
		int nonZeroIndex=0;
		int length = arr.length;
		
		while(index < length) {
			if(arr[index]!=0) {
				arr[nonZeroIndex++]=arr[index];
			}
			index++;
		}
		while(nonZeroIndex<length) {
			arr[nonZeroIndex++]=0;
		}
		System.out.printf("%s", Arrays.toString(arr));
	}
}
