package com.amit.array.problema;

import java.util.Arrays;

/*
Separate odd and even numbers in an array
arr[] = {12, 17, 70, 15, 22, 65, 21, 90}
Array after separating odd and even numbers :
{12, 90, 70, 22, 15, 65, 21, 17}
TC =O(n)
SC =O(1)
*/
public class RSeprateOddEven {
	public static void main(String[] args) {

		int arr[] = { 12, 17, 70, 15, 22, 65, 21, 90 };
		System.out.println("Original Array:\n"+Arrays.toString(arr));
		arr = separateEvenOddNumbers(arr);
		System.out.println("Array after separating even and odd numbers :\n"+Arrays.toString(arr));
	}

	public static int[] separateEvenOddNumbers(int arr[]) {
		int left = 0;
		int right = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {

			while (arr[left] % 2 == 0) {
				left++;
			}
			while (arr[right] % 2 == 1) {
				right--;
			}

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return arr;
	}
}
