package com.recursion;

import java.util.Arrays;

//Approach-2 (Recursion + Memoization)
//T.C : O(m*n)
//S.C : O(m*n)

public class PRegularExpressionMatching2 {
	
	int[][] t;
	
	public static void main(String[] args) {
		PRegularExpressionMatching2 exp = new PRegularExpressionMatching2();
		System.out.println(exp.isMatch("aa", "a")); // False
		System.out.println(exp.isMatch("aa", "a*"));//True
		System.out.println(exp.isMatch("ab", ".*"));//True
	}

	public boolean solve(int i, int j, String text, String pattern) {
		if (j == pattern.length()) {
			return i == text.length();
		}

		if (t[i][j] != -1) {
			return t[i][j] == 1;
		}

		boolean ans = false;

		boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

		if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
			ans = (solve(i, j + 2, text, pattern) || (first_match && solve(i + 1, j, text, pattern)));
		} else {
			ans = first_match && solve(i + 1, j + 1, text, pattern);
		}

		return (t[i][j] = ans ? 1 : 0) == 1;
	}

	public boolean isMatch(String text, String pattern) {
		t = new int[21][21];
		for (int[] row : t) {
			Arrays.fill(row, -1);
		}
		return solve(0, 0, text, pattern);
	}
}
