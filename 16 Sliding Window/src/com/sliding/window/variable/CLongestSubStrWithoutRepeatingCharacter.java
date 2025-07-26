package com.sliding.window.variable;

import java.util.HashMap;

/*
Given a string s having lowercase characters, find the length of the longest substring without repeating characters. 
Input: s = "geeksforgeeks"
Output: 7 
Explanation: The longest substrings without repeating characters are "eksforg” and "ksforge", with lengths of 7.

Input: s = "aaa"
Output: 1
Explanation: The longest substring without repeating characters is "a"

Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring without repeating characters is "abcdef".
*/
public class CLongestSubStrWithoutRepeatingCharacter {
	public static void main(String[] args) {
		System.out.println(getLongestUniqueSubString("geeksforgeeks"));
		System.out.println(getLongestUniqueSubString("aaa"));
		System.out.println(getLongestUniqueSubString("abcdefabcbb"));
	}
	
	public static int getLongestUniqueSubString(String str) {
		int i = 0;
		int j = 0;
		int longestLength = -1;
		int n = str.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		while (j < n) {

			// Step 1: Add the current character to the map and increase its frequency
			map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);

			// Step 2: Invalid state - this will never happen
			// map.size() > (j - i + 1) is NOT possible
			// because the number of unique characters cannot be more than total characters
			// in the window
			if (map.size() > (j - i + 1)) {
				j++;
			}

			// Step 3: Valid window - all characters are unique
			if (map.size() == (j - i + 1)) {
				longestLength = Math.max(longestLength, j - i + 1);
			}

			// Step 4: Invalid window - duplicates exist (some characters are repeating)
			else if (map.size() < (j - i + 1)) {
				// If window has duplicate characters, shrink it
				while (map.size() < (j - i + 1)) {
					char leftChar = str.charAt(i);
					map.put(leftChar, map.get(leftChar) - 1);
					if (map.get(leftChar) == 0) {
						map.remove(leftChar);
					}
					i++;
				}
			}
			j++;
		}
		return longestLength;
	}
}
