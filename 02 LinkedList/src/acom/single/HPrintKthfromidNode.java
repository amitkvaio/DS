package acom.single;

public class HPrintKthfromidNode {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		for (int i = 10; i >= 1; i--) {
			list.addFirst(i);
		}
		Util.displayList(list.head);
		printKthNodefroMiddleNode(2, list.size, list.head);
	}

	private static void printKthNodefroMiddleNode(int kthNode, int size, Node head) {
		System.out.println("Size::"+size);
		int middleNodePos = (size / 2) + 1;
		int requiredNode = middleNodePos - kthNode;
		if(requiredNode < 1) {
			System.out.println("Invalid " + requiredNode + "th Position from the middle!");
			return;
		}
		int count = 1;
		Node temp = head;
		while (count < requiredNode) {
			temp = temp.next;
			count++;
		}
		System.out.println("Kth Node from the mid ::"+temp.data);
	}
}

/*
Find kth node from Middle towards Head of a Linked List
Input :  List is 1->2->3->4->5->6->7
         K= 2 
Output : 2

Input :  list is 7->8->9->10->11->12
         K = 3
Output : 7

*/