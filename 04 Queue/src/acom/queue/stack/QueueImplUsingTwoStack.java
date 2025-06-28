package acom.queue.stack;

import java.util.Stack;

import acom.queue.array.Queue;

public class QueueImplUsingTwoStack implements Queue {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
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
		
		/*
			if stack1 is not empyt pop all the element from stack1 and puph into stack2
			Once done, then push the data into stack1 and pop all the remaining data from stack2 to stack1
		*/
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		
		stack1.push(data);
		
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}

	@Override
	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty!");
		}
		return stack1.pop();
	}

	@Override
	public int getFirst() {
		// If queue is empty returning -1
		if (stack1.isEmpty()) {
			return -1;
		}
		// First elements would be the top of the stack elements
		return stack1.peek();
	}

	@Override
	public int getLast() {
		//If queue is empty returning -1
		if (stack1.isEmpty()) {
			return -1;
		}
		//Last elements will be the very bottom of the stack1
		//Moving all the elements from stack1 to stack2 so the top of the elements of stack2 become the 
		//last elements
		
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int lastElemet = stack2.peek();
		
		//Moving all the elements from stack2 to stack1 as it is.
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return lastElemet;
	}

	@Override
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return;
		}
		System.out.print("Front ");
		for (int i = stack1.size() - 1; i >= 0; i--) {
			System.out.print(stack1.get(i) + " ");
		}
		System.out.println(" Rear");
	}
}
