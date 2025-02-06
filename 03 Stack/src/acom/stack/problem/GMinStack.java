package acom.stack.problem;

import java.util.Stack;

class Pair {
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class GMinStack {
	Stack<Pair> st;

	public GMinStack() {
		st = new Stack<>();
	}

	public void push(int x) {
		int min;
		if (st.isEmpty()) {
			min = x;
		} else {
			min = Math.min(st.peek().y, x);
		}
		st.push(new Pair(x, min));
	}

	public int pop() {
		return st.pop().x;
	}

	public int top() {
		return st.peek().x;
	}

	public int getMin() {
		return st.peek().y;
	}

	public static void main(String[] args) {
		GMinStack minStack = new GMinStack();

		minStack.push(20);
		System.out.println("Minimum element after push(" + minStack.top() + "): " + minStack.getMin());

		minStack.push(30);
		System.out.println("Minimum element after push(" + minStack.top() + "): " + minStack.getMin());

		minStack.push(10);
		System.out.println("Minimum element after push(" + minStack.top() + "): " + minStack.getMin());

		minStack.push(40);
		System.out.println("Minimum element after push(" + minStack.top() + "): " + minStack.getMin());

		System.out.println("Minimum element after pop(" + minStack.pop() + "): " + minStack.getMin());

		System.out.println("Minimum element after pop(" + minStack.pop() + "): " + minStack.getMin());
	}
}
/*
How to Implement Min Stack

The Min Stack is a special type of stack that support all the stack operations such as push(), pop(), isEmpty(), and isFull(). 
	In addition, Min Stack also supports one additional function getMin(), which is used to retrieve the minimum element 
	from the stack that is why it is also called the minimum stack.









*/