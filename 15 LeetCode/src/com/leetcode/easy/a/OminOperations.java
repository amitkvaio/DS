package com.leetcode.easy.a;
//15. Minimum Changes To Make Alternating Binary String | 2 Approaches | MICROSOFT | Leetcode 1758
public class OminOperations {
	public static void main(String[] args) {
		System.out.println(minOperations("0100"));//1
		System.out.println(minOperations("10"));//0
		System.out.println(minOperations("1111"));//2
		System.out.println("************************");
		System.out.println(minOperations_("0100"));//1
		System.out.println(minOperations_("10"));//0
		System.out.println(minOperations_("1111"));//2
	}
	
	//Approach-1 (String can start from 0, string can start from 1)
	//T.C : O(n)
	//S.C : O(n)
	public static int minOperations(String str) {
		int n = str.length();
							  //111111	
		int start_with_0 = 0;// 010101...
		int start_with_1 = 0;// 101010...
		 
		
		for (int i = 0 ; i < n ; i++) {
			if(i%2==0) { //Even
				if(str.charAt(i)=='0') {
					start_with_1++;
				}else {
					start_with_0++;
				}
			}else {
				if(str.charAt(i)=='1') {
					start_with_1++;
				}else {
					start_with_0++;
				}
			}
		}
		return Math.min(start_with_0, start_with_1);
	}
	
	//Approach-2 (No need to calculate both)
	//T.C : O(n)
	//S.C : O(1)
	public static int minOperations_(String s) {
		int n = s.length();
		int start_with_0 = 0;

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				if (s.charAt(i) == '1') {
					start_with_0++;
				}
			} else {
				if (s.charAt(i) == '0') {
					start_with_0++;
				}
			}
		}
		return Math.min(start_with_0, n - start_with_0);
	}
}
/*

Index is starting from 0
If it is starting from zero 010101
Odd position index is start from one
Even position index is starting from zero

If it is starting from one 101010
Odd position index is start from Zero
Even position index is starting from one

Leetcode : 1758 :: minimum-changes-to-make-alternating-binary-string

https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/

You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.

The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.

Return the minimum number of operations needed to make s alternating.

 

Example 1:

Input: s = "0100"
Output: 1
Explanation: If you change the last character to '1', s will be "0101", which is alternating.

Example 2:

Input: s = "10"
Output: 0
Explanation: s is already alternating.

Example 3:

Input: s = "1111"
Output: 2
Explanation: You need two operations to reach "0101" or "1010".

 

Constraints:

    1 <= s.length <= 104
    s[i] is either '0' or '1'.



*/
