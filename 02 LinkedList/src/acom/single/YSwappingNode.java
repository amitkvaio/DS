package acom.single;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;

/*
You are give the head of a linked list, and an integer K.
Return the head of the linked list after swapping the values of the Kth node 
	from the beginning and the Kth node from the end.

10-->20-->30-->40-->50-->60-->70-->80-->90-->100-->Null
K=3
After swapping
10-->20-->80-->40-->50-->60-->70-->30-->90-->100-->Null
*/
public class YSwappingNode {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		for (int i = 1; i <= 10; i++) {
			list.addLast(i * 10);
		}
		Util.displayList(list.head);
		System.out.println("After swapping");
		Util.displayList(swapNodes(list.head, 3));
	}
	
	public static Node swapNodes(Node head, int k) {
		if(head==null ||head.next==null) {
			return head;
		}
		Node slow = head;
		Node fast = head;
		Node starting = head;
		
		//Got the kth node from beginning
		for(int i = 0 ; i <k; i++) {
			starting = fast;
			fast = fast.next;
		}
		
		//Here slow pointer will point to the kth node from the end 
		while(fast!=null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		int temp = starting.data;
		starting.data = slow.data;
		slow.data = temp;
		return head;
	}
}
/*
TC : O(n)
SC : O(1)


*/