//Least Recently Used (LRU) Cache – Using LinkedHashSet and Deque | Set 2
package com.problem.soving01;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class BLRU {
	private final int capacity; // Maximum size of cache
	private final LinkedHashSet<Integer> cache; // Store keys for fast lookup
	private final Deque<Integer> order; // Maintain order of usage

	public BLRU(int capacity) {
		this.capacity = capacity;
        this.cache = new LinkedHashSet<>(capacity);
        this.order = new LinkedList<>();
	}

	// Get method - Access an item, move it to the front (MRU position)
	public void get(int key) {
		if (cache.contains(key)) {
			order.remove(key); // Remove from current position
			order.addFirst(key); // Move to front (MRU)
			System.out.println("Accessed: " + key);
		} else {
			System.out.println("Key " + key + " not found in cache");
		}
	}

	// Put method - Insert a new key, remove LRU if needed
	public void put(int key) {
		if (cache.contains(key)) {
			// Remove from both cache and queue to update order
			order.remove(key);
		} else {
			if (cache.size() >= capacity) {
				int lru = order.removeLast(); // Remove Least Recently Used item
				cache.remove(lru);
				System.out.println("Removed LRU key: " + lru);
			}
			cache.add(key);
		}
		order.addFirst(key); // Add to front as most recently used
		System.out.println("Inserted key: " + key);
		System.out.println(cache);
		System.out.println(order);
	}

	// Print current cache state
	public void printCache() {
		System.out.println("Cache state (MRU -> LRU): " + order);
	}


	public static void main(String[] args) {
		BLRU lru = new BLRU(3);
        lru.put(1);
        lru.put(2);
        lru.put(3);
        lru.printCache(); // Expected: [3, 2, 1]

        lru.get(1); // Access key 1 → moves to front
        lru.put(4); // Inserts 4 → Removes LRU (key 2)
        lru.printCache(); // Expected: [4, 1, 3]

        lru.put(5); // Inserts 5 → Removes LRU (key 3)
        lru.printCache(); // Expected: [5, 4, 1]
	}
}
/*
 * What is LRU Cache?
 * 
 * An LRU (Least Recently Used) Cache is a data structure that stores a fixed
 * number of elements and removes the least recently used item when the cache
 * reaches its limit.
 * 
 * Two primary operations:
 * 
 * Get (Access Data): If the key is present, move it to the most recently used
 * position. Put (Insert Data): If the key is new and the cache is full, remove
 * the least recently used element before inserting the new key.
 * 
 * Implementation Using LinkedHashSet and Deque
 * =============================================
 * 
 * We can implement an LRU Cache using:
 * 
 * LinkedHashSet → For fast O(1) lookup (check if a key exists in the cache).
 * Deque (LinkedList as Doubly Queue) → To maintain the order of usage (most
 * recently used elements are at the front, least recently used at the back).
 */