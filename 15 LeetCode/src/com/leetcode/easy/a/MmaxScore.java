package com.leetcode.easy.a;

//13. Maximum Score After Splitting a String | 3 Approaches | Leetcode 1422
public class MmaxScore {
	public static void main(String[] args) {
		System.out.println(maxScore1("011101"));
		System.out.println(maxScore1("00111"));
		System.out.println(maxScore1("1111"));
		
		System.out.println("**************************");
		System.out.println(maxScoreUsing2PassSolution("011101"));
		System.out.println(maxScoreUsing2PassSolution("00111"));
		System.out.println(maxScoreUsing2PassSolution("1111"));
		
		System.out.println("**************************");
		System.out.println(maxScoreUsing1PassSolution("011101"));
		System.out.println(maxScoreUsing1PassSolution("00111"));
		System.out.println(maxScoreUsing1PassSolution("1111"));
	}
	//Approach-1 (Brute Force)
	//T.C : O(n^2)
	//S.C : O(1)
	public static int maxScore1(String s) {
		char ch[] = s.toCharArray();
		int maxScore = 0;
		for (int i = 0; i < ch.length - 2; i++) {

			int no_of_zero_count_leftside = 0;
			for (int j = 0; j <= i; j++) {
				if (ch[j] == '0') {
					no_of_zero_count_leftside++;
				}
			}

			int no_of_ones_count_rightside = 0;
			for (int j = i + 1; j < ch.length; j++) {
				if (ch[j] == '1') {
					no_of_ones_count_rightside++;
				}
			}
			maxScore = Math.max(maxScore, no_of_zero_count_leftside + no_of_ones_count_rightside);
		}
		return maxScore;
	}
	
	//Approach-2 (Making use of ones count - 2 Pass)
	//T.C : O(n)
	//S.C : O(1)
	public static int maxScoreUsing2PassSolution(String s) {
		// Calculate the total number of 1
		int n = s.length();
		int result = Integer.MIN_VALUE;
		int totalOnes = (int) s.chars().filter(ch -> ch == '1').count();

		int zeros = 0;

		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == '1') {
				totalOnes--;
			} else {
				zeros++;
			}

			result = Math.max(result, zeros + totalOnes);
		}
		return result;
	}
	
	//Approach-3 (1 Pass - Use equation)
	//T.C : O(n)
	//S.C : O(1)
	public static int maxScoreUsing1PassSolution(String s) {
		int n = s.length();
		int result = Integer.MIN_VALUE;

		int zeros = 0;
		int ones = 0;

		for (int i = 0; i <= n - 2; i++) {
			if (s.charAt(i) == '1') {
				ones++;
			} else {
				zeros++;
			}

			result = Math.max(result, zeros - ones);
		}

		if (s.charAt(n - 1) == '1') {
			ones++;
		}

		return result + ones;
	}
	/*
		Score = ZL + OR ==> Given 	ZL : Total number of zero in the left side and 
									OR : Total number of One in the right side
			
		OT = OL + OR 
			OT : Total number of zero
			OL : Total number of Ones in the left side
			OR : Total number of Ones in the right side
		OR = OT - OL Place OR value in the above equation.
		
		Score = ZL + ( OT - OL)
		Score = ( ZL - OL ) + OT
		
	
	*/
}


/*

1422. Maximum Score After Splitting a String.

https://leetcode.com/problems/maximum-score-after-splitting-a-string/

Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).

The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.

 

Example 1:

Input: s = "011101"
Output: 5 
Explanation: 
All possible ways of splitting s into two non-empty substrings are:
left = "0" and right = "11101", score = 1 + 4 = 5 
left = "01" and right = "1101", score = 1 + 3 = 4 
left = "011" and right = "101", score = 1 + 2 = 3 
left = "0111" and right = "01", score = 1 + 1 = 2 
left = "01110" and right = "1", score = 2 + 1 = 3

Example 2:

Input: s = "00111"
Output: 5
Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5

Example 3:

Input: s = "1111"
Output: 3

 

Constraints:

    2 <= s.length <= 500
    The string s consists of characters '0' and '1' only.





*/
