package acom.stack.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	private Queue<Integer> queue;

	public StackUsingQueue() {
		queue = new LinkedList<Integer>();
	}

	public void push(int data) {
		int size = queue.size();
		queue.offer(data);
		for (int i = 0; i < size; i++) {
			int elements = queue.poll();
			queue.offer(elements);
		}
	}

	public int pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return queue.poll();
	}

	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return queue.peek();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public int size() {
		return queue.size();
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Stack Is Empty!!");
		}else {
			for (Integer num : queue) {
				System.out.println(num);
			}
		}
	}
}
/*
TC : o(n) :  Where n is the number of elements in the queue.
SC : o(n) :  Where n is the number of elements in the queue.
*/