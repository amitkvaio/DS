package bcom.logical.arrays;

import java.util.HashMap;
import java.util.Map;

public class KSubarraySumEqualsToK {
	public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println("Count = " + subarraySum(nums, k));  // Output: 2
    }

	private static int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1); // base case: empty subarray sum is 0

		int count = 0;
		int sum = 0;

		for (int num : nums) {
			sum += num;

			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}
}

/*
Given:
    An integer array nums
    An integer k
    Return the total number of continuous subarrays whose sum is equal to k.

A subarray is a contigous non-empty sequence of elements within an arrays.


If the sum of subarray [i…j] is k, then:
prefixSum[j] - prefixSum[i - 1] == k

So:
prefixSum[i - 1] = prefixSum[j] - k

Complexity:
    Time: O(n)
    Space: O(n)
*/