package acom.single;

import java.util.HashSet;

import acom.single.imp.Node;

/*
https://leetcode.com/problems/linked-list-cycle/
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list 
	that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

*/
public class HCycleDetectionIn {
	static Node head=null;
	public static void main(String[] args) {
		Node head = createLoop();
		System.out.println(hasCycle(head));
		System.out.println("############## Using Hash set ##############3");
		System.out.println(hasCycleUsingHashSet(head));
	}

	// Used to create the loop in linked List
	public static Node createLoop() {
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seven;
		seven.next = eight;
		eight.next = nine;
		
		nine.next = fourth;
		return head;
	}

	//Floy's cycle finding algorithm
	public static boolean hasCycle(Node head) {
		// If list is empty or has only one node without loop
		if (head == null || head.next == null) {
			System.out.println("list is either empty or has only one node!!");
			return false;
		}
		Node slowPtr = head;
		Node fastPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasCycleUsingHashSet(Node head) {
		HashSet<Node> set = new HashSet<Node>();
		Node temp = head;
		while(temp!=null) {
			if(set.contains(temp)) {
				return true;
			}else {
				set.add(temp);
				temp = temp.next;
			}
		}
		return false;
	}
}
