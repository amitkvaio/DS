package acom.single;

import acom.single.imp.Node;

public class PintersectionOfTwoLL {
	public static void main(String[] args) {

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);

		Node head1 = n1;
		head1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;

		Node nd1 = new Node(25);
		Node nd2 = new Node(45);
		Node head2 = nd1;
		nd1.next = nd2;
		nd2.next = n5;

		Util.displayList(head1);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Util.displayList(head2);

		Node intNode = getIntersectionNode(head1, head2);
		System.out.println("Intersection of Node Would be::" + intNode.data);
	}

	// Function to find the intersection point of two linked lists
	public static Node getIntersectionNode(Node headA, Node headB) {
		if (headA == null || headB == null) {
			return null;
		}

		// Get the lengths of both lists
		int lengthA = getLength(headA);
		int lengthB = getLength(headB);

		// Align the starting points
		while (lengthA > lengthB) {
			headA = headA.next;
			lengthA--;
		}
		while (lengthB > lengthA) {
			headB = headB.next;
			lengthB--;
		}

		// Traverse both lists together to find the intersection
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA; // Intersection found
			}
			headA = headA.next;
			headB = headB.next;
		}

		return null; // No intersection
	}

	public static int getLength(Node head) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
}
