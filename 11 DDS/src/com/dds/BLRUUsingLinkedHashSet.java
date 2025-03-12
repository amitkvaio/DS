package com.dds;

import java.util.LinkedHashSet;

public class BLRUUsingLinkedHashSet {
	private final int capacity;
	private final LinkedHashSet<Integer> cache;

	public BLRUUsingLinkedHashSet(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashSet<>();
    }

	public int get(int key) {
		if (!cache.contains(key))
			return -1;

		// Move key to the end (most recently used)
		cache.remove(key);
		cache.add(key);
		return key;
	}

	public void put(int key) {
		if (cache.contains(key)) {
			cache.remove(key); // Remove and reinsert to move it to MRU position
		} else if (cache.size() == capacity) {
			// Remove the least recently used (first element)
			int lruKey = cache.iterator().next();
			cache.remove(lruKey);
		}
		cache.add(key);
	}

	public void display() {
		System.out.print("Cache: ");
		for (int key : cache) {
			System.out.print(key + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BLRUUsingLinkedHashSet cache = new BLRUUsingLinkedHashSet(3);

		cache.put(1);
		cache.put(2);
		cache.put(3);
		cache.display(); // Cache: 1 2 3

		System.out.println("Get 2: " + cache.get(2)); // Moves 2 to MRU
		cache.display(); // Cache: 1 3 2

		cache.put(4); // Evicts 1 (LRU)
		cache.display(); // Cache: 3 2 4

		System.out.println("Get 1: " + cache.get(1)); // -1 (not found)
		cache.display(); // Cache remains: 3 2 4

		System.out.println("Get 3: " + cache.get(3)); // Moves 3 to MRU
		cache.display(); // Cache: 2 4 3

		cache.put(5); // Evicts 2
		cache.display(); // Cache: 4 3 5
	}
}
/*
Time Complexity
Operation	Complexity	Explanation
get(key)	O(1)	Lookup & move to MRU in LinkedHashSet
put(key)	O(1)	Insert & remove in LinkedHashSet
removeLRU()	O(1)	Remove first element in LinkedHashSet
*/
