package com.bit.manupulation;
//Number of 1 Bits | 4 Approaches | Time Complexity | Apple | Microsoft | Amazon | Leetcode 191
public class ANumberOfOneBits {
	public static void main(String[] args) {
		System.out.println("********* Using Hamming Weight Using Right Shift ***********");
		System.out.println(hammingWeightUsingRightShift(11));//3
		System.out.println(hammingWeightUsingRightShift(128));//1
		System.out.println(hammingWeightUsingRightShift(2147483645));//30
		
		System.out.println("********* Using Hamming Weight Using Bit Magic ***********");
		System.out.println(hammingWeightUsingBitMagic(11));//3
		System.out.println(hammingWeightUsingBitMagic(128));//1
		System.out.println(hammingWeightUsingBitMagic(2147483645));//30
		
		System.out.println("********* Using Hamming Weight Using simple Math ***********");
		System.out.println(hammingWeighUsingSimpleMath(11));//3
		System.out.println(hammingWeighUsingSimpleMath(128));//1
		System.out.println(hammingWeighUsingSimpleMath(2147483645));//30
		
		System.out.println("********* Using Hamming Weight Using in built function ***********");
		System.out.println(hammingWeight(11));//3
		System.out.println(hammingWeight(128));//1
		System.out.println(hammingWeight(2147483645));//30
	}
	
	// Approach-1 (Using simple right shift operator)
	// T.C : O(1) - because the loop in the code iterates 32 times, which is a constant number regardless of the input n
	// S.C : O(1)
	
	public static int hammingWeightUsingRightShift(int n) {
		int count = 0;

		for (int i = 31; i >= 0; i--) {
			if (((n >> i) & 1) == 1) {
				count++;
			}
		}
		return count;
	}
	
	// Approach-2 (Using simple bit magic)
	// T.C : O(k) -> Where k = number of set bits (1s) in input 'n'
	// S.C : O(1)
	public static int hammingWeightUsingBitMagic(int n) {
		int count = 0;

		while (n != 0) {
			n = n & (n - 1); // This expression is used to turn off the rightmost set bit in n. This
								// operation effectively removes one set bit in each iteration.
			count++;
		}
		return count;
	}
	
	// Approach-3 (Using simple bit magic)
	// T.C : O(log(n)) -> In each iteration, n is divided by 2 (n /= 2)
	// S.C : O(1)
	public static int hammingWeighUsingSimpleMath(int n) {
		int count = 0;

		while (n != 0) {
			count += (n % 2);
			n /= 2;
		}

		return count;
	}
	
	// Approach-4 (using built-in Java function)
	// T.C : O(k) -> Where k = number of set bits (1s) in input 'n'
	// S.C : O(1)
	public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}

/*

191. Number of 1 bits
Given a positive integer n, write a function that returns the number of
set bits
in its binary representation (also known as the Hamming weight).

 

Example 1:

Input: n = 11

Output: 3

Explanation:

The input binary string 1011 has a total of three set bits.

Example 2:

Input: n = 128

Output: 1

Explanation:

The input binary string 10000000 has a total of one set bit.

Example 3:

Input: n = 2147483645

Output: 30

Explanation:

The input binary string 1111111111111111111111111111101 has a total of thirty set bits.

 

Constraints:

    1 <= n <= 231 - 1

 
Follow up: If this function is called many times, how would you optimize it?

*/