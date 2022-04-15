package acom.single;

import acom.single.imp.Node;

public class JTotalNodeInCyclicLoop {
	static Node head = null;

	public static void main(String[] args) {
		createLoop();
		Util.displayList(head);
		getTotalNodeInCyclicLoop();
		System.out.println("************Done************");
	}

	// Used to create the loop in linked List
	public static void createLoop() {
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seven;
		seven.next = eight;
		eight.next = nine;
		nine.next = sixth;
	}

	public static void getTotalNodeInCyclicLoop() {
		// If list is empty or has only one node without loop
		if (head == null || head.next == null) {
			System.out.println("list is either empty or has only one node!!");
			return;
		}
		Node slowPtr = head;
		Node fastPtr = head;
		int totalNode = 1;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr) {
				while (slowPtr.next != fastPtr) {
					totalNode++;
					slowPtr = slowPtr.next;
				}
				System.out.println("Total numbers of Nodes in Cyclic Loos is ::" + totalNode);
				return;
			}
		}
	}
}
