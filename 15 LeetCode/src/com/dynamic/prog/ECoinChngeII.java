package com.dynamic.prog;
//Coin Change II | Made Super Easy | Recursion | Memoization | AMAZON | Leetcode-518
public class ECoinChngeII {
	
	public static int len;

	public static void main(String[] args) {
		System.out.println(getNumberOfCombination(new int [] {1,2,5}, 5));//4
		System.out.println(getNumberOfCombination(new int [] {2}, 3));//0
		System.out.println(getNumberOfCombination(new int [] {10}, 10));//1
	}

	static int getNumberOfCombination(int[] coins, int amount) {
		len = coins.length;
		return solve(0, coins, amount);
	}

	public static int solve(int index, int[] coins, int amount) {
		if (amount == 0) {
			return 1;
		}
		if (index == len)
			return 0;
		if (coins[index] > amount) {
			return solve(index + 1, coins, amount);
		}

		int take = solve(index, coins, amount - coins[index]);
		int skip = solve(index + 1, coins, amount);

		return take + skip;
	}
}

/*

https://leetcode.com/problems/coin-change-ii/description/
518 Coin Change II

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.


Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:

Input: amount = 10, coins = [10]
Output: 1

 

Constraints:

    1 <= coins.length <= 300
    1 <= coins[i] <= 5000
    All the values of coins are unique.
    0 <= amount <= 5000


*/