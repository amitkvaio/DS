package com.dds;

import java.util.HashMap;
import java.util.Map;

public class RLFUCacheUsingDDL {
	private final int capacity;
	private int minFreq;
	private final Map<Integer, Node> cache; // Key -> Node
	private final Map<Integer, DoublyLinkedList> freqMap; // Freq -> DLL

	private static class Node {
		int key, value, freq;
		Node prev, next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.freq = 1; // New nodes start with frequency 1
		}
	}

	private static class DoublyLinkedList {
		Node head, tail;
		int size;

		DoublyLinkedList() {
			head = new Node(0, 0); // Dummy head
			tail = new Node(0, 0); // Dummy tail
			head.next = tail;
			tail.prev = head;
			size = 0;
		}

		void addNode(Node node) {
			node.next = head.next;
			node.prev = head;
			head.next.prev = node;
			head.next = node;
			size++;
		}

		void removeNode(Node node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			size--;
		}

		Node removeLastNode() {
			if (size > 0) {
				Node last = tail.prev;
				removeNode(last);
				return last;
			}
			return null;
		}
	}

	public RLFUCacheUsingDDL(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;

		Node node = cache.get(key);
		updateFrequency(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (capacity == 0)
			return;

		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			node.value = value; // Update value
			updateFrequency(node);
		} else {
			if (cache.size() == capacity) {
				evictLFU();
			}
			Node newNode = new Node(key, value);
			cache.put(key, newNode);
			freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
			minFreq = 1;
		}
	}

	private void updateFrequency(Node node) {
		int freq = node.freq;
		freqMap.get(freq).removeNode(node);

		if (freqMap.get(freq).size == 0) {
			freqMap.remove(freq);
			if (minFreq == freq)
				minFreq++;
		}

		node.freq++;
		freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addNode(node);
	}

	private void evictLFU() {
		if (!freqMap.containsKey(minFreq))
			return;

		Node lfuNode = freqMap.get(minFreq).removeLastNode();
		if (lfuNode != null) {
			cache.remove(lfuNode.key);
			if (freqMap.get(minFreq).size == 0) {
				freqMap.remove(minFreq);
			}
		}
	}

	public void display() {
		System.out.println("Cache state:");
		for (int freq : freqMap.keySet()) {
			System.out.print("Freq " + freq + ": ");
			Node node = freqMap.get(freq).head.next;
			while (node != freqMap.get(freq).tail) {
				System.out.print("[" + node.key + " -> " + node.value + "] ");
				node = node.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		RLFUCacheUsingDDL cache = new RLFUCacheUsingDDL(3);

		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);
		cache.display(); // 1, 2, 3 all with freq 1

		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(2));
		cache.display(); // 1->10 (freq 2), 2->20 (freq 3), 3->30 (freq 1)

		cache.put(4, 40); // Evicts 3 (LFU)
		cache.display(); // 1, 2, 4 remain

		System.out.println(cache.get(3)); // -1 (already evicted)
	}
}

/*
Time Complexity Analysis
Operation		Complexity	Explanation
get(key)		O(1)	Direct access via HashMap, frequency update in DoublyLinkedList
put(key, value)	O(1)	Insert & update HashMap & DoublyLinkedList
evictLFU()		O(1)	Remove least frequent key in DoublyLinkedList
*/