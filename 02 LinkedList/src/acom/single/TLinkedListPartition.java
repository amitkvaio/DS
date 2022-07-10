package acom.single;

import acom.single.imp.Node;
import acom.single.imp.SingleLinkedList;

/*
https://leetcode.com/problems/partition-list
Given the head of a linked list and a value x, partition it such that all nodes 
	less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Input: head = [2,1], x = 2
Output: [1,2]

*/
public class TLinkedListPartition {
	
	public static void main(String[] args) {
		int [] arr1 = {1,4,3,2,5,2};
		Node head1 = getLinkedList(arr1);
		int patVal = 3;
		Util.displayList(head1);
		Node out = linkedListPartioned(head1, patVal);
		Util.displayList(out);
		System.out.println("***************");
		int [] arr2 = {2,1};
		Node head2 = getLinkedList(arr2);
		Util.displayList(head2);
		Node out2 = linkedListPartioned(head2, 2);
		Util.displayList(out2);
		 
	}
	
	public static Node linkedListPartioned(Node head, int partVal) {
		Node LH =null;
		Node LT = null;
		Node RH = null;
		Node RT = null;
		Node temp = head;
		while (temp != null) {
			if (temp.data < partVal) {
				if (LH == null) {
					LH = temp;
					LT = temp;
				} else {
					LT.next = temp;
					LT = temp;
				}
			} else {
				if (RH == null) {
					RH = temp;
					RT = temp;
				} else {
					RT.next = temp;
					RT = temp;
				}
			}
			temp = temp.next;
		}
		
		//if not mentioned below  two lines of code then it will create cycle.
		LT.next = null;
		RT.next = null;
		
		//there is no right linked List and left is there then returning left head
		if(LH!=null && RH==null)
			return LH;
		//there is no left linked List and right is there then returning right head
		else if(LH==null && RH!=null) {
			return RH;
		}else {
			//Connecting left linked list to right linked list
			LT.next = RH;
		}
		return LH;
	}
	
	public static Node getLinkedList(int[]arr) {
		SingleLinkedList list = new SingleLinkedList();
		for (int i = 0; i <arr.length; i++) {
			list.addLast(arr[i]);
		}
		return list.head;
	}
}
