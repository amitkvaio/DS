package com.dds;

public class QHashMap {

	private static int capacity = 16; // Default capacity
	private static final double LOAD_FACTOR_THRESHOLD = 0.75;
	private Node[] buckets;
	private int size;

	// Node class to store key-value pairs in a linked list (chaining)
	private static class Node {
		int key;
		int value;
		Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	public QHashMap() {
		this.buckets = new Node[capacity];
		this.size = 0;
	}

	// Calculate the index using a hash function
	private int getIndex(int key) {
		return Math.abs(key) % capacity;
	}

	// Insert or update a key-value pair
	public void put(int key, int value) {
		int index = getIndex(key);
		Node current = buckets[index];

		// Check if the key already exists, update value if found
		while (current != null) {
			if (current.key == key) {
				current.value = value;
				return;
			}
			current = current.next;
		}

		// Insert new key-value pair at the beginning of the linked list
		Node newNode = new Node(key, value);
		newNode.next = buckets[index];
		buckets[index] = newNode;
		size++;

		// Resize if the load factor exceeds threshold
		if ((double) size / capacity > LOAD_FACTOR_THRESHOLD) {
			resize();
		}
	}

	// Resize the hash table when the load factor exceeds the threshold
	private void resize() {
		int newCapacity = capacity * 2;
		Node[] newBuckets = new Node[newCapacity];

		// Rehash all elements
		for (int i = 0; i < capacity; i++) {
			Node current = buckets[i];
			while (current != null) {
				int newIndex = Math.abs(current.key) % newCapacity; // New index

				// Insert into new bucket array
				Node newNode = new Node(current.key, current.value);
				newNode.next = newBuckets[newIndex];
				newBuckets[newIndex] = newNode;

				current = current.next;
			}
		}

		buckets = newBuckets;
		capacity = newCapacity;
	}

	// Retrieve the value associated with a key
	public int get(int key) {
		int index = getIndex(key);
		Node current = buckets[index];

		while (current != null) {
			if (current.key == key) {
				return current.value;
			}
			current = current.next;
		}
		return -1; // Return -1 if key not found
	}

	// Remove a key-value pair
	public void remove(int key) {
		int index = getIndex(key);
		Node current = buckets[index];
		Node prev = null;

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

	// Check if a key exists
	public boolean containsKey(int key) {
		return get(key) != -1;
	}

	// Get the number of elements in the HashMap
	public int size() {
		return size;
	}
	
	// Display HashMap (for debugging)
    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Node current = buckets[i];
            while (current != null) {
                System.out.print("[" + current.key + " -> " + current.value + "] -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
    
    public static void main(String[] args) {
    	QHashMap map = new QHashMap();

        // Insert key-value pairs
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        map.put(4, 400);
        map.put(5, 500);
        map.put(15, 1500); // This will collide with index 15 % 16

        System.out.println("Size: " + map.size());
        map.display();

        // Retrieve values
        System.out.println("Get value for key 3: " + map.get(3)); // 300
        System.out.println("Get value for key 10: " + map.get(10)); // -1 (not found)

        // Check if key exists
        System.out.println("Contains key 2? " + map.containsKey(2)); // true
        System.out.println("Contains key 7? " + map.containsKey(7)); // false

        // Remove a key
        map.remove(3);
        System.out.println("Contains key 3 after removal? " + map.containsKey(3)); // false

        System.out.println("Size after removal: " + map.size());
        System.out.println("\n\n\n");
        map.display();
    }
}

/*

Time Complexity Analysis
Operation	Average Case	Worst Case
Put				O(1)		O(N) (all elements in one bucket)
Get				O(1)		O(N)
Remove			O(1)		O(N)
Resize			O(N)		O(N)
*/
