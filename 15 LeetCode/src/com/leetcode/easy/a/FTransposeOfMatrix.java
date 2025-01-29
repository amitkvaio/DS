package com.leetcode.easy.a;

import java.util.Arrays;
// 6 Transpose Matrix | Leetcode-867
public class FTransposeOfMatrix {
	
	public static void main(String[] args) {
		int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int [][] transpose = transpose(matrix);
		System.out.println(Arrays.deepToString(transpose));
	}
	
	//T.C : O(m*n)
	//S.C : O(1) - Ignoring the space taken for result
	public static int[][] transpose(int[][] A) {
		int row = A.length;
		int column = A[0].length;

		int[][] result = new int[column][row];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				result[j][i] = A[i][j];
			}
		}
		return result;
	}
}


/*

Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]

Example 2:

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 1000
    1 <= m * n <= 105
    -109 <= matrix[i][j] <= 109










*/