package acom.single;

import java.util.HashSet;

import acom.single.imp.Node;

public class LRemoveDuplicateNodeFromUnSortedLL {
	static Node head = null;

	public static void main(String[] args) {
		createLoop();
		Util.displayList(head);
		removeDuplicateNodeFromUnSortedLL();

		System.out.println("After Removal of duplicate node");
		Util.displayList(head);
		System.out.println("************Done************");
	}

	private static void removeDuplicateNodeFromUnSortedLL() {
		HashSet<Integer> set = new HashSet<>();
		Node currentNode = head;
		Node nextNode = head.next;
		set.add(currentNode.data);
		while (nextNode != null) {
			if(set.contains(nextNode.data)) {
				currentNode.next = nextNode.next;
				nextNode.next=null;
				nextNode = currentNode.next;
			}else {
				set.add(nextNode.data);
				currentNode = currentNode.next;
				nextNode = nextNode.next;
			}
		}
	}

	// Used to create the loop in linked List
	public static void createLoop() {
		Node first = new Node(10);
		Node second = new Node(20);
		Node third = new Node(15);
		Node fourth = new Node(5);
		Node fifth = new Node(10);
		Node sixth = new Node(20);
		Node seven = new Node(25);
		Node eight = new Node(15);
		Node nine = new Node(30);

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
