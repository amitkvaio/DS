package acom.single;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;
//Using linkedList Reverse
public class EplindropCheck {

	static SingleLinkedList linkedList = new SingleLinkedList();

	public static void main(String[] args) {
		createList();
		linkedList.displayList();
		System.out.println("Reverse order");
		palindropCheck(linkedList.head);
	}

	
	public static void  palindropCheck(Node head) {
		//Reverse the current linked list
		Node current = head;
		Node previous = null;
		Node tmp = null;
		while(current!=null) {
			tmp = current;
			current = current.next;
			tmp.next=previous;
			previous=tmp;
		}
		Util.displayList(previous);
		
		/*will do the check whether it is palindrome or not
		will compare the head node of main and reversed linked list if each elements are equal then it 
		will be palindrome  else not
		*/
		Node main = head;
		boolean palindromStatus = false;
		while(main!=null && previous!=null) {
			if(main.data==previous.data) {
				palindromStatus=true;
			}else{
				break;
			}
			main = main.next;
			previous=previous.next;
		}
		
		if(palindromStatus) {
			System.out.println("Above linked List are palindrom!");
		}else {
			System.out.println("Above linked List are not palindrom!!");
		}
	}
	
	
	public static void createList() {
		Node first = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		Node fourth = new Node(20);
		Node fifth = new Node(110);

		linkedList.head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = null;
		linkedList.size = 5;
	}

}
