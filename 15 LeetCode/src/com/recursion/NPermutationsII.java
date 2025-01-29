package com.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Permutations II | Two Approaches | Detailed | Recursion Concepts And Questions
public class NPermutationsII {

	// Approach-1 (Using same concept as Permutation-I but keeping count to avoid
	// duplicates)
	// T.C : O(N * N!)
	// S.C : O(N)

	private List<List<Integer>> result = new ArrayList<>();
	private int n;

	public static void main(String[] args) {
		
		NPermutationsII nPermutationsII = new NPermutationsII();
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
		Map<Integer, Integer> mp = new HashMap<>();

		// Count the occurrence of each number
		for (int num : nums) {
			mp.put(num, mp.getOrDefault(num, 0) + 1);
		}

		List<Integer> temp = new ArrayList<>();
		backtrack(temp, mp);

		return result;
	}

	private void backtrack(List<Integer> temp, Map<Integer, Integer> mp) {
		if (temp.size() == n) { // We got all numbers
			result.add(new ArrayList<>(temp));
			return;
		}

		for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
			int num = entry.getKey();
			int count = entry.getValue();

			if (count == 0)
				continue;

			// Do something
			temp.add(num);
			mp.put(num, count - 1);

			// Explore it
			backtrack(temp, mp);

			// Undo it
			temp.remove(temp.size() - 1);
			mp.put(num, count);
		}
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
