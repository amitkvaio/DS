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
		System.out.println(maximizeNumber(N, K));
	}
	
	static String maximizeNumber(int N, int K) {
		String num = String.valueOf(N);
		StringBuilder result = new StringBuilder();
		boolean inserted = false;

		// Traverse each digit and find the best position to insert K
		for (int i = 0; i < num.length(); i++) {
			if (!inserted && (num.charAt(i) - '0') < K) {
				result.append(K); // Insert K before this digit
				inserted = true;
			}
			result.append(num.charAt(i));
		}

		// If K is not inserted, append it at the end
		if (!inserted) {
			result.append(K);
		}

		return result.toString();
	}
}
