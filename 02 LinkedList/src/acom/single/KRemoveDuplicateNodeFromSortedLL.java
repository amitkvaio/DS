
package acom.single;

import acom.single.imp.Node;

public class KRemoveDuplicateNodeFromSortedLL {
	
	static Node head = null;
	public static void main(String[] args) {
		createLoop();
		Util.displayList(head);
		removeDuplicateNodeFromSortedLL();
		
		System.out.println("After Removal of duplicate node");
		Util.displayList(head);
		System.out.println("************Done************");
	}
	
	private static void removeDuplicateNodeFromSortedLL() {
		Node currentNode = head;
		Node nextNode = head.next;
		while(nextNode!=null) {
			if(nextNode.data == currentNode.data) {
				currentNode.next = nextNode.next;
				nextNode.next = null;
				nextNode = currentNode.next;
			}else {
				nextNode = nextNode.next;
				currentNode = currentNode.next;
			}
		}
	}
	// Used to create the loop in linked List
	public static void createLoop() {
		Node first = new Node(10);
		Node second = new Node(20);
		Node third = new Node(20);
		Node fourth = new Node(30);
		Node fifth = new Node(30);
		Node sixth = new Node(40);
		Node seven = new Node(40);
		Node eight = new Node(50);
		Node nine = new Node(60);

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seven;
		seven.next = eight;
		eight.next = nine;
	}
}
