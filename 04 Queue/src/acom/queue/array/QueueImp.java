package acom.queue.array;

public class QueueImp implements Queue {
	private int[] queue;
	private int front;
	private int rear;
	private int size;
	private int capacity;

	public QueueImp(int capacity) {
		this.capacity = capacity;
		this.queue = new int[capacity];
		this.front = 0;
		this.rear = -1;
		this.size = 0;
	}

	// TC :O(1)
	@Override
	public void enqueue(int data) {
		if (isQueueFull()) {
			System.out.println("Queue Overflow");
		}
		rear = (rear + 1) % capacity; // Circular increment
		queue[rear] = data;
		size++;
	}

	// TC :O(n) : can be optimize using circular array
	@Override
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			return -1;
		}
		int data = queue[front];
		front = (front + 1) % capacity; // Circular increment
		size--;
		return data;
	}

	@Override
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is Empty!!");
			return;
		} else {
			for (int i = 0; i < size; i++) {
				System.out.print(queue[i] + "-->");
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
		return rear == queue.length - 1;
	}

	@Override
	public int getFirst() {
		if (isEmpty())
			return -1;
		return queue[front];
	}

	@Override
	public int getLast() {
		if (isEmpty())
			return -1;
		return queue[rear];
	}
}

/*
Time Complexity:
Operation	Time Complexity
Enqueue		O(1)
Dequeue		O(1)
Peek		O(1)
IsEmpty		O(1)
IsFull		O(1)

Advantages of Queue using Array:
***********************************
    Fast Operations: All operations run in O(1) time.
    Memory Efficient: No extra memory for pointers (unlike linked lists).
    Cache Friendly: Array elements are stored contiguously, improving performance.

Disadvantages of Queue using Array:
************************************
    Fixed Size: The queue size is fixed, leading to wasted memory or queue overflow.
    Resizing Overhead: If resizing is required, copying elements to a new array takes O(n) time.
*/
