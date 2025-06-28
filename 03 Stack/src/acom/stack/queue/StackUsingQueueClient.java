package acom.stack.queue;

public class StackUsingQueueClient {
	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.display();
		System.out.println("##############");
		System.out.println("Top element of the stack ::"+stack.peek());
		System.out.println("Stack size is ::"+stack.size());
		
		System.out.println("########After two elements poped up #########");
		stack.pop();
		stack.pop();
		stack.display();
		System.out.println("Stack is empty::"+stack.isEmpty());
	}
}
