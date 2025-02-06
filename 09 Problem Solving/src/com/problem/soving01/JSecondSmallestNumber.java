package com.problem.soving01;

public class JSecondSmallestNumber {
	public static void main(String[] args) {
		int[] arr = { 70, 20, 30, 15, 5, 45, 25, 100 };
		secondSmallestNumber1(arr);
	}

	public static void secondSmallestNumber1(int[] arr) {
		int firstMax = Integer.MAX_VALUE;
		int secondMax = Integer.MAX_VALUE;
		for (int number : arr) {
			if (number < firstMax) {
				secondMax = firstMax;
				firstMax = number;
			} else if (number < secondMax) {
				secondMax = number;
			}
		}
		System.out.println("First Smallest number : " + firstMax);
		System.out.println("Second Smallest number : " + secondMax);
	}
}
