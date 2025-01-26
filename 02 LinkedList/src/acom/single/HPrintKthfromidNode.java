package acom.single;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;

public class HPrintKthfromidNode {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		for (int i = 5; i >= 1; i--) {
			list.addFirst(i);
		}
		Util.displayList(list.head);
		Node node = printKthNodefroMiddleNode(list.head, 1);
		System.out.println("Required Node ::" + node.data);
	}

	// Function to find the kth node from the middle towards the head
	public static Node printKthNodefroMiddleNode(Node head, int k) {
		if (head == null)
			return null;

		Node slow = head, fast = head;
		int position = 0;

		// Step 1: Find the middle using slow and fast pointers
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			position++;
		}

		// Step 2: Calculate the target position
		int targetPosition = position - k;
		System.out.println(
				"Middle Node ::" + slow.data + " Position::" + position + " Target Position ::" + targetPosition);
		if (targetPosition < 0) {
			// If target position is out of bounds, return null
			return null;
		}

		// Step 3: Traverse the list to the target position
		Node current = head;
		for (int i = 1; i <= targetPosition; i++) {
			current = current.next;
		}

		return current; // This is the kth node from the middle towards the head
	}
}

/*
Find kth node from Middle towards Head of a Linked List
Input :  List is 1->2->3->4->5->6->7
         K= 2 
Output : 2

Input :  list is 7->8->9->10->11->12
         K = 3
Output : 7

*/