package acom.single.imp;

public interface NodeInterface {
	public abstract boolean isEmpty();
	public abstract int getSize();
	public abstract void addFirst(int val);
	public abstract void addLast(int val);
	public abstract void addGivenPosition(int val,int position);
	public abstract void deleteFirst();
	public abstract void deleteLast();
	public abstract void deleteAtGivenPosition(int position);
	public abstract void displayList();
	public abstract void createList();
	public abstract boolean contains(int key);
	public abstract void reverseLinkedList();
	public abstract int getPositionOfNodeForAGivenValue(int data);
}
