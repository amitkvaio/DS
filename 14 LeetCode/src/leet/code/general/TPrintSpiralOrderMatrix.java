package leet.code.general;

import java.util.Arrays;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.
Input: matrix = [
					[1,2,3],
					[4,5,6],
					[7,8,9]
				]

Output: 		[1,2,3,6,9,8,7,4,5]

Input: matrix = [
					[1,2,3,4],
					[5,6,7,8],
					[9,10,11,12]
				]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

*/
public class TPrintSpiralOrderMatrix {
	public static void main(String[] args) {
		int [][] arr1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9 }
			   };
		int [][] arr2 = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12 }
			   };
		print(arr1);
		int[] out1 = getSpiralMatrix(arr1);
		System.out.println(Arrays.toString(out1));
		print(arr2);
		int[] out2 = getSpiralMatrix(arr2);
		System.out.println(Arrays.toString(out2));
	}
	//TC :: O(row*col) SC: O(1)
	public static int[] getSpiralMatrix(int[][] mat) {
		//Gives number of row
		int row = mat.length;
		
		//Gives numbers of column
		int col = mat[0].length;

		int sr = 0, er = row - 1;
		int sc = 0, ec = col - 1;
		
		int[] outArr = new int[row * col];
		int k=0;
		int count =0;
		while (sr <= er && sc <= ec) {
			
			//Printing first row                <startRow:0>...................<colEnd>
			for (int i = sc; i <= ec; i++) {
				outArr[k++]=mat[sr][i];
				count++;
			}
			//increasing the row
			sr++;
			if(count==row*col) {
				return outArr;
			}
			
			//printing the last column from top to bottom
			for (int i = sr ; i <=er ; i++) {
				outArr[k++]=mat[i][ec];
				count++;
			}
			ec--;
			if(count==row*col) {
				return outArr;
			}
			
			//Printing the end row from right to left
			for (int i = ec ; i >=sc ; i--) {
				outArr[k++]=mat[er][i];
				count++;
			}
			er--;
			if(count==row*col) {
				return outArr;
			}
			
			//Printing the first column values from bottom to top
			for (int i = er ; i >=sr ; i--) {
				outArr[k++]=mat[i][sc];
				count++;
			}
			sc++;
			if(count==row*col) {
				return outArr;
			}
		}
		return outArr;
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
