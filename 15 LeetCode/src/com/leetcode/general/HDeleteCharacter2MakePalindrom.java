package com.leetcode.general;
/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it. 

Example 1:

Input: s = "aba"
Output: true

Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:

Input: s = "abc"
Output: false


Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.
*/
public class HDeleteCharacter2MakePalindrom {
	public static void main(String[] args) {
		String str = "abda";
		System.out.println(palindrome(str));
	}
	
	public static boolean palindrome(String str) {
		int start = 0;
		int end = str.length()-1;
		while(start <=end) {
			if(str.charAt(start)!=str.charAt(end)) {
				// 2 cases
	            // delete s  check for A[s+1...e]
	            // delete e check for A[s...e-1]
				if(check(str, start+1, end) ||check(str, start, end-1)) {
					return true;
				}else {
					// after deleting 1 char we are unable to obtain a palindrome
					return false;
				}
			}
			start++;
			end--;
		}
		 // string is already palin
		return true;
	}
	
	public static boolean check(String str,int start, int end) {
		while(start <=end) {
			if(str.charAt(start)!=str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}


