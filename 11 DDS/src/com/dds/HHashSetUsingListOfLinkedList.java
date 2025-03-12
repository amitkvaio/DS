package com.dds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HHashSetUsingListOfLinkedList {
	
	private int numBuckets ;
	private List<LinkedList<Integer>> buckets ;
	
	public HHashSetUsingListOfLinkedList() {
		buckets = new ArrayList<>(numBuckets);
		// Initialize each bucket with a new LinkedList
		numBuckets = 15000;
		for(int i = 0 ; i < numBuckets; i++) {
			buckets.add(new LinkedList<Integer>());
		}
	}
	
	private int gethashValueIndex(int key) {
		return key % numBuckets;
	}
	
	public void add(int key) {
		int index =gethashValueIndex(key);
		LinkedList<Integer> bucket = buckets.get(index);
		if(!bucket.contains(key)) {
			bucket.add(key);
		}
	}
	
	public void remove(int key) {
		int index =gethashValueIndex(key);
		LinkedList<Integer> bucket = buckets.get(index);
		bucket.remove((Integer)key);
	}
	
	public boolean contains(int key) {
        int index = gethashValueIndex(key);
        LinkedList<Integer> bucket = buckets.get(index);

        return bucket.contains(key);
    }
	
	
	public static void main(String[] args) {
		HHashSetUsingListOfLinkedList myHashSet  = new HHashSetUsingListOfLinkedList();
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

Time Complexity:
    Best Case (O(1)): If there are no collisions.
    Worst Case (O(N / B)): If collisions happen (N = elements, B = buckets), but still efficient in practice.
Memory Usage Comparison:

Approach									Space Complexity
Array (1000001 booleans)					O(10^6) ≈ 1MB
Bit Manipulation (int[])					O(10^5) ≈ 125KB
Chaining with LinkedList (15000 buckets)	O(N + B), but less memory than direct arrays
*/