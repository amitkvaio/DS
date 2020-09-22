package acom.single;

public class BDeleteMiddleNode {
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		BDeleteMiddleNode deleteMiddleNode = new BDeleteMiddleNode();

		for (int i = 10; i >= 1; i--) {
			singleLinkedList.addFirst(i);
		}

		Util.displayList(singleLinkedList.head);
		deleteMiddleNode.deleteMiddleNode(singleLinkedList.head);
		System.out.println("After Deletion of middle Elements:");
		Util.displayList(singleLinkedList.head);
	}

	// Delete the middle Node/Data in the linked List
	public Node deleteMiddleNode(Node head) {
		// Base cases
		if (head == null)
			return null;
		if (head.next == null) {
			return null;
		}
		Node slow_prt = head;
		Node first_prt = head;
		Node prev = null;
		while (first_prt != null && first_prt.next != null) {
			first_prt = first_prt.next.next;
			prev = slow_prt;
			slow_prt = slow_prt.next;
		}
		System.out.println("Mid Elements :" + slow_prt.data + " and it is deleted!!");
		prev.next = slow_prt.next;
		return slow_prt;
	}
}
