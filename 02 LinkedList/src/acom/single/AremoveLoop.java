package acom.single;

public class AremoveLoop {
static Node head=null;

public static void main(String[] args) {
	createLoop();
	boolean loopStatus = detectLoop();
	System.out.println("Loop Status : "+loopStatus);
	Util.displayList(head);
	System.out.println("=================");
	removeLoop();
	Util.displayList(head);
	
	/*System.out.println("**********************");
	removeLoopUsingIsVisitedNode(head);
	System.out.println("************Done************");
	System.out.println("After Removing loop!!");
	Util.displayList(head);*/
}
	
//Used to create the loop in linked List
public static void createLoop() {
	Node first = new Node(1);
	Node second = new Node(2);
	Node third = new Node(3);
	Node fourth = new Node(4);
	Node fifth = new Node(5);
	Node sixth = new Node(6);

	head = first;
	first.next = second;
	second.next = third;
	third.next = fourth;
	fourth.next = fifth;
	fifth.next = sixth;
	sixth.next = third;
}
		
public static boolean detectLoop() {
	// If list is empty or has only one node without loop
	if (head == null || head.next == null) {
		return false;
	}
	Node slowPtr = head;
	Node fastPtr = head;
	/*
	while (fastPtr != null && fastPtr.next != null) {
		fastPtr = fastPtr.next.next;
		slowPtr = slowPtr.next;
		if (slowPtr == fastPtr)
			return true;
	}
	*/
	while (slowPtr != null && slowPtr.next != null) {
		fastPtr = fastPtr.next.next;
		slowPtr = slowPtr.next;
		if (slowPtr == fastPtr)
			return true;
	}
	return false;
}
		
// Remove the loop
public static void removeLoop() {
	// If list is empty or has only one node without loop
	if (head == null || head.next == null) {
		return;
	}
	Node slowPtr = head;
	Node fastPtr = head;
	
	while(fastPtr!=null && fastPtr.next!=null) {
		fastPtr = fastPtr.next.next;
		slowPtr = slowPtr.next;
		if(slowPtr==fastPtr) {
			removeLoop(slowPtr, fastPtr);
			break;
		}
	}
}
		
// Function to remove loop 
public static void removeLoop(Node slowPtr, Node firstPtr) { 
	slowPtr = head;
	Node temp = null;
	while (slowPtr != firstPtr) {
		slowPtr = slowPtr.next;
		temp = firstPtr;
		firstPtr = firstPtr.next;
	}
	temp.next = null;
}
	   
	public static void removeLoopUsingIsVisitedNode(Node head) {
		if (head == null) {
			return;
		} else {
			Node temp = head;
			Node previous = null;
			while (temp.isVisited != true) {
				temp.isVisited = true;
				previous = temp;
				temp = temp.next;
			}
			previous.next = null;
			System.out.println("Starting of Loop Node::" + temp.data);
			System.out.println("Previous of starting of loop Node Data ::" + previous.data);
		}
	}
}
