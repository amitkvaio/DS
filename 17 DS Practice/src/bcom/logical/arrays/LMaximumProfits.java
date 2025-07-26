package bcom.logical.arrays;

public class LMaximumProfits {
	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println("Max Profit (Brute): " + maxProfit(prices));
		System.out.println("Max Profit (Brute): " + maxProfitOnePass(prices));
	}

	private static int maxProfit(int[] prices) {
		int maxProfit = 0;
		// Loop through all possible buying days.
		for (int i = 0; i < prices.length; i++) {

			// Loop through all possible selling days after the buying day.
			// Ensures that you sell only after buying, which is required.
			for (int j = i + 1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				if (maxProfit < profit) {
					maxProfit = profit;
				}
			}
		}
		return maxProfit;
	}

	public static int maxProfitOnePass(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int price : prices) {
			if (price < minPrice) {
				minPrice = price; // Buy at lower price
			} else {
				maxProfit = Math.max(maxProfit, price - minPrice); // Sell now
			}
		}

		return maxProfit;
	}
}
/*
Best time to buy and sell the stock.

(Leetcode #121)
    You are given an array prices[] where prices[i] is the price of a stock on day i.
    You can buy once and sell once, after buying.
    Return the maximum profit you can achieve. If no profit, return 0.

Input:  prices = [7, 1, 5, 3, 6, 4]
Output: 5
Explanation: Buy at 1, sell at 6 → profit = 6 - 1 = 5

*/