package com.recursion;

import java.util.ArrayList;
import java.util.List;
//Approach-2 (Smart Recursion)
//T.C : O(2^n)
//S.C : O(2*n) -> Removing constant -> O(n) -> recursion stack space - Max depth of recursion tree
public class LGenerateParentheses2 {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println("*************************");
		System.out.println(generateParenthesis(1));
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		solve(n, "", 0, 0,result);
		return result;
	}

	private static void solve(int n, String curr, int open, int close, List<String> result) {
		if (curr.length() == 2 * n) {
			result.add(curr);
			return;
		}

		if (open < n) {
			curr += '(';
			solve(n, curr, open + 1, close, result);
			curr = curr.substring(0, curr.length() - 1);
		}
		if (close < open) {
			curr += ')';
			solve(n, curr, open, close + 1, result);
			curr = curr.substring(0, curr.length() - 1);
		}
	}
}
