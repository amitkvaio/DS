package acom.single;

import acom.single.imp.Node;

/*
Add two numbers represented by Linked List in java
Algorithm:
**********
Create two linkedlist which will represent above two numbers.
Reverse both linked list.
Add two node values (Each node is being represented as single digit)  starting from heads of two linkedlist.
If sum is of above two node values is more than 10, then forward the carry.
Follow basic mathematical rules for addition.

*/
public class OAddTwoNumberLinkedList {
	public static void main(String[] args) {
		Node first = createList_1();
		Node second = createList_2();
		System.out.println("Displaying Given Two Linked List");
		Util.displayList(first);
		Util.displayList(second);
		
		
		//Reversing the both the LinkedList
		System.out.println("After reverse printing the linked list");
		Node frst = reverseLinkedList(first);
		Node scnd = reverseLinkedList(second);
		Util.displayList(frst);       
		Util.displayList(scnd);
		
		//Addition of two Linked List
		addTwoNumberInLinkedList(frst, scnd);
	}
	
	public static void addTwoNumberInLinkedList(Node first, Node second) {
		// Addition start
		int sum = 0;
		int carry = 0;
		int firstIter = 0;
		Node newHead = null;
		Node tmp =null;
		while (first != null || second != null) {

			firstIter++;
			sum = carry;

			if (first != null) {
				sum = sum + first.data;
				first = first.next;
			}

			if (second != null) {
				sum = sum + second.data;
				second = second.next;
			}

			carry = sum / 10;
			sum = sum % 10;

			// Check if it first node for the result
			if (firstIter == 1) {
				Node newNode = new Node(sum);
				newHead = newNode;
				//tmp will used for iterating and adding the new Node
				tmp = newHead;
			} else {
				Node newNode = new Node(sum);
				tmp.next = newNode;
				tmp = tmp.next;
			}
		}
		System.out.println(">>>>>>Addition in reverse order >>>>>>>>>");
		Util.displayList(newHead);
		//Again Reverse the Linked List
		Node addition = reverseLinkedList(newHead);
		System.out.println("Sum of two linked list are :");
		Util.displayList(addition);
	}
	
	public static Node createList_1() {
		Node first = new Node(5);
		Node second = new Node(6);
		Node third = new Node(7);
		Node fourth = new Node(1);
		Node fifth = new Node(2);

		Node head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = null;
		return head;
	}
	
	public static Node createList_2() {
		Node first = new Node(6);
		Node second = new Node(3);
		Node third = new Node(5);
		Node fourth = new Node(9);

		Node head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = null;
		return head;
	}
	
	public static Node reverseLinkedList(Node head) {
		Node current = head;
		Node tmp = null;
		Node previous = null;
		while(current!=null) {
			tmp = current;
			current = current.next;
			tmp.next=previous;
			previous=tmp;
		}
		return previous;
	}
	
}
