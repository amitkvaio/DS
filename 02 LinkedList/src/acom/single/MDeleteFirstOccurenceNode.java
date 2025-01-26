package acom.single;

import acom.single.imp.Node;

public class MDeleteFirstOccurenceNode {

	static Node head = null;

	public static void main(String[] args) {
		createLinkedList();
		Util.displayList(head);
		deleteFirstOccurenceNode(15);

		System.out.println("After removal of first occurence !!");
		Util.displayList(head);
		System.out.println("************Done************");
	}

	// Function to delete the first occurrence of the key
	public static void deleteFirstOccurenceNode(int key) {
		if (head == null)
			return; // If list is empty

		Node temp = head, prev = null;

		// Traverse the list to find the key
		while (temp != null) {
			if (temp.data == key) {
				if (prev == null) {
					// Key is at the head
					head = head.next;
				} else {
					// Key is in the middle or end
					prev.next = temp.next;
				}
				return; // Stop after removing the first occurrence
			}
			prev = temp;
			temp = temp.next;
		}
	}

	// Used to create the loop in linked List
	public static void createLinkedList() {
		Node first = new Node(8);
		Node second = new Node(10);
		Node third = new Node(15);
		Node fourth = new Node(5);
		Node fifth = new Node(15);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
	}

}
/*
Given a ‘key’, delete the first occurrence of this key in linked list.

10-->10-->15-->5-->15-->Null
After removal of first occurence !!
10-->15-->5-->15-->Null

*/
