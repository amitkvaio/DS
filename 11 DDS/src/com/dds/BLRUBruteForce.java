package com.dds;

import java.util.ArrayList;
import java.util.List;

public class BLRUBruteForce {
	
	int capacity ;
	List<int[]> cache;
	
	public BLRUBruteForce(int capacity) {
		this.capacity = capacity;
		this.cache = new ArrayList<int[]>(capacity);
	}

	public int get(int key) {
		// Key is already present, than remove the key and add at the last position
		for (int i = 0; i < cache.size(); i++) {
			if (cache.get(i)[0] == key) {
				int[] temp = cache.remove(i);
				cache.add(temp);
				return temp[1];
			}
		}
		return -1;
	}
	
	
	public void put(int key, int value) {

		// if the capacity is full
		if (cache.size() == capacity) {
			cache.remove(0);
		}

		// Key is already present, than remove the key and add at the last position
		for (int i = 0; i < cache.size(); i++) {
			if (cache.get(i)[0] == key) {
				cache.remove(i);
			}
		}
		cache.add(new int[] { key, value });
	}


	public static void main(String[] args) {
		BLRUBruteForce lru = new BLRUBruteForce(2);
		lru.put(1, 1);
		lru.put(2, 2);
		System.out.println(lru.get(1)); // Output: 1
		lru.put(3, 3); // Removes key 2 (Least Recently Used)
		System.out.println(lru.get(2)); // Output: -1
		lru.put(4, 4); // Removes key 1
		System.out.println(lru.get(1)); // Output: -1
		System.out.println(lru.get(3)); // Output: 3
		System.out.println(lru.get(4)); // Output: 4
	}
}
/*
https://leetcode.com/problems/lru-cache/description/

Time Complexity (Brute Force)
get(key) → O(N) (Linear search and reordering)
put(key, value) → O(N) (Linear search and reordering)
*/