package acom.single;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;

public class ZSinglyToCircularList {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		for (int i = 1; i <= 10; i++) {
			list.addLast(i * 10);
		}
		Util.displayList(list.head);
		System.out.println("##################");
		Util.displayList(convertToCircular(list.head));
	}

	// Method to convert singly linked list to circular linked list
	public static Node convertToCircular(Node head) {
		if (head == null) {
			return null; // If the list is empty, return null
		}

		Node current = head;

		// Traverse the list to find the last node
		while (current.next != null) {
			current = current.next;
		}

		// Now, current is the last node, make it circular
		current.next = head;

		return head; // Return the circular linked list's head
	}
}
