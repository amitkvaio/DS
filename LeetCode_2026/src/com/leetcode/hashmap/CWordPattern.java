package com.leetcode.hashmap;

import java.util.HashMap;

public class CWordPattern {
	
	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println("******************************************");
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println("*********************************************");
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
	}
	
	public static boolean wordPattern(String pattern, String s) {
		String[] sArray = s.split(" ");
		if(pattern.length()!=sArray.length)
			return false;
		
		HashMap<Character, String> pMap = new HashMap<>();
		HashMap<String, Character> sMap = new HashMap<>();
		
		for(int i = 0 ; i < sArray.length ; i ++) {
			char pChar = pattern.charAt(i);
			String tStr = sArray[i];
			
			if( pMap.containsKey(pChar) && ! pMap.get(pChar).equals(tStr))
				return false;
			else
				pMap.put(pChar, tStr);
			
			if( sMap.containsKey(tStr) &&  sMap.get(tStr) != pChar)
				return false;
			else
				sMap.put(tStr, pChar);
		}
		System.out.println(pMap);
		System.out.println(sMap);
		return true;
	}
}
/*
290 Word Pattern

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a 
	letter in pattern and a non-empty word in s. Specifically:

    Each letter in pattern maps to exactly one unique word in s.
    Each unique word in s maps to exactly one letter in pattern.
    No two letters map to the same word, and no two words map to the same letter.

 

Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:

The bijection can be established as:
    'a' maps to "dog".
    'b' maps to "cat".


Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false


Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false



*/