package leet.code.general;

import java.util.Stack;

/* 
Remove all adjacent duplicate in the string
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

You are given a string s consisting of lowercase English letters. 
	A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. 
	It can be proven that the answer is unique.


Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, 
	and this is the only possible move.  The result of this move is that the string is "aaca", 
		of which only "aa" is possible, so the final string is "ca".

Example 2:

Input: s = "azxxzy"
Output: "ay"


*/


public class I {
	public static void main(String[] args) {
		String input = "azxxzy";
		String str = removeAdjacentDuplicate(input);
		System.out.println(str);
		System.out.println("*****************************");
		String output = inPlaceRemoveAdjacentDuplicate("abbaca");
		System.out.println(output);
	}

	private static String removeAdjacentDuplicate(String input) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			if(stack.isEmpty() ||input.charAt(i)!=stack.peek()) {
				stack.push(input.charAt(i));
			}else {
				stack.pop();
			}
		}
		StringBuilder builder = new StringBuilder();
		if(stack.isEmpty()) {
			return "Empty String";
		}else {
			while(!stack.isEmpty()) {
				builder.append(stack.pop());
			}
		}
		return new String(builder.reverse());
	}
//TC: O(n) SC: O(n)
	
	// simulate inplace stack
	public static String inPlaceRemoveAdjacentDuplicate(String input) {
		char[] A = input.toCharArray();
		int stptr = -1;
		for (int i = 0; i < A.length; i++) {
			if (stptr == -1 || A[i] != A[stptr]) {
				stptr++;
				A[stptr] = A[i];
			} else {
				stptr--;
			}
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i <= stptr; i++) {
			builder.append(A[i]);
		}
		return new String(builder);
	}
	//TC: O(n) SC: O(1)
}
