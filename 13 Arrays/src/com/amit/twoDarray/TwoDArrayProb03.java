package com.amit.twoDarray;
/*
 Search a 2D Matrix II
 https://leetcode.com/problems/search-a-2d-matrix-ii
 Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
 	   This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

*/
public class TwoDArrayProb03 {
	public static void main(String[] args) {
		int [][] arr1 = {
				{1,4,7,11,15},
				{2,5,8,12,19},
				{3,6,9,16,22},
				{10,13,14,17,24},
				{18,21,23,26,30}
				
			};
		int target1 =5;
		int [][] arr2 = {
				{1,4,7,11,15},
				{2,5,8,12,19},
				{3,6,9,16,22},
				{10,13,14,17,24},
				{18,21,23,26,30}
			};
		int target2 =20;
		System.out.println(stairCaseSearch(arr1, target1));
		System.out.println(stairCaseSearch(arr2, target2));
	}

	//TC : O(numRow+numCol) , SC:0(1)
	private static boolean stairCaseSearch(int[][] matrix, int target) {
		int numRow = matrix.length;
		int numCol = matrix[0].length;

		if (target < matrix[0][0] || target > matrix[numRow - 1][numCol - 1])
			return false;

		/// top right
		int i = 0;
		int j = numCol - 1;

		while (i <= numRow - 1 && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] < target)
				i++;
			else if (matrix[i][j] > target)
				j--;
		}
		return false;
	}



	public static void print(int[][] arr) {
		for (int[] innerArray : arr) {
			for (int data : innerArray) {
				System.out.print(data + " ");
			}
			System.out.println("");
		}
	}
}
