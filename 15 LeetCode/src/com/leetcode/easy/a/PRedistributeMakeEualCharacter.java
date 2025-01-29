package com.leetcode.easy.a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//16. Redistribute Characters to Make All Strings Equal | 3 Ways | C++ | JAVA | Leetcode 1897
public class PRedistributeMakeEualCharacter {
	public static void main(String[] args) {
		System.out.println(makeEqualUsingMap(new String[] {"abc","aabc","bc"}));
		System.out.println(makeEqualUsingMap(new String[] {"ab","a"}));
		System.out.println("***********************************************");
		System.out.println(makeEqualUsingArray(new String[] {"abc","aabc","bc"}));
		System.out.println(makeEqualUsingArray(new String[] {"ab","a"}));
		System.out.println("***********************************************");
		System.out.println(makeEqualUsingArray_(new String[] {"abc","aabc","bc"}));
		System.out.println(makeEqualUsingArray_(new String[] {"ab","a"}));
	}
	
	//Approach-1 (Using hashmap to store frequency)
	//T.C : O(n)
	//S.C : O(n)
	public static boolean makeEqualUsingMap(String[] words) {
        int n = words.length;
        Map<Character, Integer> count = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                count.put(ch, count.getOrDefault(ch, 0) + 1);
            }
        }

        for (int value : count.values()) {
            if (value % n != 0) {
                return false;
            }
        }
        return true;
    }
	
	//Approach-2 (Using hash map store frequency)
	//T.C : O(n)
	//S.C : O(26)
	public static boolean makeEqualUsingArray(String[] words) {
		int n = words.length;
		int[] count = new int[26];

		for (String word : words) {
			for (char ch : word.toCharArray()) {
				count[ch - 'a']++;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (count[i] % n != 0) {
				return false;
			}
		}

		return true;
	}
	
	//Approach-3 (Using library and array as hashmap)
	//T.C : O(n)
	//S.C : O(1)
	public static boolean makeEqualUsingArray_(String[] words) {
		int n = words.length;
		int[] count = new int[26];

		for (String word : words) {
			for (char ch : word.toCharArray()) {
				count[ch - 'a']++;
			}
		}
		return Arrays.stream(count).allMatch(c -> c % n == 0);
	}
}

/*
https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/description/
Leetcode: 1897 redistribute-characters-to-make-all-strings-equal 

You are given an array of strings words (0-indexed).

In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].

Return true if you can make every string in words equal using any number of operations, and false otherwise.

 

Example 1:

Input: words = ["abc","aabc","bc"]
Output: true
Explanation: Move the first 'a' in words[1] to the front of words[2],
to make words[1] = "abc" and words[2] = "abc".
All the strings are now equal to "abc", so return true.

Example 2:

Input: words = ["ab","a"]
Output: false
Explanation: It is impossible to make all the strings equal using the operation.

 

Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 100
    words[i] consists of lowercase English letters.



*/
