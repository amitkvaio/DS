package com.dds;

import java.util.LinkedList;
import java.util.Queue;

public class EStackUsingTwoQueue {
	
	Queue<Integer> queue1;
	Queue<Integer> queue2;
	
	
	public EStackUsingTwoQueue() {
		 queue1 = new LinkedList<Integer>();
		 queue2 = new LinkedList<Integer>();
	}
	
	public void push(int val) {
		queue2.offer(val);
		
		while(!queue1.isEmpty()) {
			queue2.offer(queue1.poll());
		}
		
		while(!queue2.isEmpty()) {
			queue1.offer(queue2.poll());
		}
	}
	
	public int pop() {
		if(queue1.isEmpty())
			return -1;
		return queue1.poll();
	}
	
	public int top() {
		return queue1.peek();
	}
	
	public boolean empty() {
		return queue1.isEmpty();
	}
	
	public static void main(String[] args) {
		EStackUsingTwoQueue stack = new EStackUsingTwoQueue();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());//2
		System.out.println(stack.pop());//2
		System.out.println(stack.empty());//False
	}
}
/*
https://leetcode.com/problems/implement-stack-using-queues/description/
Leetcode-225
*/
