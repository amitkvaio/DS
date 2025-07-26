package com.sliding.window.variable;

import java.util.HashMap;

/*
Given a string s and a non negative integer k, 
	find the length of the longest substring that contains exactly k distinct 
If no such substring exists, return -1.
Input: s = "aaba cbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.

Input: s = "aaaa", k = 2
Output: -1
Explanation: The string contains only one unique character, so there's no substring with 2 distinct characters.

Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
*/
public class BLongestSubStringWithKUniqueCharacter {
	public static void main(String[] args) {
		System.out.println(getLongestSubString("aabacbebebe", 3));
		System.out.println(getLongestSubString("aaaa", 2));
		System.out.println(getLongestSubString("aabaaab", 2));
		System.out.println(getLongestSubString("abaccab", 2));
	}

	public static int getLongestSubString(String str, int k) {
		int i = 0;
		int j = 0;
		int maxSub = -1;
		int n = str.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		while (j < n) {

			map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);

			// If the number of unique characters is less than k, expand window
			if (map.size() < k) {
				j++;
			} 
			// If the number of unique characters is exactly k, check max
			else if (map.size() == k) {
				maxSub = Math.max(j - i + 1, maxSub);
				j++;
			} 
			// If more than k unique characters, shrink window from left
			else if (map.size() > k) {
				while (map.size() > k) {
					char leftChar = str.charAt(i);
					map.put(leftChar, map.get(leftChar) - 1);
					if (map.get(leftChar) == 0) {
						map.remove(leftChar);
					}
					i++;
				}
			}
		}
		return maxSub;
	}
}

/*
Time Complexity (TC):

We use two pointers:
    i (start of the window)
    j (end of the window)

Let n be the length of the input string str.
How many times do i and j move?
    Both i and j traverse the entire string once from left to right.
    Each character is added and removed from the map at most once.
✅ So, each pointer moves at most n times, making the total time complexity:

SC = O(k)

*/
