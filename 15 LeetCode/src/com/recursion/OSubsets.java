package com.recursion;

import java.util.ArrayList;
import java.util.List;

//Approach-1
//T.C : O(2^n)
//S.C :  O(2^n*length of each subset) to store each subset
//     The recursion stack space complexity is O(N) , the maximum depth of the recursion is N, where N is the length of the input array.
public class OSubsets {
  private List<List<Integer>> result = new ArrayList<>();

	public static void main(String[] args) {
		OSubsets oSubsets = new OSubsets();
		int [] nums = {1,2,3};
		List<List<Integer>> subsets = oSubsets.subsets(nums);
		System.out.println(subsets);
	}
  
  
  public List<List<Integer>> subsets(int[] nums) {
      List<Integer> temp = new ArrayList<>();
      solve(nums, 0, temp);
      return result;
  }

  private void solve(int[] nums, int idx, List<Integer> temp) {
      if (idx >= nums.length) {
          result.add(new ArrayList<>(temp));
          return;
      }
      temp.add(nums[idx]);
      solve(nums, idx + 1, temp);
      temp.remove(temp.size() - 1);
      solve(nums, idx + 1, temp);
  }
}
/*
78. Subsets
https://leetcode.com/problems/subsets/description/
Given an integer array nums of unique elements, return all possible
subsets
(the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

 

Constraints:

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.



*/