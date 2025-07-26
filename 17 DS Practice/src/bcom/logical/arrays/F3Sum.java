package bcom.logical.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F3Sum {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums); // Step 1: Sort the array

		for (int i = 0; i < nums.length - 2; i++) {

			// Skip duplicate elements for the first number
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int left = i + 1; // Start from next element
			int right = nums.length - 1; // End pointer

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					// Skip duplicates for left and right
					while (left < right && nums[left] == nums[left + 1])
						left++;
					while (left < right && nums[right] == nums[right - 1])
						right--;

					left++;
					right--;

				} else if (sum < 0) {
					left++; // Need a larger number

				} else {
					right--; // Need a smaller number
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> triplets = threeSum(nums);

		for (List<Integer> triplet : triplets) {
			System.out.println(triplet);
		}
	}
}



/*
(Leetcode #15 – 3Sum):
    Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]] such that:
    i != j, j != k, and i != k
    nums[i] + nums[j] + nums[k] == 0
    
Given an integer array nums, return all the triplets whose sum is equal to zero.
Time Complexity: O(n²)
Space (Total)	O(k) where k = number of triplets in result
*/