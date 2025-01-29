package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Power Set | Same as Subsets | Magic Of Recursion | Recursion Concepts And Questions
public class MPowerSet {
	public static void main(String[] args) {
		System.out.println(allPossibleStrings("abc"));
		System.out.println("**************************");
		System.out.println(allPossibleStrings("aa"));
	}

	// Approach-1 (Without For Loop)
	//T.C : O(n * 2^n) - For ever index, we have two possibilities so 2^n and for copying each string to result, it takes O(n)
	// S.C : O(n) - Recursion tree depth will be at max = n (NOTE : I have ignored
	// space taken for storing result)
	private static void solve(StringBuilder curr, String s, int idx, List<String> result) {
		if (idx == s.length()) {
			if (curr.length() > 0) {
				result.add(curr.toString());
			}
			return;
		}

		curr.append(s.charAt(idx));
		solve(curr, s, idx + 1, result);
		curr.deleteCharAt(curr.length() - 1);
		solve(curr, s, idx + 1, result);
	}

	public static List<String> allPossibleStrings(String s) {
		List<String> result = new ArrayList<>();
		StringBuilder curr = new StringBuilder();

		solve(curr, s, 0,result);

		Collections.sort(result);

		return result;
	}
}


/*
https://www.geeksforgeeks.org/problems/power-set4302/1

Given a string s of length n, find all the possible non-empty subsequences of the string s in lexicographically-sorted order.

Example 1:

Input : 
s = "abc"
Output: 
a ab abc ac b bc c
Explanation : 
There are a total 7 number of subsequences possible for the given string, and they are mentioned above in lexicographically sorted order.

Example 2:

Input: 
s = "aa"
Output: 
a a aa
Explanation : 
There are a total 3 number of subsequences possible for the given string, and they are mentioned above in lexicographically sorted order.

Your Task:
You don't need to read input or print anything. Your task is to complete the function AllPossibleStrings() which takes a string s as the input parameter and returns a list of all possible subsequences (non-empty) that can be formed from s in lexicographically sorted order.

Expected Time Complexity: O( n*2n  )
Expected Space Complexity: O( n * 2n )

Constraints: 
1 <= n <= 16
s constitutes of lower case english alphabets
Company Tags

*/