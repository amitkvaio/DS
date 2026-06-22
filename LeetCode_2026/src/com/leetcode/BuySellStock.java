package com.leetcode;

public class BuySellStock {
	public static void main(String[] args) {
		int [] prices = {7,1,5,3,6,4};
		System.out.println(getMaxProfit(prices));
	}
	
	public static int getMaxProfit(int [] prices) {
		int buyAtMin = Integer.MAX_VALUE;
		int maxProfits = 0;
		
		for (int i = 0; i < prices.length; i++) {
			if(prices[i] < buyAtMin) {
				buyAtMin = prices[i];
			}else {
				int currProfit = prices[i] - buyAtMin;
				System.out.println("Current Profit ::" + currProfit);
				if(currProfit > maxProfits) {
					maxProfits = currProfit;
				}
			}
			
		}
		System.out.println("Buy At Price::"+ buyAtMin);
		System.out.println("Max profits ::"+maxProfits);
		
		return 0;
	}
	
}
