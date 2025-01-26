package acom.single;

import acom.single.imp.Node;

//https://algorithms.tutorialhorizon.com/insert-a-node-in-the-given-sorted-linked-list/
public class FInsertNodeInSortedList {
	static Node head = null;
	static int size =0;
	public static void main(String[] args) {
		createList();
		Util.displayList(head);
		insertNodeUtilA(new Node(45));
		Util.displayList(head);
	}
	
	public static void createList() {
		Node first = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		Node fourth = new Node(40);
		Node fifth = new Node(45);
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = null;
		size = 5;
	}
	
	public static void insertNodeUtil(Node newNode) {
		//Cond -1 in cash of head is null
		if (head == null) {
			head = newNode;
		//Cond -2 if value is less then first node value then add it at the first position	
		} else if (head.data >= newNode.data) {
			newNode.next = head;
			head = newNode;
		//Cond -3 if the value lies in between the node or at last	
		} else {
			Node temp = head;
			while (temp.next != null && temp.next.data < newNode.data) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}
	
	public static void insertNodeUtilA(Node newNode) {
		// If the head is null
		Node temp = head;
		if (head == null) {
			head = newNode;
		} else if (head.data >= newNode.data) {
			newNode.next = head;
			head = newNode;
		} else {
			while (temp.next != null && newNode.data > temp.next.data) {
					temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}
}
