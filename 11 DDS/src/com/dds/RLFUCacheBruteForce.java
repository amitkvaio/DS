package com.dds;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class RLFUCacheBruteForce {
	private final int capacity;
	private final Map<Integer, Integer> cache; // key -> value
	private final Map<Integer, Integer> frequency; // key -> frequency
	private final LinkedHashSet<Integer> order; // Maintains order of insertion

	public RLFUCacheBruteForce(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequency = new HashMap<>();
        this.order = new LinkedHashSet<>();
    }

	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;

		// Increase frequency
		frequency.put(key, frequency.get(key) + 1);

		// Move key to the end (recently used)
		order.remove(key);
		order.add(key);

		return cache.get(key);
	}

	public void put(int key, int value) {
		if (capacity == 0)
			return; // Edge case: no capacity

		if (cache.containsKey(key)) {
			cache.put(key, value); // Update value
			frequency.put(key, frequency.get(key) + 1); // Increase frequency
			order.remove(key);
			order.add(key);
		} else {
			if (cache.size() == capacity) {
				removeLFU(); // Remove LFU key
			}
			cache.put(key, value);
			frequency.put(key, 1);
			order.add(key);
		}
	}

	private void removeLFU() {
		int minFreq = Collections.min(frequency.values());
		int lfuKey = -1;

		// Find the least frequently used key (oldest in case of tie)
		for (int key : order) {
			if (frequency.get(key) == minFreq) {
				lfuKey = key;
				break;
			}
		}

		// Remove LFU key
		cache.remove(lfuKey);
		frequency.remove(lfuKey);
		order.remove(lfuKey);
	}

	public void display() {
		System.out.print("Cache: ");
		for (int key : order) {
			System.out.print("[" + key + " -> " + cache.get(key) + " (freq: " + frequency.get(key) + ")] ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		RLFUCacheBruteForce cache = new RLFUCacheBruteForce(3);

		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);
		cache.display(); // [1 -> 10] [2 -> 20] [3 -> 30]

		System.out.println(cache.get(1)); // 1 used once
		System.out.println(cache.get(2)); // 2 used once
		System.out.println(cache.get(2)); // 2 used twice
		cache.display(); // [1 -> 10 (1)] [3 -> 30 (1)] [2 -> 20 (2)]

		cache.put(4, 40); // Evicts 1 (LFU)
		cache.display(); // [3 -> 30 (1)] [2 -> 20 (2)] [4 -> 40 (1)]

		System.out.println(cache.get(3)); // 3 used once
		System.out.println(cache.get(4)); // 4 used once
		cache.put(5, 50); // Evicts 2 (LFU)
		cache.display(); // [3 -> 30 (2)] [4 -> 40 (2)] [5 -> 50 (1)]
	}
}
/*
Time Complexity Analysis
Operation		Complexity	Explanation
get(key)		O(n)	Finding min frequency takes O(n) in worst case
put(key, value)	O(n)	Finding and removing LFU key takes O(n)
removeLFU()		O(n)	Iterates through all keys to find the LFU
*/