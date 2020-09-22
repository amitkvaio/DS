package acom.single;

import java.util.Random;

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
          Node slow_prt = head;
          Node first_prt = head;
          while(first_prt!=null && first_prt.next!=null){
                first_prt=first_prt.next.next;
                slow_prt=slow_prt.next;
          }
          return slow_prt;
    }
}
