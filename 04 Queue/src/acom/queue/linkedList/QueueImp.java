package acom.queue.linkedList;

import acom.queue.array.Queue;

public class QueueImp implements Queue {
	private Node front;
	private Node rear;
	private int length;

	public QueueImp() {
		this.front = null;
		this.rear = null;
		this.length = 0;
	}

	@Override
	public boolean isEmpty() {
		return (length == ZERO);
	}

	@Override
	public int getSize() {
		return length;
	}

	@Override
	public boolean isQueueFull() {
		// it will not use here
		return false;
	}

	@Override
	public void enqueue(int data) {
		Node newNode = new Node(data);// Create a new node with the value

		// if the queue is empty, then the front and rear will both point to the same
		// name
		if (isEmpty()) {
			rear = newNode;
			front = newNode;
			return;
		} else {
			rear.next = newNode;// Adding the new node at the end of the queue.
		}
		rear = newNode; // Updating the rear pointer to the new ndoe.
		length++;
	}

	@Override
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty!! deQueue not possible!!");
			return -1;
		}
		int result = front.data; // Getting the front element value.
		front = front.next; // Moving the front pointer to the next node
		if (front == null) {
			rear = null;
		}
		length--;
		return result;
	}

	@Override
	public int getFirst() {
		if (front == null) {
			return -1;
		}
		return front.data;
	}

	@Override
	public int getLast() {
		if (rear == null) {
			return -1;
		}
		return rear.data;
	}

	@Override
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty!!");
		} else {
			while (front != null) {
				System.out.print(front.data + "-->");
				front = front.next;
			}
			System.out.print("NULL");
		}
	}
}
