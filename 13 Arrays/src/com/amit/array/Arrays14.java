package com.amit.array;

import java.util.Arrays;

/*
Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. 
The functions should put all 0s first, then all 1s and all 2s in last.

Examples: 
Input :  {0, 1, 2, 0, 1, 2}
Output : {0, 0, 1, 1, 2, 2}

Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

Solution 1
Count the number of 0’s, 1’s and 2’s. After Counting, put all 0’s first, then 1’s and lastly 2’s in the array. 
We traverse the array two times. 
Time complexity will be O(n).
It requires two traversals of array.
*******************************************
Sort an array of 0s, 1s and 2s (Dutch National Flag Algorithm)
 Complexity Analysis: 
 Time Complexity: O(n). 
 Only one traversal of the array is needed.
 Space Complexity: O(1). 
 No extra space is required.                    
 
*/
public class Arrays14 {
	
	public static void main(String args[]) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int n = 12;
		sort012(arr, n);
		System.out.println(">>>>>>>>>>>>>>>Using Dutch National Flag Algorithm>>>>>>>>>>>>>>>>");
		sortDutchNationalAlgoritham(arr,n);
	}
	
	public static void sort012(int arr[], int n) {
		int count0 = 0, count1 = 0;
		int count2 = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				count0++;
			if (arr[i] == 1)
				count1++;
			if (arr[i] == 2)
				count2++;
		}

		for (int i = 0; i < count0; i++)
			arr[i] = 0;

		for (int i = count0; i < (count0 + count1); i++)
			arr[i] = 1;

		for (int i = (count0 + count1); i < n; i++)
			arr[i] = 2;
		
		System.out.println("After Sorting::"+Arrays.toString(arr));
	}
	
	public static void sortDutchNationalAlgoritham(int arr[], int arr_size) {
		int low = 0;
		int high = arr_size - 1;
		int mid = 0;
		while (mid <= high) {
			switch (arr[mid]) {
			case 0: {
				swapValues(arr[low], arr[mid]);
				low++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				swapValues(arr[mid], arr[high]);
				high--;
				break;
			}
			}
		}
		System.out.println("After Sorting::" + Arrays.toString(arr));
	}
	
	public static void swapValues(int x,int y) {
		int temp = x;
		x=y;
		y=temp;
	}
}
