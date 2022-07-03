package acom.queue.circular.array;

public class QueueDriveUsingCircularArrays {
	public static void main(String[] args) {
		QueueImpUsingCircularArray queue = new QueueImpUsingCircularArray(4);
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
		System.out.println("Get Last : "+queue.getLast());
		print(queue);
		System.out.println("After dequeu :"+queue.dequeue());
		print(queue);
	}
	public static void print(QueueImpUsingCircularArray queue) {
		System.out.println("isQueEmpty :"+queue.isEmpty());
		System.out.println("Get Queue Size : "+queue.getSize());
		System.out.println("Is Queue Full : "+queue.isQueueFull());
		System.out.println("Get First : "+queue.getFirst());
		System.out.println("Get Last : "+queue.getLast());
		queue.display();
		System.out.println("***************************************");
	}
}
