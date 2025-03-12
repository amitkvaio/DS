package com.dds;

import java.util.Arrays;

public class OHashTable {

	private static class Entry {
		String key;
		String value;
		Entry next;

		public Entry(String key, String value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Entry [key=" + key + ", value=" + value + ", next=" + next + "]";
		}
	}

	private Entry[] table;
	private int capacity;

	public OHashTable(int capacity) {
		this.capacity = capacity;
		this.table = new Entry[capacity];
	}

	// Hash function to map a key to an index
	private int hash(String key) {
		return key.hashCode() % capacity;
	}

	// Insert key-value pair into the hash table
	public void put(String key, String value) {
		Entry newEntry = new Entry(key, value);
		int index = hash(key);

		if (table[index] == null) {
			table[index] = newEntry;
		} else {
			Entry current = table[index]; // Think about the single linked list traversal.
			while (current != null) {

				// if the current Entry is not null and key is same with different value, then
				// update the value.
				if (current.key.equals(key)) {
					current.value = value;
					return;
				}
				current = current.next;
			}
			// other key fall in the same index with different value / adding Entry on other
			// index of the table.
			newEntry.next = table[index];
			table[index] = newEntry;
		}
	}

	public String get(String key) {
		int index = hash(key);
		Entry current = table[index];
		while (current != null) {
			// if the current Entry is not null and index is same, return the value of
			// respective key provided.
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		return null; // if the key is not found
	}

	// Remove key value pair from the hash table.
	public void remove(String key) {
		int index = hash(key);
		Entry current = table[index];
		Entry pre = null;
		while (current != null) {
			if (current.key.equals(key)) {
				if (pre == null) {
					// Removing first entry
					table[index] = current.next;
				} else {
					pre.next = current.next;// Removing the non-first entyr.
				}
				return;
			}
			pre = current;
			current = current.next;
		}
	}

	@Override
	public String toString() {
		return "OHashTable [table=" + Arrays.toString(table) + "]";
	}

	// check if the key exists in the hash tbale
	public boolean contains(String key) {
		return get(key) != null;
	}

	public static void main(String[] args) {
		OHashTable table  = new OHashTable(10);
		table.put("name", "Amit");
		table.put("age", "35");
		table.put("city", "Ranchi");
		System.out.println("Name ::" + table.get("name"));
		System.out.println("Age ::" + table.get("age"));
		System.out.println("City ::" + table.get("city"));
		table.remove("age");
		System.out.println("After removal of Age ::" + table.get("age"));
	}
}
