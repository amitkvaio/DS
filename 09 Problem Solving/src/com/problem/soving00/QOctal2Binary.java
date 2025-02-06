//Octal To Binary.
/*
	1 . Need to convert Octal to Decimal then Decimal to Binary and vice - versa
*/
package com.problem.soving00;

public class QOctal2Binary {
	public static void main(String[] args) {
		String octal = "40";
		int decimal  = octalToDecimal(octal);
		String binary = decimalToBinary(decimal);
		System.out.println("Octal : " + octal + " Decimal : " + decimal + " Binary : " + binary);
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
	
	// Convert Decimal to Binary (without built-in method)
	public static String decimalToBinary(int decimal) {
		StringBuilder binary = new StringBuilder();
		while (decimal > 0) {
			binary.insert(0, decimal % 2); // Get remainder (0 or 1) and insert at the beginning
			decimal = decimal / 2; // Divide by 2
		}
		return binary.length() > 0 ? binary.toString() : "0"; // Return 0 for input 0
	}
}
