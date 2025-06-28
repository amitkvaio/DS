package acom.single;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;

public class BDeleteMiddleNode {
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		BDeleteMiddleNode deleteMiddleNode = new BDeleteMiddleNode();

		for (int i = 10; i >= 1; i--) {
			singleLinkedList.addFirst(i);
		}

		Util.displayList(singleLinkedList.head);
		deleteMiddleNode.deleteMiddleNode(singleLinkedList.head);
		System.out.println("After Deletion of middle Elements:");
		Util.displayList(singleLinkedList.head);
	}

	// Delete the middle Node/Data in the linked List
	public Node deleteMiddleNode(Node head) {
		// Base cases
		if (head == null)
			return null;
		if (head.next == null) {
			return null;
		}
		Node slow = head;
		Node fast = head;
		Node prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("Mid Elements :" + slow.data + " and it is deleted!!");
		prev.next = slow.next;
		slow.next =null;
		return slow;
	}
}
