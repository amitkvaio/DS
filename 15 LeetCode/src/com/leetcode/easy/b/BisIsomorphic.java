package com.leetcode.easy.b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//28. Isomorphic Strings | Simple Thought Process | Leetcode 205| LinkedIn | codestorywithMIK
public class BisIsomorphic {
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println("************Using Map**********************");
		System.out.println(isIsomorphicUsingMap("egg", "add"));
		System.out.println(isIsomorphicUsingMap("foo", "bar"));
	}
	
	//T.C : O(n)
	//S.C : O(1) -> Take array of size 256 to handle all ASCII characters instead of taking map
	public static boolean isIsomorphic(String s, String t) {
		int[] mp1 = new int[256];
		int[] mp2 = new int[256];
		Arrays.fill(mp1, -1);
		Arrays.fill(mp2, -1);
		int n = s.length();

		for (int i = 0; i < n; i++) {
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);

			if ((mp1[ch1] != -1 && mp1[ch1] != ch2) || (mp2[ch2] != -1 && mp2[ch2] != ch1))
				return false;

			mp1[ch1] = ch2;
			mp2[ch2] = ch1;
		}

		return true;
	}
	
	//Using map
	//T.C : O(n)
	//S.C : O(1) -> size of map will not exceed 256
	public static boolean isIsomorphicUsingMap(String s, String t) {
        Map<Character, Character> mp1 = new HashMap<>();
        Map<Character, Character> mp2 = new HashMap<>();
        
        int m = s.length();
        
        for(int i = 0; i < m; i++) {
            
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if((mp1.containsKey(ch1) && mp1.get(ch1) != ch2) || 
               (mp2.containsKey(ch2) && mp2.get(ch2) != ch1)) {
                return false;
            }
            
            mp1.put(ch1, ch2);
            mp2.put(ch2, ch1);
        }
        
        return true;
    }
}

/*
205. Isomorphic String.
https://leetcode.com/problems/isomorphic-strings/description/
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.

Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true

 

Constraints:

    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.





*/