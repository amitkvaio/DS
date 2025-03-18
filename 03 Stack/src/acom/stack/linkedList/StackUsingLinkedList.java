package acom.stack.linkedList;

import acom.stack.array.Stack;
//Like Adding the first node = push operation
// delete the first node = pop() 
public class StackUsingLinkedList implements Stack{
	private Node top;
	private int length;
	
	public StackUsingLinkedList() {
		top = null;
		length=0;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		return length;
	}

	//Its similar to adding a new node at first of the Linked List
	@Override
	public void push(int data) {
		Node newNode = new Node(data);
		if(isEmpty()) {
			top=newNode;
		}else {
			top.next=newNode;
			top=newNode;
		}
		length++;
	}

	//Its similar to deleting a node at first node in the Linked List
	@Override
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty POP not posssible!!");
			return -1;
		}
		int result = top.data;
		top = top.next;
		length--;
		return result;
	}

	@Override
	public int peek() {
		if(isEmpty()){
			return -1;
		}
		return top.data;
	}

	@Override
	public void display() {
		 
	}

	@Override
	public boolean isStackFull() {
		// TODO Auto-generated method stub
		return false;
	}
}

/*
Time Complexity:
Operation	Time Complexity
Push		O(1)
Pop			O(1)
Peek		O(1)
IsEmpty		O(1)

Advantages of Stack using Linked List:
*****************************************

    Dynamic Size: Unlike arrays, linked lists do not require a predefined size.
    Efficient Memory Utilization: No wasted memory, as memory is allocated dynamically.
    No Resizing Issues: No overhead of resizing like an array.

Disadvantages of Stack using Linked List:
*******************************************

    Extra Memory Overhead: Each node requires additional memory for storing pointers.
    Cache Unfriendliness: Due to non-contiguous memory allocation, performance can be slightly slower than arrays.
    Complex Implementation: More complex than an array-based stack.


*/
