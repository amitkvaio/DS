package com.dynamic.prog;

import java.util.Arrays;

//Recursion + Memoization
public class ECoinChngeII2 {
	
	static int[][] memo;
	public static int len;
	
	public static void main(String[] args) {
		System.out.println(getNumberOfCombination(new int [] {1,2,5}, 5));//4
		System.out.println(getNumberOfCombination(new int [] {2}, 3));//0
		System.out.println(getNumberOfCombination(new int [] {10}, 10));//1
	}
	
	public static int getNumberOfCombination(int[] coins , int amount) {
		len = coins.length;
        memo = new int[len][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return numberOfWays(coins, 0, amount);
    }
	
	 public static int numberOfWays(int[] coins, int index, int amount) {
		 if (amount == 0) {
	            return 1;
	        }
	        
	        if (index == len || amount < 0) {
	            return 0;
	        }
	        
	        if (memo[index][amount] != -1) {
	            return memo[index][amount];
	        }
	        
	        //This will remove unnecessary call
	        if(coins[index] > amount) {
	            return memo[index][amount] = numberOfWays(coins, index + 1, amount);
	        }

	        int take = numberOfWays(coins, index, amount - coins[index]);
	        int skip = numberOfWays(coins, index + 1, amount);
	        
	        return memo[index][amount] = take+skip;
	 }
}
