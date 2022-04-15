package acom.single;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;

public class CNthNodeFromEnd {
	
	public static void main(String[] args) {
		SingleLinkedList list = new  SingleLinkedList();
		for (int i = 1; i <=10; i++) {
			list.addFirst(i*10);
		}
		Util.displayList(list.head);
		nthNodeFromTheEnd(4, list.size,list.head);
		System.out.println(">>>>>>>>Without Knowing the size>>>>>>>>>>>>>>>>");
		nthFromLastNode(list.head,4);
	}
	
	// Nth Node from the end
	public static void nthNodeFromTheEnd(int n,int size,Node head) {
		// check if value of n is not more than length of the linked list
		if (size < n)
			return;

		int nThNode = size - n + 1;
		Node temp = head;
		for (int i = 1; i < nThNode; i++) {
			temp = temp.next;
		}
		System.out.println( n+ "th Node from the end is :" + temp.data);
	}
	
	//vvi
	public static Node nthFromLastNode(Node head, int n) {
		Node firstPtr = head;
		Node secPtr = head;

		for (int i = 0; i < n; i++) {
			firstPtr = firstPtr.next;
		}
		System.out.println(firstPtr.data);
		while (firstPtr != null) {
			firstPtr = firstPtr.next;
			secPtr = secPtr.next;
		}
		System.out.println( n+ "th Node from the end is :" + secPtr.data);
		return secPtr;
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
