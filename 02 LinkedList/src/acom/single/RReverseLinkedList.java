package acom.single;

import acom.single.imp.Node;

public class RReverseLinkedList {
	static Node head = null;
	public static void main(String[] args) {
		createLoop();
		displayList(head);
		Node previous = reverseLinkedList(head);
		displayList(previous);
	}
	
	public static void createLoop() {
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
	}
	
	//TC : O(n) SC : O(1)
	public static Node reverseLinkedList( Node head) {
		if(head==null)
			return null;
		Node temp = head;
		Node current = head;
		Node previous = null;
		while (temp != null) {
			current = temp.next;
			temp.next = previous;
			previous = temp;
			temp = current;
		}
		return previous;
	}
	
	public static void displayList(Node head) {
		int count = 0;
		if (head == null) {
			System.out.println("There is no nodes are present in the given linked list!!!");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
			count++;
			if (count > 37)
				break;
		}
		System.out.print("Null\n");
	}
	
}
