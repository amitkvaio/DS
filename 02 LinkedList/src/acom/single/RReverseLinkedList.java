package acom.single;

import java.util.Stack;

import acom.single.imp.Node;

public class RReverseLinkedList {
	static Node head = null;
	public static void main(String[] args) {
		createLoop();
		displayList(head);
		Node previous = reverseLinkedList(head);
		displayList(previous);
		System.out.println();
		System.out.println("##############Reverse linked list using Stack#####################");
		displayList(reverseLinkedListUsingStack(createLoop()));
	}
	
	public static Node createLoop() {
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
		return head;
	}
	
	//TC : O(n) SC : O(1)
	public static Node reverseLinkedList( Node head) {
		if(head==null)
			return null;
		Node temp = head;
		Node current = head;
		Node previous = null;
		while (temp != null) {
			temp = temp.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		return previous;
	}
	
	public static Node reverseLinkedListUsingStack(Node head) {
	    if (head == null)
	        return null;

	    Stack<Node> stack = new Stack<>();
	    Node temp = head;

	    // Push all nodes onto the stack
	    while (temp != null) {
	        stack.push(temp);
	        temp = temp.next;
	    }

	    // Pop from the stack to reverse the links
	    head = stack.pop();  // The new head of the reversed list
	    temp = head;
	    
	    // Update next pointers for each node
	    while (!stack.isEmpty()) {
	        Node node = stack.pop();
	        temp.next = node;
	        temp = temp.next;
	    }
	    
	    // Ensure the last node points to null
	    temp.next = null;

	    return head;
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
