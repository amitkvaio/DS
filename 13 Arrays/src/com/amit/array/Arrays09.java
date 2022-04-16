package com.amit.array;
/*
Problem :

You are given an integer array containing 1 to n but one of the number from 1 to n in the array is missing. 
You need to provide optimum solution to find the missing number. Number can not be repeated in the array.
For example:

int[] arr1={7,5,6,1,4,2};
Missing numner : 3
int[] arr2={5,3,1,2};
Missing numner : 4

TC =O(n)
sc = O(1)

*/
public class Arrays09 {
	public static void main(String[] args) {

		int[] arr1 = { 7, 5, 6, 1, 4, 2 };
		System.out.println("Missing number from array arr1: " + missingNumber(arr1));
		int[] arr2 = { 5, 3, 1, 2 };
		System.out.println("Missing number from array arr2: " + missingNumber(arr2));

	}

	public static int missingNumber(int[] arr) {
		int n = arr.length + 1;
		int sum = n * (n + 1) / 2;
		int restSum = 0;
		for (int i = 0; i < arr.length; i++) {
			restSum = restSum + arr[i];
		}
		int missingNumber = sum - restSum;
		return missingNumber;
	}
}
