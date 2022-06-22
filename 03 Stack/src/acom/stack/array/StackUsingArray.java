package acom.stack.array;

import java.util.NoSuchElementException;

public class StackUsingArray implements Stack{
	public int top;
	private int length;
	public int[] arr;
	private int size;
	
	public StackUsingArray(int stackSize) {
		top =-1;
		length=0;
		size=stackSize;
		arr = new int[size];
	}

	@Override
	public boolean isEmpty() {
		return (top < 0);
	}

	@Override
	public int getLength() {
		return length;
	}
	
	@Override
	public boolean isStackFull() {
		return (top==size-1);
	}

	@Override
	public void push(int data) {
		if(!isStackFull()) {
			top++;
            arr[top] = data;
            System.out.println("Pushed element:" + data);
            length++;
        } else {
            System.out.println("Stack is full !");
            throw new IndexOutOfBoundsException("Stack OverFlow Exception!!");
        }
	}

	@Override
	public int pop() {
		if (!isEmpty()) {
            int returnedTop = top;
            top--;
            length--;
            System.out.println("Popped element :" + arr[returnedTop]);
            return arr[returnedTop];
        } else {
            System.out.println("Stack is empty !");
        }
		return -1;
	}

	@Override
	public int peek() {
		System.out.println("Top :"+ top);
		if(isEmpty()) {
			throw new NoSuchElementException("Stack UnderFlow Exception!!");
		}
		return arr[top];
	}

	@Override
	public void display() {
		System.out.println("Display : top " +top);
		if(isEmpty()) {
			System.out.println("Stack Is Empty!!");
		}else {
			for (int i = top; i >= 0; i--) {
				System.out.println(arr[i]);
			}
		}
	} 
	
	public void createStack(StackUsingArray stack) {
		for (int i = 0; i < 5 ; i++) {
			stack.push(i+10);
		}
	}
}

/*

Why we use top== -1 for implementation of stack using simple array?
Arrays are zero-based. 
So when top == 0 it means there is one element on the stack. 
By consequence, if the stack is empty, the top index is set to -1 
so that when the first element is added, it is incremented to 0.


push: Push element to the top of the Stack.This operation will increase size of stack by 1.
pop: Remove element from the top of the Stack and returns the deleleted Object.
	This operation will decrease size of stack by 1.
isEmpty: Check if Stack is empty or not.
isFull: Check if Stack is full or not.
peek: Returns top element from the stack without removing it.
Please note that time complexity of all above operation is constant i.e. O(1) 

*/
