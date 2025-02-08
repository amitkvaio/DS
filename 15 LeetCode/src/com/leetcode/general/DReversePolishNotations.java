package com.leetcode.general;

import java.util.Stack;

//Reverse polish notation == Post fix notation.
public class DReversePolishNotations {
	public static void main(String[] args) {
		String[] str = { "2", "1", "+", "3", "*" };
		int output = evaluatePostFixNotation(str);
		System.out.println("Result::" + output);
	}

	public static int evaluatePostFixNotation(String[] str) {
		int n = str.length;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			String type = str[i];
			if (checkOperator(type)) {
				switch (type) {
				case "+": {
					stack.push(stack.pop() + stack.pop());
					break;
				}
				case "-": {
					stack.push(stack.pop() - stack.pop());
					break;
				}
				case "*": {
					stack.push(stack.pop() * stack.pop());
					break;
				}
				case "/": {
					stack.push(stack.pop() / stack.pop());
					break;
				}
				}
			} else {
				stack.push(Integer.valueOf(str[i]));
			}
		}
		return stack.pop();
	}

	public static boolean checkOperator(String str) {
		if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str))
			return true;
		return false;
	}

}
/*
 *First check whether it is operator or operand 
 *if it is operand then push into the stack
 *if operator then -->pop two elements from the stack and perform the operation and resultant
 *value push it back into the stack- follow it until reached to the last element of the array.
 *pop and return the last element from the stack that would be the output.
 * TC : O(n) SC : O(n)
 * 
 */