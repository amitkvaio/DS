package com.sliding.window.fixed;

import java.util.Arrays;

public class DFindOfTotalCountOfAnagram {
	public static void main(String[] args) {
		System.out.println(getTotalAnagramCount("forxxorfxdofr", "for"));// 3
		System.out.println(getTotalAnagramCount("aabaabaa", "aaba"));// 4
		System.out.println(getTotalAnagramCount("abab", "ab"));// 3
		System.out.println(getTotalAnagramCount("abcde", "fgh"));// 0
	}

	private static int getTotalAnagramCount(String str, String pattern) {
		int n = str.length();
		int k = pattern.length();

		// Arrays to count character frequency for pattern and sliding window
		int[] patternFreq = new int[26];
		int[] windowFreq = new int[26];

		// Build the frequency array for the pattern
		for (char ch : pattern.toCharArray()) {
			patternFreq[ch - 'a']++;
		}

		int start = 0, anagramCount = 0;

		// Slide the window over the input string
		for (int end = 0; end < n; end++) {
			// Add the current character to the window frequency
			windowFreq[str.charAt(end) - 'a']++;

			// If the current window size matches the pattern length
			if ((end - start + 1) == k) {

				// Compare both frequency arrays
				if (Arrays.equals(patternFreq, windowFreq)) {
					anagramCount++; // Found an anagram
				}

				// Slide the window: remove the starting character from the frequency
				windowFreq[str.charAt(start) - 'a']--;
				start++; // Move the window forward
			}
		}

		return anagramCount;
	}
}
/*
Time and Space Complexity:

Time Complexity: O(n * 26) → effectively O(n)
(since comparing two fixed-size arrays takes constant time)

Space Complexity: O(1)
(only two fixed-size arrays of 26 characters)
*/
