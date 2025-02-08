package com.problem.soving01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*

Given an array of strings strs, group the anagrams together. 
	You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different 
	word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

*/
public class VGroupOfAnagram {
	public static void main(String[] args) {

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> resultList = groupAnagramsCategorizeBySorting(strs);
		System.out.println(resultList);
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
	/*
	 * Time Complexity: O(n*logâ�¡k) where k is the length of largest string) Space
	 * Complexity: O(n)
	 */
}