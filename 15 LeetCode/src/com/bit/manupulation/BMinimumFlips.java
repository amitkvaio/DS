package com.bit.manupulation;
//Minimum Flips to Make a OR b Equal to c | 2 Approaches | Microsoft | Leetcode-1318 | Explanation
public class BMinimumFlips {
	public static void main(String[] args) {
		System.out.println(minFlips(2, 6, 5));//3
		System.out.println(minFlips(4, 2, 7));//1
		System.out.println(minFlips(1, 2, 3));//0
	}
	
	public static int minFlips(int a, int b, int c) {
		int result = 0;

		while (a != 0 || b != 0 || c != 0) {

			if ((c & 1) == 1) {
				if ((a & 1) == 0 && (b & 1) == 0) {
					result++;
				}
			} else {
				result += (a & 1) + (b & 1);
			}

			a >>= 1;
			b >>= 1;
			c >>= 1;

		}

		return result;
	}
}
/*
1318. Minimum Flips to make a OR b Equal to c

Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

 

Example 1:
0010 --> a
0110 --> b
----------
0101 --> c

0001 --> a
0100 --> b
------------
0101 --> c



Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)

Example 2:

Input: a = 4, b = 2, c = 7
Output: 1

Example 3:

Input: a = 1, b = 2, c = 3
Output: 0

 

Constraints:

    1 <= a <= 10^9
    1 <= b <= 10^9
    1 <= c <= 10^9


*/