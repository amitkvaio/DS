/*

Find the Longest Substring without Repeating Characters
I/P : geeksforgeeks
O/P : ksforge

@Test
void givenString_whenGetUniqueCharacterSubstringCalled_thenResultFoundAsExpected() {
    assertEquals("", getUniqueCharacterSubstring(""));
    assertEquals("A", getUniqueCharacterSubstring("A"));
    assertEquals("ABCDEF", getUniqueCharacterSubstring("AABCDEF"));
    assertEquals("ABCDEF", getUniqueCharacterSubstring("ABCDEFF"));
    assertEquals("NGISAWE", getUniqueCharacterSubstring("CODINGISAWESOME"));
    assertEquals("be coding", getUniqueCharacterSubstring(""));
}

*/
package com.amit.array.problemb;

import java.util.HashSet;
import java.util.Set;

public class LlongestSubString {
	public static void main(String[] args) {
		String str1 = "geeksforgeeks";
		String str2 = "abcc";
		getLongestSubString("");
		getLongestSubString("A");
		getLongestSubString("AABCDEF");
		getLongestSubString("ABCDEFF");
		getLongestSubString("CODINGISAWESOME");
		getLongestSubString("always be coding");
		getLongestSubString(str1);
		getLongestSubString(str2);
		System.out.println("==========================");
		getLongestBruteForce("abcc");
	}

	//TC : O(n*n) SC : O(1)
	public static void getLongestBruteForce(String str) {
		if (str == null || str == "")
			return;
		int n = str.length();
		int max = 0 ;
		int start = 0;
		int end =0;
		for (int i=0; i < n; i++) {
			for (int j = i + 1; j < n + 1; j++) {
				//Finding the all the substring and checking whether the substring contains the
				//duplicate character or not.
				if(checkDuplicate(str.substring(i, j))) {
					i++;
					System.out.println("Duplicate::"+str.substring(i, j));
				}else {
					String unique = str.substring(i, j);
					if(max < unique.length()) {
						max = unique.length();
						start =i;
						end = j;
					}
					//System.out.println("Unique:"+str.substring(i, j));
				}
			}
		}
		System.out.println("Unique String ::"+str.substring(start,end) +"---"+str.substring(start, end).length());
	}
	
	public static boolean checkDuplicate(String str) {
		Set<Character> set = new HashSet<Character>();
		for (Character ch : str.toCharArray()) {
			if(!set.add(ch)) {
				return true;
			}
		}
		return false;
	}
	
	public static void getLongestSubString(String str) {
		int left = 0;
		int right = 0;
		int n = str.length();
		int max = 0;
		HashSet<Character> set = new HashSet<Character>();
		String output = "";
		while (right < n) {
			char ch = str.charAt(right);
			if (set.add(ch)) {
				max = Math.max(max, right - left + 1);
				right++;
			} else {
				while (str.charAt(left) != ch) {
					set.remove(str.charAt(left));
					left++;
				}
				set.remove(str.charAt(left));
				left++;
			}
			if (output.length() < (right - left + 1)) {
				output = str.substring(left, right);
			}
		}
		System.out.println(output + "-" + max);
	}
}
