package bcom.logical.arrays;

public class QSearchRowWiseSortedMatrix {

	 public static void main(String[] args) {
	        int[][] mat = {
	            {1, 3, 5, 7},
	            {10, 11, 16, 20},
	            {23, 30, 34, 50}
	        };
	        int x = 16;

	        System.out.println(searchMatrix(mat, x));
	    }
	public static boolean searchMatrix(int[][] mat, int x) {
		int n = mat.length;
		int m = mat[0].length;

		for (int i = 0; i < n; i++) {
			int low = 0, high = m - 1;

			while (low <= high) {
				int mid = (low + high) / 2;

				if (mat[i][mid] == x) {
					System.out.println("Element found at (" + i + ", " + mid + ")");
					return true;
				} else if (mat[i][mid] < x) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		System.out.println("Element not found.");
		return false;
	}
}

/*
Each row is sorted left to right (increasing or non-decreasing order).
Columns are NOT necessarily sorted.
You need to efficiently search for the element x.

mat = {
  {1, 3, 5, 7},
  {10, 11, 16, 20},
  {23, 30, 34, 50}
}
x = 16

Output : True

Binary search on each row → O(n * log m)
SC : o(n)
*/