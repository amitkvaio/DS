package acom.single.imp;

public class Node {
	public int data;
	public Node next;
	public Node child;
	public boolean isVisited;
	public Node() {
		data = 0;
		next = null;
		isVisited = false;
	}
	
	public Node(int val) {
		data = val;
		next = null;
		isVisited = false;
	}
}
