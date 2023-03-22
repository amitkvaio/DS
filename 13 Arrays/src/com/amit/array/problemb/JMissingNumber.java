package com.amit.array.problemb;
/*
print minimum missing number positive number (n>=1)

1,3,2 //4
1,3,2,5//4
7,10,15,4 //1

50,60,90 //1
3,-1,0,4,3,2 //1

*/

import java.util.Arrays;

public class JMissingNumber {
	public static void main(String[] args) {
		System.out.println("********** print minimum missing number positive number ***********");
		int[] arr = { 1, 2, 3, 4, 5, 8, -1, 0 };// 1
		getMinimum(arr);
	}

	public static void getMinimum(int[] arr) {
		Arrays.sort(arr);
		int highest = arr[arr.length - 1];
		int index = 0;
		int start = 1;
		boolean flag = false;
		while (start <= highest) {
			if (arr[index] >= 1) {
				if (arr[index] > start) {
					System.out.println("Mini::" + start);
					flag = true;
					break;
				} else {
					start++;
				}
			}
			index++;
		}
		if (!flag)
			System.out.println(start);
	}
}
