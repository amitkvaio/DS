package acom.queue.stack;

import java.util.Stack;

import acom.queue.array.Queue;

public class QueueImplUsingTwoStack implements Queue {
	
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public int getSize() {
		return stack1.size();
	}

	@Override
	public boolean isQueueFull() {
		return getSize() == stack1.capacity();
	}

	@Override
	public void enqueue(int data) {
		if(isQueueFull()) {
			System.out.println("Queue is full!!");
			return;
		}
		stack1.push(data);
	}

	@Override
	public int dequeue() {
		if (!stack2.isEmpty()) {
			stack2.clear();
		}
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int data = stack2.pop();
		
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return data;
	}

	@Override
	public int getLast() {
		if(stack1.isEmpty())
			return -1;
		return stack1.peek();
	}

	@Override
	public int getFirst() {
		if (stack1.isEmpty())
			return -1;
		if (!stack2.isEmpty()) {
			stack2.clear();
		}
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int data = stack2.peek();

		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return data;
	}

	@Override
	public void display() {
		if (stack1.isEmpty())
			System.out.println("Queue is empty!!");
		if (!stack2.isEmpty()) {
			stack2.clear();
		}
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		
		while (!stack2.isEmpty()) {
			int data = stack2.pop();
			System.out.print(data + "-->");
			stack1.push(data);
		}
		System.out.println();
	}
}
