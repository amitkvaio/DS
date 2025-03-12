package com.dds;

public class PHashSet {
	// Define the initial capacity and load factor threshold.
	private static int capacity = 16;
	private static final double LOAD_FACTOR_THRESHOLD = 0.7;
	private Node[] buckets;
	private int size;

	public PHashSet() {
		this.buckets = new Node[capacity];
		this.size = 0;
	}

	// Node class to store elements in the linked list
	private static class Node {
		int key;
		Node next;

		Node(int key) {
			this.key = key;
			this.next = null;
		}
	}

	// Calculate the index where the element will go
	private int getIndex(int key) {
		return Math.abs(key) % capacity; // Ensure positive index
	}

	// Add an element to the HashSet
	public boolean add(int value) {

		// Checking if the element is already present to avoid the duplicate
		if (contains(value))
			return false;

		// Resize if the load factor exceeds threshold.
		if ((double) size / buckets.length > LOAD_FACTOR_THRESHOLD) {
			resize();
		}
		
		// Adding the new element at the beginning of the linked list
		int index = getIndex(value);
		Node newNode = new Node(value);
		newNode.next = buckets[index];
		buckets[index] = newNode;
		size++;
		
		return true;
	}

	// Resize the array when load factor exceeds the threshold
	private void resize() {
		int newCapacity = capacity * 2;
		Node[] newBuckets = new Node[newCapacity]; // New bucket array

		// Rehash all existing keys into the new bucket array
		for (int i = 0; i < capacity; i++) {
			Node node = buckets[i];
			while (node != null) {
				int newIndex = Math.abs(node.key) % newCapacity; // New hash index

				// Insert at new index in new bucket array
				Node newNode = new Node(node.key);
				newNode.next = newBuckets[newIndex];
				newBuckets[newIndex] = newNode;

				node = node.next; // Move to next node in old bucket
			}
		}

		// Update reference to the new bucket array
		buckets = newBuckets;
		capacity = newCapacity;
	}

	public int getSize() {
		return size;
	}

	// Checking if the element already present in the set
	public boolean contains(int key) {
		int index = getIndex(key);
		Node current = buckets[index];
		while (current != null) {
			if (current.key == (key)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Remove a key
	public void remove(int key) {
		int index = getIndex(key);
		Node head = buckets[index];
		Node prev = null;
		Node current = head;

		while (current != null) {
			if (current.key == key) {
				if (prev == null) {
					buckets[index] = current.next; // Remove head node
				} else {
					prev.next = current.next; // Remove middle or last node
				}
				size--;
				return;
			}
			prev = current;
			current = current.next;
		}
	}

	// Display HashSet (for debugging)
	public void display() {
		for (int i = 0; i < capacity; i++) {
			System.out.print("Bucket " + i + ": ");
			Node current = buckets[i];
			while (current != null) {
				System.out.print(current.key + " -> ");
				current = current.next;
			}
			System.out.println("null");
		}
		System.out.println("\n\n\n*******************");
	}

	public static void main(String[] args) {
		PHashSet set = new PHashSet();
		set.add(5);
		set.add(15);
		set.add(25);
		set.add(35);
		set.add(10);
		set.add(105);
		set.add(70);
		set.add(80);
		set.add(90);
		set.add(100);
		set.add(110);
		set.display();
		System.out.println("##############");
		set.add(140);
		set.display();

		System.out.println("Set contains 15? " + set.contains(15)); // true
		System.out.println("Set contains 50? " + set.contains(50)); // false

		set.remove(15);
		set.display();
		System.out.println("Set contains 15 after removal? " + set.contains(15)); // false
		System.out.println("Size of set: " + set.getSize()); // 4

		set.display(); // Show internal state
	}
}
/*
Time Complexity Analysis
Operation	Average Case	Worst Case (before resize)
Add				O(1)		O(N) (if all keys hash to the same bucket)
Remove			O(1)		O(N)
Contains		O(1)		O(N)
Resize			O(N)		O(N)
*/
