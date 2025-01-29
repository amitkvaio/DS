package acom.single;

import acom.single.imp.Node;

public class UFlattenLinkedList {
	public static void main(String[] args) {
		Node head = createLinkedList();
		// Flatten the list
        Node flattenedHead = flatten(head);
		 // Print the flattened list
        printFlattenedList(flattenedHead);
	}

	// Function to flatten the linked list
	public static Node flatten(Node head) {
		if (head == null)
			return null;

		Node current = head;

		while (current != null) {
			// If current node has a child, flatten it
			if (current.child != null) {
				// Find the last node of the child list
				Node temp = current.child;
				while (temp.next != null) {
					temp = temp.next;
				}

				// Connect the child list to the current node's next
				temp.next = current.next;
				current.next = current.child;
				current.child = null; // Set child to null after flattening
			}

			// Move to the next node
			current = current.next;
		}

		return head;
	}

	// Helper function to print the flattened list
	public static void printFlattenedList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public static Node createLinkedList() {
		// Creating a simple multi-level linked list:
		// 1 -> 2 -> 3
			// |
			// 4 -> 5

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node6;
		node6.next = node7;
		
		node2.child = node4;
		node4.next = node5;
		return node1;
	}
}

/*
1 -> 2 -> 3
       |
       4 -> 5
       
1 -> 2 -> 3 is the main linked list.
2 has a child node pointing to 4, and 4 has a next node 5.

Goal:

We want to flatten this list into a single-level list like this.
1 -> 2 -> 4 -> 5 -> 3
*/