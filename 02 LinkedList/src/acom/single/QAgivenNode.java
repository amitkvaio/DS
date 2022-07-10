package acom.single;
// Delete a given node.-- VVI

import acom.single.imp.Node;

public class QAgivenNode {
	static Node head = null;
	public static Node deleteNode= null;
	
	public static void main(String[] args) {
		createLinkedList();
		Util.displayList(head);
		
		System.out.println("After deletion");
		deleteSpecifiedNode(deleteNode);
		Util.displayList(head);
	}
	
	public static void createLinkedList() {
		
		
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		
		deleteNode = fourth;

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
	}
	
	public static void deleteSpecifiedNode(Node delNode) {
		System.out.println("Deleted node::"+delNode.data);
		delNode.data = delNode.next.data;
		delNode.next = delNode.next.next;
	}
	
	public static void swapNode(Node node1 , Node node2) {
		int data = node1.data;
		node1.data = node2.data;
		node2.data = data;
	}
}
