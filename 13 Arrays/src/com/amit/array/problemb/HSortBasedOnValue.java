package com.amit.array.problemb;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/*
Input
[ 70, 40, 30, 10, 70, 30, 70, 70, 30, 10, 70]; 

Output
70 - 5
30 - 3
10 - 2
40 - 1
*/

public class HSortBasedOnValue {
	public static void main(String[] args) {
		int[] arr = { 70, 40, 30, 10, 70, 30, 70, 70, 30, 10, 70, 30 };
		System.out.println("----222-----------");
		sortBasedOnValue2(arr);
		System.out.println("-----333----------");
		sortBasedOnValue3(arr);
	}

	private static void sortBasedOnValue2(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		map.entrySet().stream().sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
				.forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
	}

	private static void sortBasedOnValue3(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		LinkedHashMap<Integer, Integer> collect = map.entrySet().stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(collect);
	}
}
