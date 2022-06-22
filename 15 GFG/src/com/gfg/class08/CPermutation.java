package com.gfg.class08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CPermutation {
	public static void main(String[] args) {
		Integer nums[] = { 1, 2, 3 };
		List<List<Integer>> ls = permute(Arrays.asList(nums));
		System.out.println("All Permutations are ");
		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < ls.get(i).size(); j++) {
				System.out.print(ls.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> permute(List<Integer> nums) {
		int n = nums.size();
		List<List<Integer>> res = new ArrayList<>();
		// Base Case
		if (n == 1) {
			res.add(nums);
			return res;
		}

		for (int i = 0; i < n; i++) {
			List<Integer> reducedList = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				reducedList.add(nums.get(j));
			}
			List<List<Integer>> permutation = permute(reducedList);
			for (List<Integer> perm : permutation) {
				perm.add(nums.get(i));
				res.add(perm);
			}
		}
		return res;
	}

}
