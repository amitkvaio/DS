package acom.single;

public class NDeleteAllOccurenceOfGivenKey {
	static Node head = null;

	public static void main(String[] args) {
		createLoop();
		Util.displayList(head);
		int key =20;
		deleteAllOccurenceOfGivenKey(key);

		System.out.println("After Removal of all the occurence of key: "+key);
		Util.displayList(head);
		System.out.println("************Done************");
	}

	private static void deleteAllOccurenceOfGivenKey(int key) {
		Node temp = head;
		Node pre = null;
		
		//if the head containing the multiple required key value
		while (temp != null && temp.data== key) {
			head = temp.next;
			temp = head;
		}
		
		while (temp != null) {
			// if required key value is in between the linked list
			while (temp != null && temp.data != key) {
				pre = temp;
				temp = temp.next;
			}
	
			// if the required key is not in the linked list
			if (temp == null) {
				return;
			}
			// move pre next to next of temp
			pre.next = temp.next;
			
			//for the next iteration of temp
			temp = pre.next;
		}
	}

	// Used to create the loop in linked List
	public static void createLoop() {
		Node first = new Node(10);
		Node second = new Node(20);
		Node third = new Node(15);
		Node fourth = new Node(5);
		Node fifth = new Node(10);
		Node sixth = new Node(20);
		Node seven = new Node(25);
		Node eight = new Node(15);

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seven;
		seven.next = eight;
	}
}
/*
Delete all occurrences of a given key in a linked list
*/