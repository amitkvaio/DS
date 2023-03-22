package com.amit.array.problemb;
/*
Maximize the number N by inserting given digit at any position
Input: N = 6673, K = 6
Output: 66763
Explanation:
All the numbers formed by inserting K at any position 
in N are {66673, 66763, 66736}. The maximum among all the formed number is 66763.

Input: N = 1234, K = 5
Output: 51234
*/
public class QMaxNumByInsertinAnDigit {
	
	public static void main(String args[]) {
		int N = 6673, K = 6;
		maximizeNumber(N, K);
	}
	
	// Function to find the maximum value of N after inserting the digit K
	public static void maximizeNumber(int N, int K) {
		 
		String s = Integer.toString(N);
		int L = s.length();

		String result = "";
		int i = 0;

		// Iterate till all digits that
		// are not less than K
		while ((i < L) && (K <= ((int) s.charAt(i) - (int) '0'))) {

			// Add the current digit to
			// the string result
			result = result + (s.charAt(i));
			++i;
		}
		System.out.println("Result 1::"+result);
		// Add digit 'K' to result
		result = result + ((char) (K + (int) '0'));
		System.out.println("Result 2::"+result);
		// Iterate through all remaining
		// characters
		while (i < L) {

			// Add current digit to result
			result = result + (s.charAt(i));
			++i;
		}
		System.out.println("Result 3::"+result);
	}
}
