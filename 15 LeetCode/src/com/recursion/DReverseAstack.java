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
		reverse(stack);
		System.out.println("*****************");
		reverse_(stack);
	}
	
	//Approach-1 (Using O(n) Auxiliary Space (we took extra one temp stack))
	//Simply write a story like recursion and trust it
	//Time : O(n^2)
	//Space : O(n) Auxiliary Space (we took extra one temp stack)
	
	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		
		int top = stack.pop();
		reverse(stack); // Recursively reverse the remaining stack

		// Move the top element to the bottom of the stack
		Stack<Integer> temp = new Stack<>();
		while (!stack.isEmpty()) {
			temp.push(stack.pop());
		}

		stack.push(top); // Push the top element at the bottom

		// Push back the remaining elements
		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		//printing reverse stack
		System.out.println(stack);
	}
	
	//Approach-2 (Using O(1) Auxiliary Space)
	//Simply write a story like recursion and trust it
	//Time : O(n^2)
	//Space : O(1) Auxiliary Space
	public static void reverse_(Stack<Integer> St) {
		if (St.isEmpty()) {
			return;
		}

		int top = St.pop();
		reverse(St);
		insertAtBottom(St, top);
		System.out.println(St);
	}
	
	public static void insertAtBottom(Stack<Integer> St, int element) {
		if (St.isEmpty()) {
			St.push(element);
			return;
		}
		int curTopElement = St.pop();
		insertAtBottom(St, element);
		St.push(curTopElement);
	}
}
/*
https://www.geeksforgeeks.org/problems/reverse-a-stack/1

*/
