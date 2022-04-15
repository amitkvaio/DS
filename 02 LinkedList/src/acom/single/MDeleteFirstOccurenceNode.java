package acom.single;

import acom.single.imp.Node;

public class MDeleteFirstOccurenceNode {

	static Node head = null;

	public static void main(String[] args) {
		createLoop();
		Util.displayList(head);
		deleteFirstOccurenceNode(15);

		System.out.println("After removal of first occurence !!");
		Util.displayList(head);
		System.out.println("************Done************");
	}

	private static void deleteFirstOccurenceNode(int key) {
		Node temp = head;
		Node pre = null;
		//if the head containing the required key value
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		
		//if required key value is in between the linked list
		while(temp != null && temp.data !=key) {
			pre = temp ;
			temp = temp.next;
		}
		
		// if the required key is not in the linked list
		if (temp == null) {
			return;
		}
		//move pre next to next of temp
		pre.next = temp.next;
	}

	// Used to create the loop in linked List
	public static void createLoop() {
		Node first = new Node(10);
		Node second = new Node(10);
		Node third = new Node(15);
		Node fourth = new Node(5);
		Node fifth = new Node(15);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
	}

}
/*
Given a ‘key’, delete the first occurrence of this key in linked list.

10-->10-->15-->5-->15-->Null
After removal of first occurence !!
10-->15-->5-->15-->Null

*/
