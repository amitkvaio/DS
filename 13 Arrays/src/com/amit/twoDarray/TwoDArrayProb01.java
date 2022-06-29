package com.amit.twoDarray;

import java.util.Arrays;

//https://leetcode.com/problems/spiral-matrix/
/*
Given an m x n matrix, return all elements of the matrix in spiral order.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/
public class TwoDArrayProb01 {
	public static void main(String[] args) {
		int [][] arr1 = {
							{1,2,3},
							{4,5,6},
							{7,8,9}
						};
		int [][] arr2 = {
							{1,2,3,4},
							{5,6,7,8},
							{9,10,11,12}
						};
		
		int[] spiralMatrix = spiralMatrix(arr1);
		System.out.println("*************"+Arrays.toString(spiralMatrix));
		int[] spiralMatrix2 = spiralMatrix(arr2);
		System.out.println("*************"+Arrays.toString(spiralMatrix2));
		
	}
	
	//TC :: O(row*col) SC: O(1)
	public static int[] spiralMatrix(int[][] arr) {
		//Gives number of row
		int row = arr.length;
		
		//Gives numbers of column
		int col = arr[0].length;

		int rowStart = 0, rowEnd = row - 1;
		int colStart = 0, colEnd = col - 1;
		
		int[] outArr = new int[row * col];
		int k=0;
		int count =0;
		while (rowStart <= rowEnd && colStart <= colEnd) {
			
			//Printing first row                <startRow:0>...................<colEnd>
			for (int i = colStart; i <= colEnd; i++) {
				outArr[k++]=arr[rowStart][i];
				count++;
			}
			//increasing the row
			rowStart++;
			if(count==row*col) {
				return outArr;
			}
			
			//printing the last column from top to bottom
			for (int i = rowStart ; i <=rowEnd ; i++) {
				outArr[k++]=arr[i][colEnd];
				count++;
			}
			colEnd--;
			if(count==row*col) {
				return outArr;
			}
			
			//Printing the end row from right to left
			for (int i = colEnd ; i >=colStart ; i--) {
				outArr[k++]=arr[rowEnd][i];
				count++;
			}
			rowEnd--;
			if(count==row*col) {
				return outArr;
			}
			
			//Printing the first column values from bottom to top
			for (int i = rowEnd ; i >=rowStart ; i--) {
				outArr[k++]=arr[i][colStart];
				count++;
			}
			colStart++;
			if(count==row*col) {
				return outArr;
			}
		}
		return outArr;
	}
}
