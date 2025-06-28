package acom.single;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;

public class GMergeTwoSortedLinkList {
	Node firstLinkedList = null;
	Node secondLinkedList = null;
	//Node head = null;
	
	public static void main(String[] args) {
		GMergeTwoSortedLinkList list = new GMergeTwoSortedLinkList();
		Node first = list.firstSortedLinkedList();
		System.out.println("************First Linked List*****************");
		Util.displayList(first);
		
		System.out.println("**********Second Linked List*************");
		Node second = list.secondSortedLinkedList();
		Util.displayList(second);
		
		System.out.println("***********Merging start for two sorted linked list *****************");
		list.mergeTwoSortedLinkList(first, second);
		
		System.out.println("#################### Merge using recursion ############################");
		Util.displayList(mergeTwoSortedLinkListUsingRecursion(first, second));
	}
	
	public void mergeTwoSortedLinkList(Node first, Node second) {
		SingleLinkedList list = new SingleLinkedList();
		while (first != null && second != null) {
			// System.out.println(first.data + " " + second.data);
			if (first.data <= second.data) {
				list.addLast(first.data);
				first = first.next;
			} else {
				list.addLast(second.data);
				second = second.next;
			}
		}
		// Adding the remaining element of first linked list
		while (first != null) {
			list.addLast(first.data);
			first = first.next;
		}
		// Adding the remaining element of the second linked list
		while (second != null) {
			list.addLast(second.data);
			second = second.next;
		}
		Util.displayList(list.head);
	}
	
	public Node firstSortedLinkedList() {
		Node first = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		Node fourth = new Node(40);
		Node fifth = new Node(50);
		firstLinkedList = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = null;
		return firstLinkedList;
	}
	
	public Node secondSortedLinkedList() {
		Node first = new Node(5);
		Node second = new Node(15);
		Node third = new Node(25);
		Node fourth = new Node(35);
		Node fifth = new Node(45);
		
		secondLinkedList = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = null;
		return secondLinkedList;
	}
	
	public static Node mergeTwoSortedLinkListUsingRecursion(Node first, Node second) {
		Node head = null;
		if(first ==null) return second;
		if(second==null) return first;
		
		if(first.data < second.data) {
			head = first;
			first = first.next;
		}else {
			head = second;
			second = second.next;
		}
		head.next = mergeTwoSortedLinkListUsingRecursion(first, second);
		return head;
	}
	//TC : O(n+m)
	//SC : O(n+m) Recursive stack space
}
