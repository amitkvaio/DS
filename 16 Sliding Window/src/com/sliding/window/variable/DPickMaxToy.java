package com.sliding.window.variable;

import java.util.HashMap;

/*
John is at a toy store help him pick maximum number of toys. 
	He can only select in a continuous manner and he can select only two types of toys.

John has to follow the below condition.
1. line s uthao --> mtlb substring
2. max k types --> max k unique characters in the substring
*/
public class DPickMaxToy {
	public static void main(String[] args) {
		System.out.println(getMaxToys("abaccab", 2));//4
	}
	
	public static int getMaxToys(String str, int k) {
		int i = 0;
		int j = 0;
		int maxToys = -1;
		int n = str.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		while (j < n) {

			map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);

			// If the number of unique characters is less than k, expand window
			if (map.size() < k) {
				j++;
			}
			// If the number of unique characters is exactly k, check max
			else if (map.size() == k) {
				maxToys = Math.max(j - i + 1, maxToys);
				j++;
			}
			// If more than k unique characters, shrink window from left
			else if (map.size() > k) {
				while (map.size() > k) {
					char leftChar = str.charAt(i);
					map.put(leftChar, map.get(leftChar) - 1);
					if (map.get(leftChar) == 0) {
						map.remove(leftChar);
					}
					i++;
				}
			}
		}
		return maxToys;
	}
}

// Is similar to longest Substring with K Unique Characters)

//904. Fruit Into Baskets - LeetCode Same kind of problem, with trees and fruit