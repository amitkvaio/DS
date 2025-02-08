// Find the  maximum of sum of two number of the given arrays.
package com.problem.soving00;
public class XSumOfTwoMaxNumber {
	public static void main(String[] args) {
		int[] arr = { 70, 20, 30, 15, 5, 45, 25 };
		int max = sumOfTwoMax(arr);
		System.out.println("Max  Number : " + max);
	}

	public static int sumOfTwoMax(int arr[]) {
		int firstMax = 0, secondMax = 0;
		for (int num : arr) {
			if (firstMax < num) {
				secondMax = firstMax;
				firstMax = num;
			} else if (secondMax < num) {
				secondMax = num;
			}
		}
		return firstMax + secondMax;
	}
}
