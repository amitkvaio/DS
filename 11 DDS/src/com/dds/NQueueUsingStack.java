package com.dds;

import java.util.Stack;

public class NQueueUsingStack {
	private Stack<Integer> input;
	private Stack<Integer> output;

	public NQueueUsingStack() {
		input = new Stack<>();
		output = new Stack<>();
	}

	public void push(int x) {
		input.push(x);
	}

	public int pop() {
		shiftStacks();
		return output.pop();
	}

	public int peek() {
		shiftStacks();
		return output.peek();
	}

	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}

	private void shiftStacks() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
	}

	public static void main(String[] args) {
		NQueueUsingStack queue = new NQueueUsingStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // Output: 1
        System.out.println(queue.pop());  // Output: 1
        queue.push(3);
        queue.push(6);
        System.out.println(queue.empty()); // Output: false
        System.out.println(queue.pop());  // Output: 2
        System.out.println(queue.pop()); // Output: 3
        System.out.println(queue.pop()); // Output: 6
        System.out.println(queue.empty()); // Output: True
    }
}

/*
https://leetcode.com/problems/implement-queue-using-stacks/description/
Leetcode : 232
*/