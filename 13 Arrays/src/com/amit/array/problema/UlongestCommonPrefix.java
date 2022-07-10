package com.amit.array.problema;

/*

Longest Common Prefix in an array of Strings in java
*/
public class UlongestCommonPrefix {
	public static void main(String[] args) {
		String[] strArr = { "java2blog", "javaworld", "javabean", "javatemp" };
		String longestPrefix = getLongestCommonPrefix(strArr);
		System.out.println("Longest Prefix : " + longestPrefix);
	}

	public static String getLongestCommonPrefix(String[] strArr) {
		if (strArr.length == 0)
			return "";
		// Find minimum length String
		String minStr = getMinString(strArr);

		int minPrefixStrLength = minStr.length();
		for (int i = 0; i < strArr.length; i++) {
			int j;
			for (j = 0; j < minPrefixStrLength; j++) {
				if (minStr.charAt(j) == strArr[i].charAt(j))
					continue;
				else
					break;
			}
			if (j < minPrefixStrLength)
				minPrefixStrLength = j;
		}
		return minStr.substring(0, minPrefixStrLength);
	}

	public static String getMinString(String[] strArr) {
		String minStr = strArr[0];
		for (int i = 1; i < strArr.length; i++) {
			if (strArr[i].length() < minStr.length())
				minStr = strArr[i];
		}
		return minStr;
	}
}
