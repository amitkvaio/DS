package com.recursion;

import java.util.ArrayList;
import java.util.List;

// Generate Parentheses | 2 Approaches | Magic Of Recursion | Recursion Concepts And Questions
//22. Generate Parentheses
public class LGenerateParentheses {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println("*************************");
		System.out.println(generateParenthesis(1));
	}
	
	
	// Approach-1 (Simple Recursion)
	//T.C : O(2n* (2^(2n)) -> Removing constant -> O(n * (2^n))
	//S.C : O(2*n) -> Removing constant -> O(n) -> recursion stack space - Max depth of recusion tree
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generate("", n, 0, result);
		return result;
	}

	// Function to check if the parentheses are valid
	private static boolean isValid(String str) {
		int sum = 0;
		for (char ch : str.toCharArray()) {
			if (ch == '(')
				sum++;
			else
				sum--;
			if (sum < 0)
				return false;
		}
		return sum == 0;
	}

	// Recursive function to generate parentheses
	private static void generate(String curr, int n, int length, List<String> result) {
		if (length == 2 * n) {
			if (isValid(curr))
				result.add(curr);
			return;
		}

		curr += '(';
		generate(curr, n, length + 1, result);
		curr = curr.substring(0, curr.length() - 1); // remove the last character

		curr += ')';
		generate(curr, n, length + 1, result);
	}
}
/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

 

Constraints:

    1 <= n <= 8

*/
