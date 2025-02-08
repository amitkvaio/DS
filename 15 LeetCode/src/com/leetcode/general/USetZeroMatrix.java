package com.leetcode.general;
/*
Set martix-zero
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.
Input: matrix = [
					[1,1,1],
					[1,0,1],
					[1,1,1]]
Output: [
			[1,0,1],
			[0,0,0],
			[1,0,1]
		]

Input: matrix = [
					[0,1,2,0],
					[3,4,5,2],
					[1,3,1,5]
				]
Output: [			[0,0,0,0],
					[0,4,5,0],
					[0,3,1,0]
			]

*/
public class USetZeroMatrix {
	public static void main(String[] args) {
		int [][] arr1 = {
				{1,1,1},
				{1,0,1},
				{1,1,1}
			};
		
		int [][] arr2 = {
				{0,1,2,0},
				{3,0,5,2},
				{1,3,1,5}
			};
		print(arr1);
		setMatrixZero(arr1);
		print(arr2);
		setMatrixZero(arr2);
		System.out.println("Done");
	}
	
	private static void setMatrixZero(int[][] matrix) {
		//Gives number of row
		int row = matrix.length;
		if(row==0)
			return;
		//Gives numbers of column
		int col = matrix[0].length;
		if(col==0)
			return;
		
		boolean hasZeroFirstRow = false;
		boolean hasZeroFirstCol = false;
		
		
		//Does first row has zero elements
		for (int i = 0; i < col ; i++) {
			if(matrix[0][i]==0) {
				hasZeroFirstRow=true;
				break;
			}
		}
		//Does first column has zero
		for (int i = 0; i < row ; i++) {
			if(matrix[i][0]==0) {
				hasZeroFirstCol=true;
				break;
			}
		}
		//Make use of first row and first column
		//find the zero and store info in the first row and first column
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if(matrix[i][j]==0) {
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		
		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		//set zeros for first row
		if(hasZeroFirstRow) {
			for (int i = 0; i < col; i++) {
				matrix[0][i]=0;
			}
		}
		
		//set zeros for first row
		if(hasZeroFirstCol) {
			for (int i = 0; i < row; i++) {
				matrix[i][0]=0;
			}
		}
		System.out.println();
		print(matrix);
	}
	
	public static void print(int[][] arr) {
		int row = arr.length;
		for (int i = 0; i < row; i++) {
			int colLen = arr[i].length;
			for (int j = 0; j < colLen; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("\n\n");
	}
}
