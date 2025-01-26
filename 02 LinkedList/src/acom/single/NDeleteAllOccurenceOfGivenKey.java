package acom.single;

import acom.single.imp.Node;

public class NDeleteAllOccurenceOfGivenKey {
	static Node head = null;

	public static void main(String[] args) {
		createLoop();
		Util.displayList(head);
		int key =10;
		deleteAllOccurrences(key);

		System.out.println("After Removal of all the occurence of key: "+key);
		Util.displayList(head);
		System.out.println("************Done************");
	}

	// Function to delete all occurrences of the given key
	public static void deleteAllOccurrences(int key) {
		// Remove all occurrences of key at the head
		while (head != null && head.data == key) {
			head = head.next;
			System.out.println("*******head*********");
		}

		// Traverse the rest of the list
		Node temp = head;
		while (temp != null && temp.next != null) {
			if (temp.next.data == key) {
				temp.next = temp.next.next; // Skip the node with the key
			} else {
				temp = temp.next; // Move to the next node
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

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seven;
		seven.next = eight;
	}
}
/*
Delete all occurrences of a given key in a linked list
*/