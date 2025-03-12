package com.dds;

import java.util.LinkedList;
import java.util.Queue;

public class FStackUsingOneQueue {

	Queue<Integer> queue;

	public FStackUsingOneQueue() {
		queue = new LinkedList<Integer>();
	}

	public void push(int val) {
		//Adding an element into the queue, if the size is greater than 1, reversing the all the element accept the last one.
		// just pop from the front and push into the back.
		queue.offer(val);
		if (queue.size() > 1) {
			for (int i = 0; i < queue.size() - 1; i++) {
				queue.offer(queue.poll());
			}
		}
	}

	public int pop() {
		if (queue.isEmpty())
			return -1;
		return queue.poll();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}

	public static void main(String[] args) {
		FStackUsingOneQueue stack = new FStackUsingOneQueue();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());//2
		System.out.println(stack.pop());//2
		System.out.println(stack.empty());//False
		System.out.println("********************");
	}
}
/*
https://leetcode.com/problems/implement-stack-using-queues/description/
Leetcode-225
Follow-up: Can you implement the stack using only one queue?
*/


