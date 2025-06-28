package acom.stack.array;

public class StackUsingArray implements Stack{
	public int top;
	private int length;
	public int[] stack;
	private int capacity;
	
	public StackUsingArray() {
		top =-1;
		length=0;
		capacity=10;
		stack = new int[capacity];
	}

	@Override
	public boolean isEmpty() {
		  return top == -1;
	}

	@Override
	public int size() {
		return length;
	}
	
	@Override
	public boolean isStackFull() {
		return (top==capacity-1);
	}

	@Override
	public void push(int data) {
		if (top == capacity - 1) {
			System.out.println("Stack Overflow");
			return;
		}
		stack[++top] = data;
	}

	@Override
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return stack[top--];
	}

	@Override
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return stack[top];
	}

	@Override
	public void display() {
		System.out.println("Display : top " +top);
		if(isEmpty()) {
			System.out.println("Stack Is Empty!!");
		}else {
			for (int i = top; i >= 0; i--) {
				System.out.println(stack[i]);
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
********************************************************************
Arrays are zero-based. 
So when top == 0 it means there is one element on the stack. 
By consequence, if the stack is empty, the top index is set to -1 
so that when the first element is added, it is incremented to 0.


push: Push element to the top of the Stack.This operation will increase size of stack by 1.
pop: Remove element from the top of the Stack and returns the delete Object.
	This operation will decrease size of stack by 1.
isEmpty: Check if Stack is empty or not.
isFull: Check if Stack is full or not.
peek: Returns top element from the stack without removing it.
Please note that time complexity of all above operation is constant i.e. O(1) 

Time Complexity:
***************
Operation	Time Complexity
Push		O(1)
Pop			O(1)
Peek		O(1)
IsEmpty		O(1)
Size		O(1)

Space complexity
*****************
O(n) where n is the maximum size of the stack.
	This is because we are using an array of fixed size to store the element in the stack.

Advantages of Stack using Array:
********************************
    Fast Operations: Push, Pop, and Peek operations take O(1) time.
    Memory Efficiency: No extra memory is required for pointers, unlike a linked list.
    Cache Friendly: Arrays provide better cache locality compared to linked lists.

Disadvantages of Stack using Array:
**********************************
    Fixed Size: The stack size is predefined, which can lead to wasted memory or stack overflow.
    Resizing Overhead: If resizing is required, it takes O(n) time to copy elements into a new array.

*/
