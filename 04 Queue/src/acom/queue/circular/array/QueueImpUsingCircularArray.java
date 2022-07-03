package acom.queue.circular.array;

import acom.queue.array.Queue;

public class QueueImpUsingCircularArray implements Queue {
	private int[] A;
	private int front;
	private int rear;
	private int size;
	private static int CAPACITY;

	public QueueImpUsingCircularArray(int n) {
		this.CAPACITY =n;
		A = new int[CAPACITY];
		front = -1;
		rear = -1;
		size = 0;
	}

	// TC :O(1)
	@Override
	public void enqueue(int data) {
		if (isQueueFull()) {
			throw new StackOverflowError("Queue is full!!");
		}
		if (front == -1)
			front = 0;
		rear = rear + 1;
		A[rear % CAPACITY] = data;
		size++;
	}

	// TC :O(n) : can be optimize using circular array
	@Override
	public int dequeue() {
		if (isEmpty())
			return -1;
		
		int data = A[front % CAPACITY];
		
		// if both are pointing to the same location
		if (front == rear) {
			front = -1;
			rear = -1;
		}
		front = front + 1;
		size = size - 1;
		return data;
	}

	@Override
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is Empty!!");
			return;
		} else {
			for (int i = front; i <= rear; i++) {
				System.out.print(A[i] + "-->");
			}
			System.out.println("Null");
		}
	}

	@Override
	public boolean isEmpty() {
		return rear == -1;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isQueueFull() {
		return rear == CAPACITY - 1;
	}

	@Override
	public int getFirst() {
		if (isEmpty())
			return -1;
		return A[front];
	}

	@Override
	public int getLast() {
		if (isEmpty())
			return -1;
		return A[rear];
	}
}
