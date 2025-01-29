package com.leetcode.easy.a;

import java.util.HashSet;
import java.util.Set;

//14. Path Crossing | Leetcode 1496
public class NisPathCrossing {
	public static void main(String[] args) {
		System.out.println(isPathCrossing("NES"));
		System.out.println(isPathCrossing("NESWW"));
	}
	
	//Approach (simply simulate and check visited)
	//T.C : O(n)
	//S.C : O(n)
	public static boolean isPathCrossing(String path) {
		Set<String> set = new HashSet<>();
		int x = 0;
		int y = 0;
		String key = x + "_" + y;
		set.add(key);

		for (char ch : path.toCharArray()) {
			if (ch == 'E') {
				x += 1;
			} else if (ch == 'W') {
				x -= 1;
			} else if (ch == 'N') {
				y += 1;
			} else {
				y -= 1;
			}
			key = x + "_" + y;
			if (set.contains(key)) {
				return true;
			}
			set.add(key);
		}
		return false;
	}
}
/*

Path Crossing | LeetCode 1496

https://leetcode.com/problems/path-crossing/description/


Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.


Input: path = "NES"
Output: false 
Explanation: Notice that the path doesn't cross any point more than once.

Example 2:


Input: path = "NESWW"
Output: true
Explanation: Notice that the path visits the origin twice.

 

Constraints:

    1 <= path.length <= 104
    path[i] is either 'N', 'S', 'E', or 'W'.








*/