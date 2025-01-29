package com.leetcode.easy.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 9. Destination City | 2 Approaches | Leetcode-1436
public class IDestinationCity {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("London");
		list1.add("New York");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("New York");
		list2.add("Lima");
		
		List<String> list3 = new ArrayList<String>();
		list3.add("Lima");
		list3.add("Sao Paulo");
		
		List<List<String>> paths = new ArrayList<List<String>>();
		paths.add(list1);
		paths.add(list2);
		paths.add(list3);
		System.out.println(destCity(paths));
		
	}
	//Time Complexity: O(n), where n is the number of elements in the paths list.
	//Space Complexity: O(k), where k is the number of unique sources.
	
	public static String destCity(List<List<String>> paths) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (List<String> path : paths) {
			String source = path.get(0); // out degree
			map.put(source, map.getOrDefault(source, 0) + 1);
		}

		for (List<String> path : paths) {
			String dest = path.get(1);

			if (map.getOrDefault(dest, 0) == 0) {
				return dest;
			}
		}
		return "";
	}
}

/*
https://leetcode.com/problems/destination-city/

1436. Destination City

You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

 

Example 1:

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo" 
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".

Example 2:

Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are: 
"D" -> "B" -> "C" -> "A". 
"B" -> "C" -> "A". 
"C" -> "A". 
"A". 
Clearly the destination city is "A".

Example 3:

Input: paths = [["A","Z"]]
Output: "Z"

 

Constraints:

    1 <= paths.length <= 100
    paths[i].length == 2
    1 <= cityAi.length, cityBi.length <= 10
    cityAi != cityBi
    All strings consist of lowercase and uppercase English letters and the space character.





*/