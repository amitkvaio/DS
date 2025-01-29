package acom.single;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;
//The "Swap Nodes in Pairs" problem (Leetcode 24) requires swapping every two adjacent nodes
/*
Input 
10-->20-->30-->40-->50-->60-->70-->80-->90-->100-->Null

Output
20-->10-->40-->30-->60-->50-->80-->70-->100-->90-->Null
*/
public class XSwapNodesInPairs {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		for (int i = 1; i <= 10; i++) {
			list.addLast(i * 10);
		}
		Util.displayList(list.head);
		
		//swapPairs(list.head);
		//Util.displayList(list.head);
		
		swapPairIterative(list.head);
		Util.displayList(list.head);
	}

	//O(n) Time and O(n) Space
	public static void swapPairs(Node head) {
		// Base case: if the list is empty or has 
        // only one node, no swap
		if(head == null ||head.next ==null) {
			return ;
		}
		
		// Swap the data of the current node with the next node
		int temp = head.data;
		head.data = head.next.data;
		head.next.data =temp;
		
		// Recursion for the next pair
		swapPairs(head.next.next);
	}
	
	//Using Iterative Method – O(n) Time and O(1) Space
	public static void swapPairIterative(Node head) {
		// Base case: if the list is empty or has 
        // only one node, no swap
		if(head == null ||head.next ==null) {
			return ;
		}
		
		Node cur = head;
		while(cur!=null && cur.next !=null) {
			int temp = cur.data;
			cur.data = cur.next.data;
			cur.next.data = temp;
			
			// Move to the next pair
            cur = cur.next.next;
		}
	}
}
