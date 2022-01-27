package acom.stack.problem;

import java.util.NoSuchElementException;

import acom.stack.array.StackUsingArray;

public class AStack {
	private int top;
	private int length;
	private char[] arr;
	private int size;

	public AStack(int stackSize) {
		top = -1;
		length = 0;
		size = stackSize;
		arr = new char[size];
	}

	public boolean isEmpty() {
		return (top < 0);
	}

	public int getLength() {
		return length;
	}

	public boolean isStackFull() {
		return (top == size - 1);
	}

	public void push(char data) {
		if (top >= size - 1) {
			throw new IndexOutOfBoundsException("Stack OverFlow Exception!!");
		} else {
			arr[++top] = data;
			length++;
		}
	}

	public int pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack UnderFlow Exception!!");
		}
		length--;
		int x = arr[top--];
		return x;
	}

	public char peek() {
		System.out.println("Top :" + top);
		if (isEmpty()) {
			throw new NoSuchElementException("Stack UnderFlow Exception!!");
		}
		return arr[top];
	}

	public void display() {
		System.out.println("Display : top " + top);
		if (isEmpty()) {
			System.out.println("Stack Is Empty!!");
		} else {
			for (int i = top; i >= 0; i--) {
				System.out.println(arr[i]);
			}
		}
	}

	public void createStack(StackUsingArray stack) {
		for (int i = 0; i < 5; i++) {
			stack.push(i + 10);
		}
	}
}