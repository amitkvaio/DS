package bcom.logical.arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ATwoSum {
	
	public static void main(String[] args) {
		int [] nums = {10,20,15,21, 25};
		int target = 35;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		return new int[] {};
	}
}
/*
TC - O(n)
SC - O(n)
*/