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
import java.util.HashSet;

public class JMissingNumber {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 8, -1, 0 };
		System.out.println("Minimum missing number :" + findSmallestMissing(arr));
		System.out.println("Minimum missing number :" + findSmallestMissingUsingCyclicSort(arr));
		System.out.println(Arrays.toString(arr));
		
	}

	static int findSmallestMissing(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (num > 0) set.add(num);
        }

        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        return i;
    }
	
	static int findSmallestMissingUsingCyclicSort(int[] arr) {
		int n = arr.length;
		int i = 0;
		while (i < n) {
			// Correct position of arr[i] should be arr[i] - 1
			int correctIndex = arr[i] - 1;

			// Swap if arr[i] is not at its correct position & it's within range [1, n]
			if (arr[i] > 0 && arr[i] <= n && arr[i] != arr[correctIndex]) {
				swap(arr, i, correctIndex);
			} else {
				i++; // Move to next element
			}
		}

		// Step 2: Find the first missing positive number
		for (int j = 0; j < n; j++) {
			if (arr[j] != j + 1) {
				return j + 1;
			}
		}

		// If all numbers are in place, return n + 1
		return n + 1;
	}
	
	// Swap function
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
/*
Time Complexity: O(n)
Space Complexity: O(n) (because of HashSet)
*/