package com.recursion;

public class PRegularExpressionMatching1 {
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a")); // False
		System.out.println(isMatch("aa", "a*"));//True
		System.out.println(isMatch("ab", ".*"));//True
	}
	
	//Approach-1 (Using Recursion)
	//T.C : In worst case, the function may recursively call itself twice for each character in the pattern (due to *), leading to an exponential number of recursive calls.
	        //Hence, time complexity will be approaximately O(2^(max(n, m))). where n , m are lengths of s and p respectively.
	//S.C : O(m) - Recursion stack space : where m = length of pattern (maximum depth of recursion tree)
	//NOTE : We are passing substr to isMatch every time and hence they are being copied to x and p so, we will be creating O(2^(max(n, m))) number of substrings.
	
	public static boolean isMatch(String text, String pattern) {
		if (pattern.length() == 0) {
			return text.length() == 0;
		}

		boolean firstCharMatched = false;
		if (text.length() > 0 && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.')) {
			firstCharMatched = true;
		}

		// Best example to understand: s = "aaab", p = "a*b"
		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (isMatch(text, pattern.substring(2)) || (firstCharMatched && isMatch(text.substring(1), pattern)));
		} else {
			return firstCharMatched && isMatch(text.substring(1), pattern.substring(1));
		}
	}

}


/*
10. Regular Expression Matching.
https://leetcode.com/problems/regular-expression-matching/description/

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

    '.' Matches any single character.​​​​
    '*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

 

Constraints:

    1 <= s.length <= 20
    1 <= p.length <= 20
    s contains only lowercase English letters.
    p contains only lowercase English letters, '.', and '*'.
    It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.





*/
