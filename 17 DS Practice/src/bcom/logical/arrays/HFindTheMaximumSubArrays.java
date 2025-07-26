package bcom.logical.arrays;

public class HFindTheMaximumSubArrays {
	public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));
    }

	private static int maxSubArray(int[] arr) {
		int maxSum = arr[0];
		int currentSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			currentSum = currentSum + arr[i];
			
			if(currentSum > maxSum ) {
				maxSum = currentSum;
			}
			
			if(currentSum < 0) {
				currentSum = 0;
			}
		}
		return maxSum;
	}
}

/*
 
Kadane’s Algorithm is a famous and efficient technique used to solve the Maximum Subarray Problem — 
i.e., to find the contiguous subarray within a one-dimensional array of numbers 
	which has the largest sum.
 
Kadane’s Algorithm
******************
    Track the current maximum subarray sum ending at each position
    If the current sum becomes negative → reset to 0 (it won’t help future subarrays)
    Keep updating the global max whenever the current sum is greater


*/