package com.leetcode.easy.a;

import java.util.Arrays;
import java.util.HashMap;

//17. Largest Substring Between Two Equal Characters | 3 Ways | C++ | JAVA | Leetcode 1624
public class QmaxLengthBetweenEqualCharacters {
	public static void main(String[] args) {
		System.out.println(maxLengthBetweenEqualCharacters("aa"));
		System.out.println(maxLengthBetweenEqualCharacters("abca"));
		System.out.println(maxLengthBetweenEqualCharacters("cbzxy"));
		System.out.println("*************************************");
		System.out.println(maxLengthBetweenEqualCharactersUsingMap("aa"));
		System.out.println(maxLengthBetweenEqualCharactersUsingMap("abca"));
		System.out.println(maxLengthBetweenEqualCharactersUsingMap("cbzxy"));
		System.out.println("*************************************");
		System.out.println(maxLengthBetweenEqualCharactersUsingArray("aa"));
		System.out.println(maxLengthBetweenEqualCharactersUsingArray("abca"));
		System.out.println(maxLengthBetweenEqualCharactersUsingArray("cbzxy"));
		System.out.println("*************************************");
	}
	
	
	//Approach-1 (Using Brute Force) - ACCEPTED
	//T.C : O(n^2)
	//S.C : O(1)
	public static int maxLengthBetweenEqualCharacters(String s) {
		int result = -1;
		int n = s.length();

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					result = Math.max(result, j - i - 1);
				}
			}
		}
		return result;
	}
	
	//Approach-2 (Using Hashmap) - ACCEPTED
	//T.C : O(n)
	//S.C : O(n)
	public static int maxLengthBetweenEqualCharactersUsingMap(String s) {
		int n = s.length();
		HashMap<Character, Integer> mp = new HashMap<>();

		int result = -1;

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);

			if (!mp.containsKey(ch)) {
				mp.put(ch, i);
			} else {
				result = Math.max(result, i - mp.get(ch) - 1);
			}
		}

		return result;
	}
	
	//Approach-3 (Using integer array instead of map)
	//T.C : O(n)
	//S.C : O(26) ~ O(1)
	public static int maxLengthBetweenEqualCharactersUsingArray(String s) {
        int n = s.length();
        int[] count = new int[26];
        Arrays.fill(count, -1);
        
        int result = -1;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (count[ch - 'a'] == -1) {
                count[ch - 'a'] = i;
            } else {
                result = Math.max(result, i - count[ch - 'a'] - 1);
            }
        }
        return result;
    }
	
}
/*
Leetcode 1624 largest-substring-between-two-equal-characters
https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/

Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.

Example 2:

Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".

Example 3:

Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.

 

Constraints:

    1 <= s.length <= 300
    s contains only lowercase English letters.



*/
