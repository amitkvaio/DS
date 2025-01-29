package com.leetcode.easy.a;
//8. Special Positions in a Binary Matrix | 2 Approaches | Leetcode-1582
public class HNumSpecialPositionInMatrix {
	
	public static void main(String[] args) {
		int [][] mat1 = {
				{1,0,0},{0,0,1},{1,0,0}	
		};
		int [][] mat2 = {
				{1,0,0},{0,1,0},{0,0,1}	
		};
		System.out.println(numSpecial(mat1));
		System.out.println(numSpecial(mat2));
	}
	
	//Approach-2(Storing count of 1s in rows and cols)
	//T.C : O(m*n)
	//S.C : O(m+n)
	public static int numSpecial(int[][] A) {
		int row = A.length;
		int column = A[0].length;

		int[] rowCount = new int[row];
		int[] columnCoun = new int[column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (A[i][j] == 0)
					continue;
				if (A[i][j] == 1) {
					rowCount[i] = rowCount[i] + 1;
					columnCoun[j] = columnCoun[j] + 1;
				}
			}
		}

		int specialPosCount = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (A[i][j] == 1 && rowCount[i] == 1 && columnCoun[j] == 1)
					specialPosCount++;
			}

		}
		return specialPosCount;
	}
}

/*
https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/


Given an m x n binary matrix mat, return the number of special positions in mat.

A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).



Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.



Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: (0, 0), (1, 1) and (2, 2) are special positions.

 

Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 100
    mat[i][j] is either 0 or 1.



*/