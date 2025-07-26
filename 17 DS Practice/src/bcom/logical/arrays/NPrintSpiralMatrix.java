package bcom.logical.arrays;

import java.util.ArrayList;

public class NPrintSpiralMatrix {
	  public static void main(String[] args) {
	        int[][] matrix = {
	            {1, 2, 3, 4},
	            {5, 6, 7, 8},
	            {8, 9, 0, 1},
	            {2, 3, 4, 5}
	        };

	        System.out.println("Spiral order of matrix:");
	        printSpiral(matrix);
	    }

		private static void printSpiral(int[][] matrix) {
			int left = 0, top = 0;
			int right = matrix.length - 1;
			int bottom = matrix[0].length - 1;
			ArrayList<Integer> list = new ArrayList<Integer>();

			while (top <= bottom && left <= right) {

				// 1. Traverse from left to right
				for (int col = left; col <= right; col++) {
					list.add(matrix[top][col]);
				}
				top++;

				// 2. Traverse from top to bottom : From the right side
				for (int row = top; row <= bottom; row++) {
					list.add(matrix[row][right]);
				}
				right--;

				// 3. Traverse from right to left from the bottom side
				for (int col = right; col >= left; col--) {
					list.add(matrix[bottom][col]);
				}
				bottom--;

				// 4. Traverse from bottom to top : bottom left to up
				for (int row = bottom; row >= top; row--) {
					list.add(matrix[row][left]);
				}
				left++;
			}
			System.out.println(list);
		}
}

/*
Left ➡ Right
Top ⬇ Bottom
Right ⬅ Left
Bottom ⬆ Top
Then move the walls inward (like top++, bottom--, left++, right--)  

   l        r	
t {1, 2, 3, 4},
  {5, 6, 7, 8},
  {8, 9, 0, 1},
b {2, 3, 4, 5}

TC : O(m*n)
SC : o(1)

*/