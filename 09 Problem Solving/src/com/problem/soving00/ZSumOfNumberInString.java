package com.problem.soving00;

public class ZSumOfNumberInString {
	public static void main(String[] args) {
		String input = "abc12xyz345";

		int sumOfNumbers = sumNumbers(input);
		int sumOfDigits = sumDigits(input);

		System.out.println("Sum of all numbers in string: " + sumOfNumbers);
		System.out.println("Sum of individual digits in string: " + sumOfDigits);
	}

	// Method to calculate sum of numbers in a string.
	public static int sumNumbers(String str) {
		int sum = 0;
		int num = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i); // Get character at index i

			// Check if the character is a digit without using built-in methods
			if (ch >= '0' && ch <= '9') {
				num = num * 10 + (ch - '0'); // Convert char to number
			} else {
				sum = sum + num; // Add previous number to sum
				num = 0; // Reset num for the next number
			}
		}
		sum = sum + num; // Add last number (if any)
		return sum;
	}

	// Method to calculate sum of individual digits in a string
	public static int sumDigits(String str) {
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i); // Get character at index i

			// Check if the character is a digit without built-in methods
			if (ch >= '0' && ch <= '9') {
				sum = sum +  (ch - '0'); // Convert char to digit and add
			}
		}
		return sum;
	}
}
