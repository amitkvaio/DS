package acom.stack.linkedList;

import java.util.Arrays;

public class Test2 {
	public static void main(String[] args) {
		int [] arr = {3,3};
		int target = 6;
		System.out.println(Arrays.toString(twoSum(arr, target)));
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] numArr = new int[2];
		int x = 0;
		int sum = 0;
		for (int i = 1; i < nums.length; i++) {
			System.out.println("i::"+i);
			sum = nums[x] + nums[i];
			if (sum == target) {
				numArr[0] = x;
				numArr[1] = i;
			}
			x = i;
		}
		return numArr;
	}
}
/*
Input: nums = [3,2,4], target = 6
Output: [1,2]
Input: nums = [3,2,4], target = 6
Output: [1,2]
Input: nums = [3,3], target = 6
Output: [0,1]
*/
