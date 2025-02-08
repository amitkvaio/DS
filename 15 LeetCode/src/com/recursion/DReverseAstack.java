package com.recursion;

import java.util.Stack;

//Reverse a Stack | O(n) Auxiliary Space | O(1) Auxiliary Space
public class DReverseAstack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		reverseStack(stack);
		System.out.println(stack);
	}

	// Function to reverse the stack
	public static void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		int top = stack.pop(); // Remove the top element
		reverseStack(stack); // Recursively reverse the remaining stack
		insertAtBottom(stack, top); // Insert the removed element at the bottom
	}

	// Function to insert an element at the bottom of the stack
	private static void insertAtBottom(Stack<Integer> stack, int value) {
		if (stack.isEmpty()) {
			stack.push(value);
			return;
		}

		int top = stack.pop(); // Remove the top element
		insertAtBottom(stack, value); // Recursively insert at the bottom
		stack.push(top); // Push the removed element back
	}
}
/*
Time Complexity: O(n*n)(Each element is pushed and popped multiple times)
Space Complexity: O(n)(Due to recursion call stack)
*/
