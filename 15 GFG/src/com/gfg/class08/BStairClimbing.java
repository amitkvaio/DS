package com.gfg.class08;

/*
https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
https://www.geeksforgeeks.org/sum-of-the-series-20-21-22-2n/

*/
public class BStairClimbing {
	public static void main(String[] args) {
		int totalways = ways_(5);
		System.out.println("Total number of ways::"+totalways);
		System.out.println("*******************************************");
	}
	
	static int ways(int stair) {
		// Base case
		if (stair == 0) {
			return 1;
		}
		// Sub-problem
		int res = 0;
		res = res + ways(stair - 1);
		if (stair - 2 >= 0) {
			res = res + ways(stair - 2);
		}
		return res;
	}

	static int ways_(int stair) {
		// Base case
		if (stair == 0) {
			return 1;
		}
		if (stair < 0) {
			return 0;
		}
		return ways_(stair - 1) + ways_(stair - 2);
	}
}

/*

There are n stairs, a person standing at the fifth stair wants to reach the stair zero.
The person can get down by either 1 stair or 2 stairs at a time. 
Count the number of ways, the person can reach the bottom 
(order does matter).
*/