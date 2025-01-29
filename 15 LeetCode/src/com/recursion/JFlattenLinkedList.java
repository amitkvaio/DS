package com.recursion;

/*
watch this videos first : https://www.youtube.com/watch?v=RreHsOfi14w
*/
class Node {
	int data;
	Node next;
	Node bottom;

	Node(int data) {
		this.data = data;
		this.next = null;
		this.bottom = null;
	}
}

public class JFlattenLinkedList {
	public static void main(String[] args) {
		Node head = new Node(5);
		head.bottom = new Node(7);
		head.bottom.bottom = new Node(8);
		head.bottom.bottom.bottom = new Node(30);

		head.next = new Node(10);
		head.next.bottom = new Node(20);

		head.next.next = new Node(19);
		head.next.next.bottom = new Node(22);
		head.next.next.bottom.bottom = new Node(50);

		head.next.next.next = new Node(28);
		head.next.next.next.bottom = new Node(35);
		head.next.next.next.bottom.bottom = new Node(40);
		head.next.next.next.bottom.bottom.bottom = new Node(45);

		Node flattenedList = flatten(head);
		printList(flattenedList);
	}
	
	public static Node mergeTwoLists(Node head1, Node head2) {
		if (head1 == null)
			return head2;

		if (head2 == null)
			return head1;

		Node result;
		if (head1.data < head2.data) {
			result = head1;
			result.bottom = mergeTwoLists(head1.bottom, head2);
		} else {
			result = head2;
			result.bottom = mergeTwoLists(head1, head2.bottom);
		}

		return result;
	}

	//T.C : O(N*N*M) - See my detailed video above to understand this.
	//S.C : Auziliary Space = O(1) and O(N*M) – because of the recursion . N*M is the total number of elements in the flattened linked List
	public static Node flatten(Node root) {
		if (root == null)
			return root;

		Node temp = flatten(root.next);
		return mergeTwoLists(root, temp);
	}
	
	// Function to print the flattened linked list
	public static void printList(Node root) {
		Node current = root;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.bottom;
		}
		System.out.println("null");
	}
}
/*


Example Execution:

For the given input:

    5 -> 7 -> 8 -> 30
    ^
    |
    10 -> 20
    ^
    |
    19 -> 22 -> 50
    ^
    |
    28 -> 35 -> 40 -> 45

The output will be: 5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 30 -> 35 -> 40 -> 45 -> 50 -> null.


*/