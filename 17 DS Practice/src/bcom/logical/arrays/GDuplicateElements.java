package bcom.logical.arrays;

public class GDuplicateElements {
	public static void main(String[] args) {
		 int[] nums = {1, 3, 4, 2, 2};
		 isDuplicate(nums);
	}

	private static void isDuplicate(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int absIndex = Math.abs(arr[i]);

			if (arr[absIndex] < 0) {
				// We have already seen this number
				System.out.println("1. Duplicate number exist in array at index : " + i);
				return;
			} else {
				// We are seeing this number for first time
				arr[absIndex] = -arr[absIndex];
			}
		}
	}
}
/*
Important Constraints
**********************
This solution modifies the original array (destructive).
It only works if all elements are in range 0 to n-1.
Cannot use if input includes negative numbers or out-of-bound values.
TC = O(n)
SC = O(1)
*/