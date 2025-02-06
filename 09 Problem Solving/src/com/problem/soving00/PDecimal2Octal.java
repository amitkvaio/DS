//Decimal to octal and Octal to Decimal
package com.problem.soving00;

public class PDecimal2Octal {
	public static void main(String[] args) {
		int num = 65;

		String octal = decimalToOctal(num);
		System.out.println("Octal num of :" + num + " is : " + octal);
		int decimal = octalToDecimal(octal);
		System.out.println("Decimal num : " + decimal);
	}

	// Convert Decimal to Octal
	public static String decimalToOctal(int decimal) {
		StringBuilder octal = new StringBuilder();
		while (decimal > 0) {
			octal.insert(0, decimal % 8); // Get remainder (0-7) and insert at the beginning
			decimal /= 8;
		}
		return octal.length() > 0 ? octal.toString() : "0"; // Return 0 for input 0
	}

	// Convert Octal to Decimal
	public static int octalToDecimal(String octal) {
		int decimal = 0;
		int power = 0;

		// Read octal from right to left
		for (int i = octal.length() - 1; i >= 0; i--) {
			decimal += (octal.charAt(i) - '0') * Math.pow(8, power);
			power++;
		}
		return decimal;
	}
}
/*
octal.charAt(i) - '0'

octal.charAt(i) extracts the character at position i in the string.
Since char stores ASCII values, subtracting '0' converts the character to an integer.

Example:
char ch = '3';
int digit = ch - '0';  // 3 (ASCII '3' = 51, ASCII '0' = 48 → 51 - 48 = 3)

*/