package com.problem.soving01;

import java.util.Arrays;
import java.util.Stack;

public class WLeadersInArray {
	public static void main(String[] args) {
		int[] arr = { 25, 10, 2, 4, 1, 3 };
		System.out.printf("1. Input array is : %s", Arrays.toString(arr));
		printLeaders(arr);
	}

	private static void printLeaders(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		int eIdx = arr.length - 1;
		int max = arr[eIdx];
		stack.push(max);
		eIdx=eIdx-1;
		while (eIdx >= 0) {
			int current = arr[eIdx];
			if (current > max) {
				max = current;
				stack.push(max);
			}
			eIdx--;
		}

		System.out.printf("\nLeaders in an array : ");
		while (!stack.isEmpty()) {
			System.out.printf("%d ", stack.pop());
		}
	}
}
/*
    What is leader element in an array?
        The element which is greater than the elements to its right.
    The element on the extreme right, is assumed to be the leader element.
    
1. Input array is : [25, 10, 2, 4, 1, 3]
Leaders in an array : 25 10 4 3 
*/
