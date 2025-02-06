//Decimal number to binary number conversation
package com.problem.soving00;

public class OBinaryNumber {
	public static void main(String[] args) {
		int num = 15;
		String binary = decimalToBinary(num);
		System.out.println("Binary : "+binary);
		int decimal = binaryToDecimal(binary);
		System.out.println("Decimal Number : "+decimal);
	}
	
	// Convert Decimal to Binary (without built-in method)
	public static String decimalToBinary(int decimal) {
		StringBuilder binary = new StringBuilder();
		while (decimal > 0) {
			binary.insert(0, decimal % 2); // Get remainder (0 or 1) and insert at the beginning
			decimal = decimal/2; // Divide by 2
		}
		return binary.length() > 0 ? binary.toString() : "0"; // Return 0 for input 0
	}
	
	// Convert Binary to Decimal (without built-in method)
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        
        // Read binary from right to left
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power); // Multiply by power of 2
            }
            power++;
        }
        return decimal;
    }
}
