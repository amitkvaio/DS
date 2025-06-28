package acom.stack.problem;

import java.util.Stack;

public class HReverseStringStack {
	public static String reverseString(String str) {
		Stack<Character> stack = new Stack<>();

		for (char ch : str.toCharArray()) {
			stack.push(ch);
		}

		StringBuilder reversed = new StringBuilder();
		while (!stack.isEmpty()) {
			reversed.append(stack.pop());
		}

		return reversed.toString();
	}

	public static void main(String[] args) {
		String str = "Java";
		System.out.println("Reversed String: " + reverseString(str)); // Output: "avaJ"
	}
}

/*
A stack can be used to reverse a string by pushing all characters onto the stack 
	and then popping them one by one.
*/
