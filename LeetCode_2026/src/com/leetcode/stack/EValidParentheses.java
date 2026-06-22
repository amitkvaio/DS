package com.leetcode.stack;

import java.util.Stack;

public class EValidParentheses {
	
	public static void main(String[] args) {
		System.out.println(isValid("()")); //True
		System.out.println(isValid("(]")); //False
		System.out.println(isValid("([])")); //True
		System.out.println(isValid(")[]{}"));//false
		System.out.println(isValid("([)]")); // False
	}
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {

			// if String character is opening bracket then push into the stack
			char currentChar = s.charAt(i);
			if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
				stack.push(currentChar);
			} else {

				if (stack.isEmpty()) {
					return false;
					// if the current character is closing bracket and top element of the stack is
					// closing bracket respectively then pop the top element of the stack.
				} else if (stack.peek() == '(' && currentChar == ')' || stack.peek() == '{' && currentChar == '}'
						|| stack.peek() == '[' && currentChar == ']') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}

/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
	determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

 

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Example 5:
Input: s = "([)]"
Output: false
*/