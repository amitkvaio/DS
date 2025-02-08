package com.leetcode.general;

import java.util.Arrays;

/*
Given a positive integer n and a string s consisting only of letters D or I, 
	you have to find any permutation of first n positive integer that satisfy the given 
		input string.

D means the next number is smaller, while I means the next number is greater.

Notes

    Length of given string s will always equal to n - 1
    Your solution should run in linear time and space.

Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]


*/
public class PfindPermutation {
	public static void main(String[] args) {
		int num = 3;
		String s = "ID";
		int[] output = findPermutation(s, num);
		System.out.println(Arrays.toString(output));
	}
	
	//TC:SC: O(n)
	public static int[] findPermutation(String str,int num) {
		int sLen = str.length();
		int start = 1;
		int end = num;
		int [] P = new int[num];
		
		for (int i = 0; i < sLen ; i++) {
			if(str.charAt(i)=='D') {
				P[i] = end;
				end--;
			}else if(str.charAt(i)=='I') {
				P[i] = start;
				start ++;
			}
		}
		
		//From the question, Length of given string s will always equal to n - 1
		//SO,
		P[num-1] = start;
		return P;
	}
}
