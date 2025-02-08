package com.leetcode.general;
/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees 
	(clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix 
	directly.DO NOT allocate another 2D matrix and do the rotation.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
				[
					[ 1,2,3 ]
					[ 4,5,6 ]
					[ 7,8,9 ]
				]
				
Output: 		[
					[7,4,1],
					[8,5,2],
					[9,6,3]
				]
*/
public class RRotate2DMatrixBy90ClockWise {
	public static void main(String[] args) {
		int [][] arr = {
						{1,2,3},
						{4,5,6},
						{7,8,9 }
					   };
		int[][] output = rotateBy90ClockWise(arr);
		print(output);
	}
	
	//TC; O(M*N) SC: O(10
	public static int[][] rotateBy90ClockWise(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				// checks if i is not equal to j because in transpose matrix
				// diagonal elements will not swap
				if (i != j) {
					// swapping elements
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}

		// Reversing elements row wise
		for (int i = 0; i < matrix.length; i++) {
			int start = 0;
			int end = matrix[i].length - 1;
			int[] arr = matrix[i];
			while (start <= end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
		return matrix;
	}                
	
	public static void print(int[][] arr) {
		int row = arr.length;
		for (int i = 0; i < row; i++) {
			int colLen = arr[i].length;
			for (int j = 0; j < colLen; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
