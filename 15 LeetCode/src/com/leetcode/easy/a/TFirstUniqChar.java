package com.leetcode.easy.a;

// 20. First Unique Character in a String | Easy | Leetcode 387
public class TFirstUniqChar {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
		System.out.println(firstUniqChar("aabb"));
	}
	
	//T.C : O(n)
	//S.C : O(1)
	public static int firstUniqChar(String s) {
		int[] arr = new int[26];

		for (char ch : s.toCharArray()) {
			arr[ch - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (arr[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
}



/*
387. First Unique character in a string.
https://leetcode.com/problems/first-unique-character-in-a-string/description/

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"

Output: 2

Example 3:

Input: s = "aabb"

Output: -1

 

Constraints:

    1 <= s.length <= 105
    s consists of only lowercase English letters.



*/