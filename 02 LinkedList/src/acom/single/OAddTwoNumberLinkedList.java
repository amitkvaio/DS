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
		
		//Addition of two Linked List
		Node sum = addTwoNumbers(first, second);
		System.out.println("After Addition");
		Util.displayList(sum);
	}
	
	// Function to add two numbers represented by linked lists
	public static Node addTwoNumbers(Node first, Node second) {
		
		Node fst = reverseLinkedList(first);
		Node scd = reverseLinkedList(second);
		
		//Reversing the both the LinkedList
		System.out.println("After reverse printing the linked list");
		Util.displayList(fst);       
		Util.displayList(scd);
		
		 
		int carry = 0;
		Node newHead = null;
		Node temp = null;

		// Add corresponding digits from both lists
		while (fst != null || scd != null || carry != 0) {
			int sum = carry;
			if (fst != null) {
				sum = sum + fst.data;
				fst = fst.next;
			}
			if (scd != null) {
				sum = sum + scd.data;
				scd = scd.next;
			}

			carry = sum / 10; // Update carry
			Node newNode = new Node(sum % 10);
			
			if (newHead == null) {
				newHead = newNode;
				temp = newHead;
			} else {
				temp.next = newNode;
				temp = temp.next;
			}
		}
		// Reverse the result list to restore the proper order
		return reverseLinkedList(newHead);
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
