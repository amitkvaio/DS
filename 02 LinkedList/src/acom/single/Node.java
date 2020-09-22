package acom.single;

public class Node {
	public int data;
	public Node next;
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
