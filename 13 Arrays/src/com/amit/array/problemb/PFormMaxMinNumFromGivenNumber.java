package com.amit.array.problemb;

import java.util.Arrays;

/*
Find maximum/minimum number that can be formed using digits of a given number.
Input : 38293367
Output : 98763332

Input : 1203465
Output: 6543210
Time Complexity: O( N log N )
*/
public class PFormMaxMinNumFromGivenNumber {
	public static void main(String[] args) {
		int num = 292;
		System.out.println("Given Number::"+num);
		int maxNumer = printMaxNum(num);
		System.out.println("Maximum number::"+maxNumer);
		System.out.println("*********************");
		int maxNum = getMaxNumer(num);
		System.out.println("maxNum number::"+maxNum);
		System.out.println("************************");
		System.out.println(getMaxNumber(num));
		System.out.println(getMinNumber(num));
	}

	public static int getMaxNumer(int num) {
		String str = Integer.toString(num);
		int n = str.length();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			int value = ch - '0';
			arr[i] = value;
		}
		System.out.println(Arrays.toString(arr));
		quickSortRecursion(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		return formNumber(arr);
	}

	public static int formNumber(int[] arr) {
		int sum = 0;
		int n = arr.length;
		int multiplyer = 1;
		int num = 0;
		for (int i = n - 1; i >= 0; i--) {
			num = multiplyer * arr[i];
			sum = sum + num;
			multiplyer = multiplyer * 10;
		}
		return sum;
	}

	public static void quickSortRecursion(int[] arr, int low, int high) {
		int pi = partition(arr, low, high);
		if (low < pi - 1) {
			quickSortRecursion(arr, low, pi - 1);
		}
		if (pi < high) {
			quickSortRecursion(arr, pi, high);
		}
	}

	public static int partition(int[] A, int low, int high) {
		int midIndex = (low + high) / 2;
		int pivot = A[midIndex];
		while (low <= high) {
			// We want in reverse order that is why instead of less checking greater
			while (A[low] > pivot) {
				low++;
			}
			// We want in reverse order that is why instead of greater checking less
			while (A[high] < pivot) {
				high--;
			}
			if (low <= high) {
				int temp = A[low];
				A[low] = A[high];
				A[high] = temp;
				low++;
				high--;
			}
		}
		return low;
	}
	
	//Time Complexity: O( N ), where N is the number of digits in the given number. 
	//Auxiliary Space:  O(1)
	// Function to print the maximum number
	public	static int printMaxNum(int num) {
		// hashed array to store count of digits
		int count[] = new int[10];

		// Converting given number to string
		String str = Integer.toString(num);
		int index=0;
		// Updating the count array
		for (int i = 0; i < str.length(); i++) {
			index = str.charAt(i) - '0';
			count[index]++;
		}
		// result is to store the final number
		int result = 0, multiplier = 1;

		// Traversing the count array
		// to calculate the maximum number
		System.out.println(Arrays.toString(count));
		
		 
		for (int i = 0; i <= 9; i++) {
			while (count[i] > 0) {
				result = result + (i * multiplier);
				count[i] = count[i] - 1;
				multiplier = multiplier * 10;
			}
		}
		 
		
		/*
		//For calculate the minimum number
		for (int i = count.length - 1; i >= 0; i--) {
			while (count[i] > 0) {
				result = result + (i * multiplier);
				count[i]--;
				multiplier = multiplier * 10;
			}
		}
		
		*/
		// return the result
		return result;
	}
	
	static long getMaxNumber(long num) {
		char[] digits = String.valueOf(num).toCharArray();
		Arrays.sort(digits);
		// Reverse the sorted array for max number
		StringBuilder maxNum = new StringBuilder(new String(digits)).reverse();
		return Long.parseLong(maxNum.toString());
	}
	
	static long getMinNumber(long num) {
		char[] digits = String.valueOf(num).toCharArray();
		Arrays.sort(digits);
		return Long.parseLong(new String(digits));
	}

}

//https://www.geeksforgeeks.org/find-maximum-number-can-formed-digits-number-reviewed/