package com.dds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BLRUUsingDDL {
	private final int capacity;
	private final Map<Integer, Integer> cache; // Stores key-value pairs
	private final LinkedList<Integer> order; // Stores access order

	public BLRUUsingDDL(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<>();
		this.order = new LinkedList<>();
	}

	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;

		// Move key to the end (most recently used)
		order.remove((Integer) key);
		order.addLast(key);
		return cache.get(key);
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			// If key exists, update value & move it to the end
			cache.put(key, value);
			order.remove((Integer) key);
			order.addLast(key);
		} else {
			if (cache.size() == capacity) {
				// Remove the least recently used (first element)
				int lruKey = order.removeFirst();
				cache.remove(lruKey);
			}
			// Insert the new key-value pair
			cache.put(key, value);
			order.addLast(key);
		}
	}

	public void display() {
		System.out.print("Cache: ");
		for (int key : order) {
			System.out.print("[" + key + " -> " + cache.get(key) + "] ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BLRUUsingDDL cache = new BLRUUsingDDL(3);

		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);
		cache.display(); // Cache: [1 -> 10] [2 -> 20] [3 -> 30]

		System.out.println("Get 2: " + cache.get(2)); // Moves 2 to MRU
		cache.display(); // Cache: [1 -> 10] [3 -> 30] [2 -> 20]

		cache.put(4, 40); // Evicts 1 (LRU)
		cache.display(); // Cache: [3 -> 30] [2 -> 20] [4 -> 40]

		System.out.println("Get 1: " + cache.get(1)); // -1 (not found)
		cache.display(); // Cache remains: [3 -> 30] [2 -> 20] [4 -> 40]

		System.out.println("Get 3: " + cache.get(3)); // Moves 3 to MRU
		cache.display(); // Cache: [2 -> 20] [4 -> 40] [3 -> 30]

		cache.put(5, 50); // Evicts 2
		cache.display(); // Cache: [4 -> 40] [3 -> 30] [5 -> 50]
	}
}
/*
Time Complexity
Operation		Complexity	Explanation
get(key)			O(1)	HashMap lookup + O(1) LinkedList move
put(key, value)		O(1)	HashMap insert/update + O(1) LinkedList move
removeLRU()			O(1)	Remove first node from LinkedList
*/
