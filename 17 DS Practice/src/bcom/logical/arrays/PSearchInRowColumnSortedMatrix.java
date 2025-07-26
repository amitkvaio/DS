package bcom.logical.arrays;

public class PSearchInRowColumnSortedMatrix {
	 public static void main(String[] args) {
	        int[][] mat = {
	            {10, 20, 30, 40},
	            {15, 25, 35, 45},
	            {27, 29, 37, 48},
	            {32, 33, 39, 50}
	        };
	        System.out.println("Given Matrix is:");
	        printMatrix(mat);
	        
	        
	        int x = 29;
	        searchElement(mat, x);
	    }
	
	private static boolean searchElement(int[][] mat, int x) {
		int n = mat.length;         // number of rows
        int m = mat[0].length;      // number of columns
        int row = 0, col = m - 1;   // Start from top-right
        
        //We are moving through the matrix starting from the top-right corner.
        while(row < n && col >=0) {
        	if(mat[row][col]==x) {
        		System.out.println("Element found at (" + row + ", " + col + ")");
        		return true;
        	}else if(mat[row][col] > x) {
        		col --;
        	}else {
        		row++;
        	}
        }
        return false;
	}

	// Utility function to print matrix
	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
/*
Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in 
increasing order, and a number x, the task is to determine whether element x is 
present in the matrix.

Time Complexity:
    O(n + m) — since in each step we move either left or down

Space Complexity:
    O(1) — no extra space used
*/