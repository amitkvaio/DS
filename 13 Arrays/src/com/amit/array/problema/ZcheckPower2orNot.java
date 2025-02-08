package com.amit.array.problema;
//check given number is power of 2 or not
public class ZcheckPower2orNot {
	public static void main(String[] args) {
		int num =64;
		boolean checkStatus = isPowerOfTwo(num);
		System.out.println("Given number::" + num + " is the power of 2 ::" + checkStatus);
	}
	
	public static boolean isPowerOfTwo(int n) {
		return (n > 0) && ((n & (n - 1)) == 0);
	}
}
/*
Optimal Approach: Using Bitwise AND (O(1) Time)

    A power of 2 has only one set bit (e.g., 4 = 100, 8 = 1000).
    Property: n & (n - 1) == 0 for powers of 2.
    Example:
        8 (1000) & 7 (0111) = 0000 → 0 ✅
        10 (1010) & 9 (1001) = 1000 → Not 0     
*/
