package com.leetcode.hashmap;

import java.util.HashMap;

public class ARansomNote {
	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (char ch : magazine.toLowerCase().toCharArray()) {
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}
		int count = 0;
		for (char ch : ransomNote.toLowerCase().toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				count++;
				if (map.get(ch) == 0) {
					map.remove(ch);
				}
				
			} else
				return false;

		}
		return count == ransomNote.length();
	}
}

/*
383 Ransom Note
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

Time complexity: O(m + n)
Space complexity: O(k), with k being the number of unique characters in the magazine

*/