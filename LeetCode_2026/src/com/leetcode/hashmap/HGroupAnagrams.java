package com.leetcode.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HGroupAnagrams {
	public static void main(String[] args) {
		String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
		String[] str1 = { "" };
		String[] str3 = { "a" };
		System.out.println(groupAnagramsCategorizeBySorting(str));
		System.out.println(groupAnagramsCategorizeBySorting(str1));
		System.out.println(groupAnagramsCategorizeBySorting(str3));
	}

	public static List<List<String>> groupAnagramsCategorizeBySorting(String[] strs) {

		if (strs == null || strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();

		for (String s : strs) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String key = String.valueOf(arr);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());

			map.get(key).add(s);
		}

		List<List<String>> resultList = new ArrayList<>();
		Set<String> key = map.keySet();

		for (String strKey : key) {
			resultList.add(map.get(strKey));
		}
		return resultList;
	}
}
/*
49 Group Anagrams
Given an array of strings strs, group the

together. You can return the answer in any order.

 

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:

    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
*/
