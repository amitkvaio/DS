package com.amit.array;

import java.util.HashMap;
import java.util.Map.Entry;

/*
Find the number occurring odd number of times in an array
we will see how to find number occurring odd number of times in the array.
int array[] = new int[]{20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20};
Number which occurs odd number of times is : 50
 
Solution 1: Use two for loops and compare elements:
Time Complexity: O(n^2)
Auxiliary Space: O(1)
*****************************
Solution 2: Use Hashing
Time Complexity: O(n)
Auxiliary Space: O(n)
*****************************************
Solution 3: Use XOR operation:
Time Complexity: O(n)
Auxiliary Space: O(1)

*/
public class Arrays12 {

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		int n = arr.length;
		System.out.println(">>>>>>>>>>>>>>>> Using two for loop >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(getOddOccurrenceUsingForLoop(arr, n));
		System.out.println(">>>>>>>>>>>>>>>> Using Hashing >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(getOddTimesElementHashing(arr));
		System.out.println(">>>>>>>>>>>>>>>>> Using XOR >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(getOddTimesElementUsingXOR(arr));
		
	}
	static int getOddOccurrenceUsingForLoop(int arr[], int arr_size) {
		int i;
		for (i = 0; i < arr_size; i++) {
			int count = 0;
			for (int j = 0; j < arr_size; j++) {
				if (arr[i] == arr[j])
					count++;
			}
			if (count % 2 != 0)
				return arr[i];
		}
		return -1;
	}
	
	public static int getOddTimesElementHashing(int ar[]) {
		int i;

		HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
		for (i = 0; i < ar.length; i++) {
			int element = ar[i];
			if (elements.get(element) == null) {
				elements.put(element, 1);

			} else
				elements.put(element, elements.get(element) + 1);
		}
		for (Entry<Integer, Integer> entry : elements.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				return entry.getKey();
			}
		}
		return -1;
	}

	public static int getOddTimesElementUsingXOR(int ar[]) {
		int i;
		int result = 0;
		for (i = 0; i < ar.length; i++) {
			result = result ^ ar[i];
		}
		return result;
	}
}
