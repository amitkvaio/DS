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

		findIntersectionPoint(head1, head2);
	}

	public static void findIntersectionPoint(Node n1, Node n2) {
		int sizeN1 = getLength(n1);
		int sizeN2 = getLength(n2);

		Node larger = null;
		Node smaller = null;
		int diff = 0;

		// Calculating the diff and finding the longest LL
		if (sizeN1 > sizeN2) {
			diff = sizeN1 - sizeN2;
			larger = n1;
			smaller = n2;
		} else {
			diff = sizeN2 - sizeN1;
			larger = n2;
			smaller = n1;
		}
		int count = 0;

		// Moving diff nodes in the larger linked List
		while (count < diff) {
			larger = larger.next;
			count++;
		}

		// Moving forward both the LL until both LL points to the same nodes
		while (larger != smaller) {
			larger = larger.next;
			smaller = smaller.next;
		}
		System.out.println("Intersection of Node Would be::" + larger.data);
		System.out.println("Intersection of Node Would be::" + smaller.data);
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
