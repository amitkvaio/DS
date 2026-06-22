package com.leetcode;

public class MaxProfit {
	public static void main(String[] args) {
		System.out.println(getMaxProfit(new int [] {7,1,5,3,6,4}));
		System.out.println(getMaxProfit(new int [] {1,2,3,4,5}));
		System.out.println(getMaxProfit(new int [] {7,6,4,3,1}));
	}
	
	public static int getMaxProfit(int [] prices) {
		int maxProfit = 0;
		int buyAtMin = Integer.MAX_VALUE;
		
		for (int i = 0; i < prices.length; i++) {
			if(prices[i] < buyAtMin) {
				buyAtMin = prices[i];
			}else {
				maxProfit = maxProfit + (prices[i] - buyAtMin);
				buyAtMin = prices[i];
			}
			
		}
		return maxProfit;
	}
}
