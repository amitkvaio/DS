package acom.single;

import java.util.Random;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;

public class BGetMiddleNode {
	
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new  SingleLinkedList();
		BGetMiddleNode bMiddleNode = new BGetMiddleNode();
		Random random = new Random();
		for (int i = 1; i <=10; i++) {
			singleLinkedList.addFirst(random.nextInt(100));
		}
		
		Util.displayList(singleLinkedList.head);
		Node middle= bMiddleNode.getMiddleNode1(singleLinkedList.head);
		System.out.println("Middle Element : "+middle.data);
	}
	 
	//Get the middle Node/data in the linked list if the size has not provided
    public Node getMiddleNode1(Node head) {
          if(head==null){
                System.out.println("Linked List is empty!!");
                return head;
          }
          Node slow = head;
          Node fast = head;
          while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
          }
          return slow;
    }
}
