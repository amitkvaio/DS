package acom.stack.queue;



import acom.queue.array.Queue;
import acom.queue.array.QueueImp;
import acom.stack.array.Stack;

public class StackImplUsingTwoQueue implements Stack {

	//TO-DO
	Queue queq1 = new QueueImp(5);
	Queue queq2 = new QueueImp(5);
	
	@Override
	public boolean isEmpty() {
		return queq1.isEmpty();
	}

	@Override
	public int getLength() {
		return queq1.getSize();
	}

	@Override
	public void push(int data) {
		while(!queq1.isEmpty()) {
			queq2.enqueue(queq1.dequeue());
		}
		queq1.enqueue(data);
		while(!queq2.isEmpty()) {
			queq1.enqueue(queq2.dequeue());
		}
	}

	@Override
	public int pop() {
		return queq1.dequeue();
	}

	@Override
	public int peek() {
		while(!queq1.isEmpty()) {
			queq2.enqueue(queq1.dequeue());
		}
		int data = queq2.getFirst();
		while(!queq2.isEmpty()) {
			queq1.enqueue(queq2.dequeue());
		}
		return data;
	}

	@Override
	public void display() {
		
	}

	@Override
	public boolean isStackFull() {
		return queq1.isQueueFull();
	}

}
