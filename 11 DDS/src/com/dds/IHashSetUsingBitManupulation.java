package com.dds;

public class IHashSetUsingBitManupulation {
	private int[] bitset;
	private static final int SIZE = 1000001; // Max key value
	private static final int INT_SIZE = 32; // Number of bits in an int

	public IHashSetUsingBitManupulation() {
		bitset = new int[(SIZE / INT_SIZE) + 1]; // Divide into 32-bit chunks
	}

	public void add(int key) {
		int index = key / INT_SIZE;
		int bitPosition = key % INT_SIZE;
		bitset[index] |= (1 << bitPosition); // Set the bit
	}

	public void remove(int key) {
		int index = key / INT_SIZE;
		int bitPosition = key % INT_SIZE;
		bitset[index] &= ~(1 << bitPosition); // Clear the bit
	}

	public boolean contains(int key) {
		int index = key / INT_SIZE;
		int bitPosition = key % INT_SIZE;
		return (bitset[index] & (1 << bitPosition)) != 0; // Check the bit
	}
	
	public static void main(String[] args) {
		IHashSetUsingBitManupulation myHashSet  = new IHashSetUsingBitManupulation();
		myHashSet.add(1);      // set = [1]
		myHashSet.add(2);      // set = [1, 2]
		System.out.println(myHashSet.contains(1)); // return True
		System.out.println(myHashSet.contains(3)); // return False, (not found)
		myHashSet.add(2);      // set = [1, 2]
		System.out.println(myHashSet.contains(2)); // return True
		myHashSet.remove(2);   // set = [1]
		System.out.println(myHashSet.contains(2)); // return False, (already removed)
	}
}

/*

https://leetcode.com/problems/design-hashset/description/
Leetcode 705

Why This is Better?

✅ Memory Efficient: Uses ~125 KB instead of ~1MB.
✅ Fast Operations:

    O(1) for add, remove, and contains.
    Bitwise operations are extremely fast.
    ✅ No Extra Overhead: No need for dynamic resizing or complex data structures.

*/