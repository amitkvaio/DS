package com.dds;

import java.util.ArrayList;

public class BLRUUsingArrayList {
	private int capacity;
	private ArrayList<Integer> cache;

	public BLRUUsingArrayList(int capacity) {
		this.capacity = capacity;
		this.cache = new ArrayList<Integer>(capacity);
	}

	public void put(int key) {
		if (cache.contains(key)) {
			cache.remove((Integer) key);
		} else if (cache.size() == capacity) {
			cache.remove(0);// Remove the least recently used item
		}
		cache.add(key); // Adding the item to the end (most recent used.)
	}

	public int get(int key) {
		if (cache.contains(key)) {
			cache.remove((Integer) key);
			cache.add(key);
			return key;
		}
		return -1;
	}

	public void display() {
		for (int i : cache) {
			System.out.print (i + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BLRUUsingArrayList lru = new BLRUUsingArrayList(3); // Capacity = 3
	
		// Insert elements
		lru.put(1);
		lru.put(2);
		lru.put(3);
		lru.display(); // Cache: 1 2 3
	
		// Access element 2 (makes it most recently used)
		System.out.println("Get 2: " + lru.get(2)); // 2
		lru.display(); // Cache: 1 3 2
	
		// Insert new element (causes eviction of least recently used: 1)
		lru.put(4);
		lru.display(); // Cache: 3 2 4
	
		// Try to access an element not in cache
		System.out.println("Get 1: " + lru.get(1)); // -1 (not found)
		lru.display(); // Cache remains: 3 2 4
	
		// Access element 3 (moves it to most recently used)
		System.out.println("Get 3: " + lru.get(3)); // 3
		lru.display(); // Cache: 2 4 3
	
		// Insert another element (evicts least recently used: 2)
		lru.put(5);
		lru.display(); // Cache: 4 3 5
	}
}

/*
Operation	Complexity	Explanation
put(key)	O(N)	contains(key) is O(N), and removing an element takes O(N) (shifting elements). Adding at the end is O(1).
get(key)	O(N)	contains(key) takes O(N), and removing takes O(N) due to shifting. Adding at the end is O(1).
display()	O(N)	Printing all elements takes O(N).

*/