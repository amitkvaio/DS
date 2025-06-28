package acom.single;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;

public class WSeperateTheOddEvenNode {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		for (int i = 1; i <= 10; i++) {
			list.addLast(i);
		}
		Util.displayList(list.head);
		oddEvenList(list.head);
	}
	
	public static Node oddEvenList(Node head) {
		 if (head == null || head.next == null) {
	            return head; // No rearrangement needed
	     }
		
		Node odd = head ; // starting node taking as odd
		Node even = head.next; // Next of head is taking as even odd
		
		Node oddHead = odd;
		Node evenHead = even;
		
		  // Rearrange the list
        while (even != null && even.next != null) {
        	odd.next = even.next;       // Link odd nodes
            odd = odd.next;             // Move odd pointer
            even.next = odd.next;       // Link even nodes
            even = even.next;           // Move even pointer
        }
        
        // Connect the end of the odd list to the head of the even list
        odd.next = evenHead;
        
        Util.displayList(oddHead);
		return null;
	}
}


/*


The algorithm runs in O(n) time since we traverse the list once.
It uses O(1) additional space as no new nodes are created; pointers are rearranged.
It preserves the original relative order of odd and even-indexed nodes.

Input
1-->2-->3-->4-->5-->6-->7-->8-->9-->10-->Null
Output
1-->3-->5-->7-->9-->2-->4-->6-->8-->10-->Null

*/