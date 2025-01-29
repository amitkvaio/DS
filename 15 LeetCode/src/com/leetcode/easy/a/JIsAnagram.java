package com.leetcode.easy.a;

import java.util.Arrays;

//10. Valid Anagram | 2 Approaches | Leetcode-242 | UBER
public class JIsAnagram {
	
	public static void main(String[] args) {
		String  s1 = "anagram", t1 = "nagaram";
		String s2 = "rat", t2 = "car";
		System.out.println(isAnagram(s1, t1));
		System.out.println(isAnagram(s2, t2));
		System.out.println("*******Using integer count array**************");
		System.out.println(isAnagramUsingArray(s1, t1));
		System.out.println(isAnagramUsingArray(s2, t2));
	}
	
	
	//Approach-1 (Using sorting)
	//T.C : O(nlogn)
	//S.C : O(1)
	public static boolean isAnagram(String s, String t) {
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();

		Arrays.sort(sChars);
		Arrays.sort(tChars);

		return Arrays.equals(sChars, tChars);
	}
	
	//Approach-1 (Using map)
	//T.C : O(n)
	//S.C : O(26) ~ O(1)
	public static boolean isAnagramUsingArray(String s, String t) {
		int[] count = new int[26];

		for (char ch : s.toCharArray()) {
			count[ch - 'a']++;
		}

		for (char ch : t.toCharArray()) {
			count[ch - 'a']--;
		}
		
		boolean allZeros = true;
		// Check if all elements in the array are 0
		for(int i = 0 ; i < count.length; i ++) {
			if(count[i]!=0) {
				allZeros = false;
			}
		}
		//boolean allZeros = Arrays.stream(count).allMatch(element -> element == 0);
		return allZeros;
	}
	
}





/*
10. Valid Anagram Leetcode-242


Given two strings s and t, return true if t is an
anagram
of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.

 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
Answer - Either use a hashmap to store or an interger array of size 128 will work (in Approach-2)
*/
