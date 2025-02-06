package com.problem.soving01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VOracleGroupOfAnagram {
	public static void main(String[] args) {

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> resultList = groupAnagramsCategorizeBySorting(strs);
		System.out.println(resultList);
	}

	public static List<List<String>> groupAnagramsCategorizeBySorting(String[] strs) {

		if (strs == null || strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> strAnaMap = new HashMap<>();

		for (String s : strs) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String key = String.valueOf(arr);
			if (!strAnaMap.containsKey(key))
				strAnaMap.put(key, new ArrayList<>());

			strAnaMap.get(key).add(s);
		}

		List<List<String>> resultList = new ArrayList<>();
		Set<String> key = strAnaMap.keySet();

		for (String strKey : key) {
			resultList.add(strAnaMap.get(strKey));
		}
		return resultList;
	}
	/*
	 * Time Complexity: O(n*logâ�¡k) where k is the length of largest string) Space
	 * Complexity: O(n)
	 */
}