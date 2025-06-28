package com.dds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ARandomizedSet {
	private Map<Integer, Integer> map;
	private List<Integer> set;
	private Random random;

	public ARandomizedSet() {
		map = new HashMap<Integer, Integer>();
		set = new ArrayList<Integer>();
		random = new Random();
	}

	public boolean insert(int val) {
		if (map.containsKey(val))
			return false;

		set.add(val);
		map.put(val, set.size() - 1);
		return true;
	}

	public boolean remove_(int val) {
		if (!map.containsKey(val))
			return false;

		int lastIndex = set.size() - 1;
		int indexVal = map.get(val); // This may be beginning, middle or last elements in the list.
		int lastElement = set.get(lastIndex);

		// Bringing last element value at indexVal
		set.set(indexVal, lastElement);

		// Replacing lastIndexValue with IndexVal Not required.
		set.set(lastIndex, val);

		map.put(lastElement, indexVal);
		set.remove(set.size() - 1);
		map.remove(val);

		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);//// This may be beginning, middle or last elements in the list.
		int lastElement = set.get(set.size() - 1);

		// Swap the last element with the one to be removed
		set.set(index, lastElement);
		map.put(lastElement, index);

		// Value of indexVal does not required to placed at the last.
		set.set(set.size() - 1, val);

		// Remove last element
		set.remove(set.size() - 1);
		map.remove(val);
		return true;
	}

	public int getRandom() {
		return set.get(random.nextInt(set.size()));
	}

	public static void main(String[] args) {
		ARandomizedSet ran = new ARandomizedSet();
		System.out.println(ran.insert(1));
		System.out.println(ran.remove(2));
		System.out.println(ran.insert(2));
		System.out.println(ran.insert(1));
		System.out.println(ran.getRandom());
		System.out.println(ran.remove(1));
		System.out.println(ran.insert(1));
		System.out.println(ran.insert(2));
		System.out.println(ran.getRandom());
	}
}



/*
https://leetcode.com/problems/insert-delete-getrandom-o1/description/
Leetcode 380

Time Complexity Analysis:
Insert: O(1) — HashMap allows inserting in constant time.
Remove: O(1) — Swapping and deleting the last element ensures constant time complexity.
GetRandom: O(1) — rand.nextInt(list.size()) allows picking a random index in constant time.

*/