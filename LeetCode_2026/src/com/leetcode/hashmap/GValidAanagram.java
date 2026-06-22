package com.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GValidAanagram {
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		List<ArrayList<String>> listArrList = new ArrayList<ArrayList<String>>();
	}

	public static boolean isAnagram(String s, String t) {

		if (s.length() != t.length()) 
			return false;
		 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (char ch : t.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0)
					map.remove(ch);
			}else {
				return false;
			}
		}
		return map.size() == 0;
	}
}
