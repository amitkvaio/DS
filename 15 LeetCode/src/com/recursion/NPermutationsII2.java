package com.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Permutations II | Two Approaches | Detailed | Recursion Concepts And Questions
public class NPermutationsII2 {

	// Approach-2 (Using swap technique but avoiding duplicates by using set)
	// T.C : O(N * N!) worst case
	// S.C : O(N)

	private List<List<Integer>> result = new ArrayList<>();
	private int n;

	public static void main(String[] args) {

		NPermutationsII2 nPermutationsII = new NPermutationsII2();
		int[] nums1 = { 1, 1, 2 };
		System.out.println("Input: [1, 1, 2]");
		System.out.println("Output: " + nPermutationsII.permuteUnique(nums1));
		System.out.println("**************************************************");
		nPermutationsII.result.clear();
		nPermutationsII.n = 0;

		int[] nums2 = { 1, 2, 3 };
		System.out.println("Input: [1, 2, 3]");
		System.out.println("Output: " + nPermutationsII.permuteUnique(nums2));
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		n = nums.length;

		solve(0, nums);

		return result;
	}

	private void solve(int idx, int[] nums) {
		if (idx == n) {
			List<Integer> permutation = new ArrayList<>();
			for (int num : nums) {
				permutation.add(num);
			}
			result.add(permutation);
			return;
		}

		Set<Integer> uniqueSet = new HashSet<>();
		for (int i = idx; i < n; i++) {

			if (uniqueSet.contains(nums[i])) {
				continue;
			}

			uniqueSet.add(nums[i]);

			swap(nums, i, idx);

			solve(idx + 1, nums);

			swap(nums, i, idx);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 

Constraints:

    1 <= nums.length <= 8
    -10 <= nums[i] <= 10



*/
