package bcom.logical.arrays;

public class ORotateAnImageBy90DegreeClockWise {
	public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {8, 9, 0, 1},
            {2, 3, 4, 5}
        };

        System.out.println("Before Transpose:");
        printMatrix(matrix);
        System.out.println("After Transpose:");
        rotateAnImageBy90DegreeClockWise(matrix);
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


	private static void rotateAnImageBy90DegreeClockWise(int[][] matrix) {
		//Transpose
		int rowLength = matrix[0].length;
		int colLength = matrix.length;
		
		for (int row = 0; row < rowLength; row++) {
			for (int col = row + 1; col < colLength; col++) {
				// Swap elements at (row, col) and (col, row)
				int temp = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = temp;
			}
		}
		printMatrix(matrix);
		
		// Reverse each row.
		for (int[] arr : matrix) {
			int low = 0, high = arr.length - 1;
			while (low <= high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
				high--;
			}
		}
		System.out.println("After Reverse:");
		printMatrix(matrix);
	}
}
/*
Key Idea:
*********
Rotation by 90° clockwise =
    Transpose the matrix
    Reverse each row
 
 
[ 1  5  9 13 ]
[ 2  6 10 14 ]
[ 3  7 11 15 ]
[ 4  8 12 16 ]

Step 2: Reverse Each Row

Now reverse each row (left ↔ right):

Row 1: 1 5 9 13 → 13 9 5 1
Row 2: 2 6 10 14 → 14 10 6 2
Row 3: 3 7 11 15 → 15 11 7 3
Row 4: 4 8 12 16 → 16 12 8 4

TC : O(m*n)
SC : O(1)
*/