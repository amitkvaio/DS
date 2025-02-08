package com.problem.soving01;

public class UElongestSubstringWithConsecutiveCharacters {
	public static void main(String[] args) {
		String str = "zabcdabcabdefghiijklmn";
		int len = str.length();
		longestSubString(str, len);
	}

	public static void longestSubString(String str, int len) {
		int subLen = 0;
		int i = 0;
		int endIndex = 0;
		String str1 = "";
		while (i < len) {
			endIndex = getTheEndIndex(i, str, len);
			str1 = str.substring(i, endIndex);
			System.out.println("subString:" + str1);
			if (subLen < str1.length()) {
				subLen = str1.length();
			}
			i = endIndex;
		}
		System.out.println("Length of the longest subString : " + subLen);
	}

	public static int getTheEndIndex(int sIdx, String str, int len) {
		// String str1 = "abcab";//[0,1,2,3,4]
		sIdx++;
		while (sIdx < len) {
			char current = str.charAt(sIdx);
			char prev = str.charAt(sIdx - 1);
			if (current - prev == 1) {
				sIdx++;
			} else {
				break;
			}
		}
		return sIdx;
	}
}