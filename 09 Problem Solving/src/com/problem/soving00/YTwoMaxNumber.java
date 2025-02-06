//Find the two max number in the given arrays
package com.problem.soving00;

public class YTwoMaxNumber {
	public static void main(String[] args) {
		int[] arr = {70,20,30,15,5,45,25,100};
		maxtownumber(arr);
	}

	public static void maxtownumber(int[] arr) {
		int maxOne = Integer.MIN_VALUE;
		int maxTwo = Integer.MIN_VALUE;
		for (int num : arr) {
			if (maxOne < num) {
				maxTwo = maxOne;
				maxOne = num;
			} else if (maxTwo < num) {
				maxTwo = num;
			}
		}
		System.out.println("First Max Number: " + maxOne);
		System.out.println("Second Max Number: " + maxTwo);
	}
}
