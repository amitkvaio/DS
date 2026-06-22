package com.leetcode.twopointer;

public class AValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome(" "));
		System.out.println(isPalindrome(".,"));
	}

	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		s = s.toLowerCase();

		while (left < right) {

			// skip non-alphanumeric from left
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}

			// skip non-alphanumeric from right
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}

			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;

		}
		return true;
	}
}
/*
125 Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase 
letters and removing all non-alphanumeric characters, it reads the same forward and backward. 
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.



*/