package acom.single;

import java.util.HashSet;

import acom.single.imp.Node;

public class PintersectionOfTwoLL {
	public static void main(String[] args) {

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);

		Node head1 = n1;
		head1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;

		Node nd1 = new Node(25);
		Node nd2 = new Node(45);
		Node head2 = nd1;
		nd1.next = nd2;
		nd2.next = n5;

		Util.displayList(head1);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Util.displayList(head2);

		Node intNode = getIntersectionNode(head1, head2);
		System.out.println("Intersection of Node Would be::" + intNode.data);
		
		System.out.println("######################## Using Hash set ###########################");	
		System.out.println(getIntersectionNodeUsingHashSet(head1, head2));
	
	}

	// Function to find the intersection point of two linked lists
	public static Node getIntersectionNode(Node headA, Node headB) {
		if (headA == null || headB == null) {
			return null;
		}

		// Get the lengths of both lists
		int lengthA = getLength(headA);
		int lengthB = getLength(headB);

		// Align the starting points
		while (lengthA > lengthB) {
			headA = headA.next;
			lengthA--;
		}
		while (lengthB > lengthA) {
			headB = headB.next;
			lengthB--;
		}

		// Traverse both lists together to find the intersection
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA; // Intersection found
			}
			headA = headA.next;
			headB = headB.next;
		}

		return null; // No intersection
	}

	public static int getLength(Node head) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
	
	public static int getIntersectionNodeUsingHashSet(Node headA, Node headB) {
		if (headA == null || headB == null) {
			return -1;
		}

		// Create a HashSet to store all the nodes from list A
		HashSet<Node> set = new HashSet<>();
		Node temp = headA;

		// Traverse list A and store all nodes in the HashSet
		while (temp != null) {
			set.add(temp);
			temp = temp.next;
		}

		// Traverse list B, check for intersection with nodes in the HashSet
		temp = headB;
		while (temp != null) {
			if (set.contains(temp)) {
				return temp.data; // Intersection node found
			}
			temp = temp.next; // Move to the next node in list B
		}

		return -1; // No intersection found
	}
	
	public static int getIntersectionNodeUsingTwoPointers(Node headA, Node headB) {
		if (headA == null || headB == null) {
			return -1;
		}

		Node pointerA = headA;
		Node pointerB = headB;

		// Traverse both lists until they meet or both pointers reach the end
		while (pointerA != pointerB) {
			// Move to the next node, or to the head of the other list if end is reached
			pointerA = (pointerA == null) ? headB : pointerA.next;
			pointerB = (pointerB == null) ? headA : pointerB.next;
		}

		// If they meet, pointerA or pointerB will be the intersection node, otherwise
		// it will be null
		return (pointerA != null) ? pointerA.data : -1;
	}

}
/*
Explanation:
    Two Pointers Initialization:
        pointerA starts at headA and pointerB starts at headB.
    
    Pointer Traversal:
        Traverse both linked lists at the same time. If pointerA reaches the end of list A, it is redirected to the head of list B.
        Similarly, if pointerB reaches the end of list B, it is redirected to the head of list A.

    Why This Works:
        By the time both pointers switch lists, they have effectively traversed the same number of nodes. If the lists intersect, the pointers will meet at the intersection node. If the lists don't intersect, both pointers will eventually reach null at the same time.

    Exit Condition:
        The loop stops when both pointers meet, meaning they found the intersection node, or when both pointers reach null, meaning there is no intersection.

Time Complexity:
    O(n + m), where n is the length of list A and m is the length of list B.
        Each pointer visits every node of both lists, but they will visit each list only once due to the switching mechanism.

Space Complexity:
    O(1), as no extra space is used other than the two pointers


*/
