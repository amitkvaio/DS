package com.amit.array;
/*
Count number of occurrences (or frequency) of each element in a sorted array
 Input:
int[] arr = {2, 2, 2, 3, 3, 4, 5, 5, 6, 6};

Output:
Frequency of 2 is : 3
Frequency of 3 is : 2
Frequency of 4 is : 1
Frequency of 5 is : 2
Frequency of 6 is : 2 
*/

import java.util.LinkedHashMap;
import java.util.Map;

public class Arrays20 {
	public static void main(String[] args) {

		int[] arr = { 2, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
		Map<Integer, Integer> freqMap = solveIterative(arr);
		for (int val : freqMap.keySet()) {
			System.out.println("Frequency of " + val + " is : " + freqMap.get(val));
		}

	}

	public static Map<Integer, Integer> solveIterative(int[] arr) {
		LinkedHashMap<Integer, Integer> freqMap = new LinkedHashMap<>();
		for (int val : arr) {
			if (freqMap.containsKey(val)) {
				freqMap.put(val, freqMap.get(val) + 1);
			} else {
				freqMap.put(val, 1);
			}
		}
		return freqMap;
	}
}
