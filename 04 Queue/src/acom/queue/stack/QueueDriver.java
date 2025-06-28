package acom.queue.stack;

import acom.queue.array.Queue;

public class QueueDriver {
	public static void main(String[] args) {
		Queue queue = new QueueImplUsingTwoStack();
		queue.enqueue(100);
		queue.enqueue(200);
		queue.enqueue(300);
		queue.enqueue(400);
		
		print(queue);
		System.out.println("After dequeu :"+queue.dequeue());
		print(queue);
		System.out.println("After dequeu :"+queue.dequeue());
		print(queue);
		System.out.println("After dequeu :"+queue.dequeue());
		print(queue);
		System.out.println("Get First : "+queue.getFirst());
		print(queue);
		System.out.println("After dequeu :"+queue.dequeue());
		print(queue);
	}
	public static void print(Queue queue) {
		System.out.println("isQueEmpty :"+queue.isEmpty());
		System.out.println("Get Queue Size : "+queue.getSize());
		System.out.println("Is Queue Full : "+queue.isQueueFull());
		System.out.println("Get First : "+queue.getFirst());
		System.out.println("Get Last : "+queue.getLast());
		queue.display();
		System.out.println("***************************************");
	}
}
/*
isQueEmpty :false
Get Queue Size : 4
Is Queue Full : false
Get First : 400
Get Last : 100
Front 100 200 300 400  Rear
***************************************
After dequeu :100
isQueEmpty :false
Get Queue Size : 3
Is Queue Full : false
Get First : 400
Get Last : 200
Front 200 300 400  Rear
======================================
*/