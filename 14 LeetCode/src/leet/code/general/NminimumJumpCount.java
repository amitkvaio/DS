package leet.code.general;
/*
Given an array of non-negative integers nums, you are initially positioned at the 
	first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. 
	Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [2,3,0,1,4]
Output: 2

*/
public class NminimumJumpCount {
	public static void main(String[] args) {
		int[] nums1 = {2,2,1,1,4};
		int[] nums2 = {2,3,0,1,4};
		System.out.println(jumpCount(nums1));
		System.out.println(jumpCount(nums2));
	}
	
	public static int jumpCount(int[] A) {
		int n = A.length;
		if (n == 1)
			return 0;
		if (A[0] == 0)
			return -1;

		int ladder = A[0]; /// biggest ladder/ max reachable Index
		int stair = A[0]; /// current ladder
		int jump = 1;

		for (int i = 1; i < n; i++) {
			if (i == n - 1)
				return jump;

			if (i + A[i] > ladder) {
				ladder = i + A[i];
			}

			stair--; /// traversing current ladder

			if (stair == 0) { // current ladder finished
				jump++;
				if (i >= ladder)
					return -1;
				stair = ladder - i;
				// if(stair<=0) return -1;
			}
		}

		return -1;
	}
}
