package com.amit.array.problemb;

/*
You are given an array of numbers. Find out the array index or position
where sum of numbers preceeding the index is equals to sum of numbers
succeeding the index.

Example 1:
	Input List: 5, 9, 18, 6, 4, 11, 4, 3, 2, 2
	Output is : 3
	Because :  5 + 9 + 18 = 6 + 4 + 11 + 4 + 3 + 2 + 2

Example 2:
	Input List: 25, 6, 12, 4, 3
	Output is : 1
	Because :  25 = 6 + 12 + 4 + 3
	if nothing match return -1
	-1;
*/
public class DSumOfPosition {

	public static void main(String[] args) {
		int arr[] = { 5, 9, 18, 6, 4, 11, 4, 3, 2, 2 };
		int arr1[] = { 25, 6, 12, 4, 3};
		int index = findIndex(arr1);
		System.out.println("Index::" + index);
	}

	public static int findIndex(int[] arr) {

		int lftSum = arr[0];
		int rgtSum = arr[arr.length - 1];

		int low = 1;
		int high = arr.length - 2; 

		while (true) {
			if (lftSum > rgtSum) {
				rgtSum = rgtSum + arr[high];
				high--;
			} else {
				lftSum = lftSum + arr[low];
				low++;
			}
			if (low >= high || high >= low) {
				if (lftSum == rgtSum) {
					break;
				}
			}
		}
		return high;
	}
}
