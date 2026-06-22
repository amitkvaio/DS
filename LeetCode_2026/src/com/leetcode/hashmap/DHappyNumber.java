package com.leetcode.hashmap;

import java.util.HashSet;
import java.util.Set;

//202. Happy Number
// https://chunhthanhde.gitbook.io/leetcode-top-interview/topic-5-hashmap/045-happy-number
public class DHappyNumber {
	public static void main(String[] args) {
		System.out.println(checkHappyNumber(2));
		System.out.println(checkHappyNumber(3));
		System.out.println(checkHappyNumber(19));
	}

	public static boolean checkHappyNumber(int num) {
		if (num <= 0) {
			return false;
		}

		int sum = 0;
		Set<Integer> set = new HashSet<Integer>();
		set.add(num);

		while (num > 0) {
			int digit = num % 10;
			num = num / 10;

			sum = sum + (digit * digit);

			if (num <= 0) {
				//System.out.println("Sum::>" + sum);

				if (sum == 1)
					return true;

				if (set.contains(sum))
					return false;
				else
					set.add(sum);
				num = sum;
				sum = 0;
			}
		}
		return false;
	}
}

/*
Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.

Return true if n is a happy number, and false if not.

TC : O(log n)
SC : O(1)
*/