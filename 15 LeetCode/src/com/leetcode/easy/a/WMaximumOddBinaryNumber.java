package com.leetcode.easy.a;
//23. Maximum Odd Binary Number | 2 Approaches | Leetcode 2864
public class WMaximumOddBinaryNumber {
	public static void main(String[] args) {
		System.out.println(maximumOddBinaryNumber("010"));
		System.out.println(maximumOddBinaryNumber("0101"));
		System.out.println("*****************************");
		System.out.println(maximumOddBinaryNumber_("010"));
		System.out.println(maximumOddBinaryNumber_("0101"));
	}
	
	//Approach-1 (greedily assigning 1s)
	//T.C : O(n)
	//S.C : O(n) for result
	public static String maximumOddBinaryNumber(String s) {
		int n = s.length();
		// Initialize result string with '0' of length n
		StringBuilder result = new StringBuilder();
		for (int k = 0; k < n; k++) {
			result.append('0');
		}

		int i = 0;

		for (char ch : s.toCharArray()) {
			if (ch == '1') {
				if (result.charAt(n - 1) == '1') { //LSB =1 for it to be odd number, if 1 is already set at LSB then set 1 at MSB
					result.setCharAt(i, '1');
					i++;
				} else {
					result.setCharAt(n - 1, '1');
				}
			}
		}
		return result.toString();
	}
	
	//Approach-2 (Count 1s and assign)
	//T.C : O(n)
	//S.C : O(n) for result
	 public static String maximumOddBinaryNumber_(String s) {
	        int n = s.length();

	        // Initialize result string with '0' of length n
	        StringBuilder result = new StringBuilder();
	        for (int k = 0; k < n; k++) {
	            result.append('0');
	        }

	        int countOnes = 0;
	        for (char ch : s.toCharArray()) {
	            if (ch == '1') {
	                countOnes++;
	            }
	        }

	        int j = 0;

	        while (countOnes > 1) {
	            result.setCharAt(j, '1');
	            j++;

	            countOnes--;
	        }

	        result.setCharAt(n - 1, '1');
	        return result.toString();
	    }
}

/*
2864. Maximum odd Binary number.


You are given a binary string s that contains at least one '1'.

You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.

Return a string representing the maximum odd binary number that can be created from the given combination.

Note that the resulting string can have leading zeros.

 

Example 1:

Input: s = "010"
Output: "001"
Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".

Example 2:

Input: s = "0101"
Output: "1001"
Explanation: One of the '1's must be in the last position. The maximum number that can be made with the remaining digits is "100". So the answer is "1001".

 

Constraints:

    1 <= s.length <= 100
    s consists only of '0' and '1'.
    s contains at least one '1'.







*/
