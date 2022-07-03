package acom.queue.array;

public class QueueImp implements Queue {
	private int[] A;
	private int front;
	private int rear;
	private int size;

	public QueueImp(int n) {
		A = new int[n];
		front = 0;
		rear = -1;
		size = 0;
	}

	// TC :O(1)
	@Override
	public void enqueue(int data) {
		if (isQueueFull()) {
			throw new StackOverflowError("Queue is full!!");
		}
		rear = rear + 1;
		A[rear] = data;
		size++;
	}

	// TC :O(n) : can be optimize using circular array
	@Override
	public int dequeue() {
		if (isEmpty())
			return -1;
		int data = A[front];
		for (int i = 0; i < rear; i++) {
			A[i] = A[i + 1];
		}
		rear = rear - 1;
		size = size - 1;
		return data;
	}

	@Override
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is Empty!!");
			return;
		} else {
			for (int i = 0; i < size; i++) {
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
		return rear == A.length - 1;
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
