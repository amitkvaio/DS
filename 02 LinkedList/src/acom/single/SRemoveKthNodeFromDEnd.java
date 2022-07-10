package acom.single;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;
//
public class SRemoveKthNodeFromDEnd {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		for (int i = 1; i <= 10; i++) {
			list.addFirst(i * 10);
		}
		
		int nthNode = 6;
		
		Util.displayList(list.head);
		getNthNodeFromTheEnd(nthNode, list.size, list.head);
		System.out.println("******************************");
		removeNthFromEnd(list.head, nthNode);
		Util.displayList(list.head);
	}

	// Nth Node from the end
	public static void getNthNodeFromTheEnd(int n, int size, Node head) {
		// check if value of n is not more than length of the linked list
		if (size < n)
			return;

		int nThNode = size - n + 1;
		Node temp = head;
		for (int i = 1; i < nThNode; i++) {
			temp = temp.next;
		}
		System.out.println(n + "th Node from the end is :" + temp.data);
	}

	// vvi
	public static void removeNthFromEnd(Node head, int n) {
		Node firstPtr = head;
		Node secPtr = head;

		for (int i = 0; i < n; i++) {
			firstPtr = firstPtr.next;
		}
		Node previous = null;
		while (firstPtr != null) {
			firstPtr = firstPtr.next;
			previous = secPtr;
			secPtr = secPtr.next;
		}
		previous.next = secPtr.next;
		System.out.println(n + "th Node from the end is :" + secPtr.data);
	}
}

/*
Assumption:
We do not know size of linkedlist otherwise we can directly iterate and find (length-n)th node
Algorithm for this problem would be :

Use two pointer firstPtr and secondPtr and initialize both to head of linkedlist
Move firstPtr by n-1 nodes.
Increment firstPtr and secondPtr until firstPtr.next not equal to null.
SecondPtr will be at nth from end node.

 
*/ 
