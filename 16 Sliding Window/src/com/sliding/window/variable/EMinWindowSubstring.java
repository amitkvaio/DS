package com.sliding.window.variable;

import java.util.HashMap;

/*
https://leetcode.com/problems/minimum-window-substring/description/

Given two strings s and t of lengths m and n respectively, return the minimum window
of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.


Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.


Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
*/
public class EMinWindowSubstring {
	public static void main(String[] args) {
		System.out.println("Result: "+ minWindow("ADOBECODEBANC", "ABC"));
		System.out.println("Result: "+ minWindow("a", "t"));
		System.out.println("Result: "+ minWindow("a", "aa"));
	}

	public static String minWindow(String str, String t) {
		String ans = "";

		int i = 0, j = 0;
		int min = Integer.MAX_VALUE;
		HashMap<Character, Integer> map = new HashMap<>();
		
		// Step 1: Store the frequency of each character in string 't'
		for (int k = 0; k < t.length(); k++) {
			char c = t.charAt(k);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// Count of unique characters needed from 't'
		int count = map.size();

		// Step 2: Traverse the main string using sliding window
		while (j < str.length()) {
			char c = str.charAt(j);
			
			// If current char is in the map, decrease its count
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					count--;
			}

			// Step 3: Try to shrink the window from the left and All characters matched
			if (count == 0) {
				while (count == 0) {
					char c1 = str.charAt(i);
					
					// Update answer if current window is smaller
					if (min > j - i + 1) {
						ans = str.substring(i, j + 1);
						min = Math.min(min, j - i + 1);
					}
					
					// Move the start pointer forward and update map and count
					if (map.containsKey(c1)) {
						map.put(c1, map.get(c1) + 1);
						if (map.get(c1) > 0)
							count++;
					}
					i++; // Shrink the window
				}
			}
			j++;// Expand the window
		}
		return ans;
	}
}
