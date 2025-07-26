package com.sliding.window.variable;

import java.util.HashMap;

/*
https://leetcode.com/problems/fruit-into-baskets/description/
904



*/
public class FFruitIntoBaskets {
	public static void main(String[] args) {
		System.out.println(totalFruit(new int[] {1,2,1}));//3
		System.out.println(totalFruit(new int[] {0,1,2,2}));//3
		System.out.println(totalFruit(new int[] {1,2,3,2,2}));//4
	}

	public static int totalFruit(int[] fruits) {
		int i = 0, j = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = -1;

		if (fruits.length == 0)
			return 0;

		if (fruits.length == 1)
			return 1;

		while (j < fruits.length) {
			map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

			if (map.size() <= 2) {
				max = Math.max(max, j - i + 1);
				j++;
			}

			else if (map.size() > 2) {
				while (map.size() > 2) {
					map.put(fruits[i], map.get(fruits[i]) - 1);
					if (map.get(fruits[i]) == 0) {
						map.remove(fruits[i]);
					}
					i++;
				}
				j++;
			}
		}
		return max;
	}

}
