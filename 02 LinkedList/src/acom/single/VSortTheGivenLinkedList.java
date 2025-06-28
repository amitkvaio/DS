package acom.single;

import acom.single.imp.Node;

public class VSortTheGivenLinkedList {

	// Merge Sort Function
	public static Node mergeSort(Node head) {
		// Base case: if the list is empty or contains only one element
		if (head == null || head.next == null) {
			return head;
		}

		// Step 1: Divide the list into two halves
		Node middle = getMiddle(head); // Get the middle node of the list
		Node nextOfMiddle = middle.next;

		middle.next = null; // Split the list into two halves

		// Step 2: Recursively sort both halves
		Node left = mergeSort(head);
		Node right = mergeSort(nextOfMiddle);

		// Step 3: Merge the sorted halves
		return merge(left, right);
	}

	// Function to find the middle of the linked list
	private static Node getMiddle(Node head) {
		if (head == null) {
			return head;
		}

		Node slow = head;
		Node fast = head;

		// Move 'fast' by two steps and 'slow' by one step
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	// Function to merge two sorted linked lists
	private static Node merge(Node left, Node right) {
		if (left == null)
			return right;
		if (right == null)
			return left;

		// If left's data is smaller, it becomes the head
		if (left.data <= right.data) {
			left.next = merge(left.next, right);
			return left;
		} else {
			right.next = merge(left, right.next);
			return right;
		}
	}

	// Main method to test the sort
	public static void main(String[] args) {
		// Creating a linked list: 3 -> 1 -> 4 -> 2 -> 5
		Node node1 = new Node(3);
		Node node2 = new Node(1);
		Node node3 = new Node(4);
		Node node4 = new Node(2);
		Node node5 = new Node(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		// Print original list
		System.out.println("Original List:");
		Util.displayList(node1);

		// Sort the list using mergeSort
		Node sortedHead = mergeSort(node1);

		// Print sorted list
		System.out.println("Sorted List:");
		Util.displayList(sortedHead);
	}
}
