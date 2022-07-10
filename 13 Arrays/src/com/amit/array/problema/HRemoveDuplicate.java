package com.amit.array.problema;

import java.util.Arrays;

//Remove the duplicate elements if the given elements are in sorted order.
//int arr[] = {1,0,0,2,3,0};
public class HRemoveDuplicate {
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 3, 5, 5, 7 };
		//int[] nums = new int[] { 2,2,2,2,2 };
		int newLength = removeDuplicates(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println("Length of array after removing duplicates = " + newLength);

		System.out.print("Array = ");
		for (int i = 0; i < newLength; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
	
	private static int removeDuplicates(int[] nums) {
		int n = nums.length;

		/*
		 * This index will move only when we modify the array in-place to include a new
		 * non-duplicate element.
		 */
		int j = 0;

		for (int i = 0; i < n; i++) {
			/*
			 * If the current element is equal to the next element, then skip the current
			 * element because it's a duplicate.
			 */
			if (i < n - 1 && nums[i] == nums[i + 1]) {
				continue;
			}

			nums[j++] = nums[i];
		}

		return j;
	}

	
}
