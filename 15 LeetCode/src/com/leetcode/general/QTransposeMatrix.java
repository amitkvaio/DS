package com.leetcode.general;
/*
Transpose of the matrix
				[
					[ 1,2,3 ]
					[ 4,5,6 ]
					[ 7,8,9 ]
				]
				
Output: 		[
					[1,4,7],
					[2,5,8],
					[3,6,9]
				]
*/
public class QTransposeMatrix {
	public static void main(String[] args) {
		int [][] arr = {
					{1,2,3},
					{4,5,6},
					{7,8,9 }
		
				};
		System.out.println("Before Transpose::");
		print(arr);
		System.out.println("After Transose::");
		transpose(arr);
		print(arr);

	}
	
	public static void transpose(int[][]matrix) {
		int row = matrix.length;
		for (int i = 0; i < row ; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				//If i==j meaning diagonal elements are not required to changes, applicable for square matrix
				if(i!=j) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
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
