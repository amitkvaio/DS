package com.leetcode.easy.a;

import java.util.Arrays;
//2 Find Words That Can Be Formed by Characters | META | Leetcode 1160
public class BFindWordLength {
	public static void main(String[] args) {
		String [] words = {"hello","world","leetcode"};
		//{"cat","bt","hat","tree"};
		String chars = "welldonehoneyr";
		//"atach"; Ans : 6
		int len = countCharacter(words, chars);
		System.out.println(len);
	}
	
	//T.C : O(words.length())
	//S.C : O(26)
	public static int countCharacter(String[] words, String chars) {
		int[] charCount = new int[26];
		
		System.out.println(Arrays.toString(charCount));
		for (char ch : chars.toCharArray()) {
			int i = ch - 'a';
			charCount[i] = charCount[i] + 1 ;
		}
		
		int result = 0;
		for (String word : words) {
			int[] wordCount = new int[26];
			for (char ch : word.toCharArray()) {
				int i = ch - 'a';
				wordCount[i] = wordCount[i] + 1 ;
			}
			boolean ok = true;
			for (int i = 0; i < 26 ; i++) {
				if(wordCount[i] > charCount[i]) {
					ok = false;
					break;
				}
			}
			
			if(ok) {
				result = result + word.length();
			}
			
		}
		return result;
	}
}

/*
1160. Find Words That Can Be Formed by Characters

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.

 

Constraints:

    1 <= words.length <= 1000
    1 <= words[i].length, chars.length <= 100
    words[i] and chars consist of lowercase English letters.








*/
