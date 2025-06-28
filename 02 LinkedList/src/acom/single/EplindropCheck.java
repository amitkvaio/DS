package acom.single;

import java.util.ArrayList;

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
		System.out.println("###############Using ArrayList###############");
		System.out.println(isPalindrome(createList()));
		System.out.println("############### Using Reverse second half ###############");
		System.out.println(isPalindromeUsingReverseSecondHalf(createList()));
	}

	
	public static void  palindropCheck(Node head) {
		//Reverse the current linked list
		Node previous = reverseLinkedList(head);
		Util.displayList(previous);
		
		/*
		will do the check whether it is palindrome or not
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


	private static Node reverseLinkedList(Node head) {
		Node temp = head;
		Node current = head;
		Node previous = null;
		
		while (temp != null) {
			temp = temp.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		return previous;
	}
	
	
	public static Node createList() {
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
		return linkedList.head;
	}
	
	public static boolean isPalindrome(Node head) {
		if (head == null) {
			return true;
		}

		// Step 1: Copy the linked list into an array
		ArrayList<Integer> listArray = new ArrayList<>();
		Node temp = head;

		while (temp != null) {
			listArray.add(temp.data);
			temp = temp.next;
		}

		// Step 2: Check if the array is a palindrome
		int start = 0;
		int end = listArray.size() - 1;

		while (start < end) {
			if (!listArray.get(start).equals(listArray.get(end))) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static boolean isPalindromeUsingReverseSecondHalf(Node head) {
		if (head == null) {
			System.out.println("Linked List is empty!!");
			return false;
		}
		Node slow = head;
		Node first = head;
		while (first != null && first.next != null) {
			first = first.next.next;
			slow = slow.next;
		}
		System.out.println("Got the middle Elements::" + slow.data);

		if (first.next == null) {
			reverseLinkedList(slow);
		} else {
			reverseLinkedList(slow.next);
		}

		// Comparing
		first = head;
		while (slow != null) {
			if (first.data != slow.data) {
				return false;
			}
			slow = slow.next;
			first = first.next;
		}
		return true;
	}
}
