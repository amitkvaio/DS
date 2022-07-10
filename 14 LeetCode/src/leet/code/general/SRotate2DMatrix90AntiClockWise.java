package leet.code.general;
/*
Transpose of the matrix
				[
					[ 1,2,3 ]
					[ 4,5,6 ]
					[ 7,8,9 ]
				]
				
Output: 		[
					[3,6,9],
					[2,5,8],
					[1,4,7]
				]
*/
public class SRotate2DMatrix90AntiClockWise {
	public static void main(String[] args) {
		int [][] arr = {
						{1,2,3},
						{4,5,6},
						{7,8,9 }
					   };
		rotateBy90AntiClockWise(arr);
		print(arr);
	}
	
	//TC; O(M*N) SC: O(10
	public static int[][] rotateBy90AntiClockWise(int[][] matrix) {
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
		int n = matrix[0].length;
		for (int i = 0; i < n; i++) {
			// logic to swap columns
			int low = 0;
			int high = n - 1;
			while (low < high) {
				int temp = matrix[low][i];
				matrix[low][i] = matrix[high][i];
				matrix[high][i] = temp;
				low++;
				high--;
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
