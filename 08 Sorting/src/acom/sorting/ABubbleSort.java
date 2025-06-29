package acom.sorting;

import java.util.Arrays;

public class ABubbleSort {
	public static void main(String[] args) {
		//1, 55, 66, 77, 88, 99
		int [] arr = new int[] {64, 34, 25, 12, 22, 11, 90};
		System.out.println("Befor Sorting : "+Arrays.toString(arr));
		bubbleSort(arr);
		//bubbleSort_Recursive(arr,arr.length);
		System.out.println("After Sorting : " + Arrays.toString(arr));
	}
	
	public static void bubbleSort(int[] arr) {
		int SIZE = arr.length;
		if (arr == null || SIZE == 0)
			return;

		for (int i = 0; i < SIZE - 1; i++) {
			boolean isSwapped = true; // Should be reset at the start of each pass

			for (int j = 0; j < SIZE -1 -i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					isSwapped = true; // A swap occurred
				}
			}

			// No swaps in this pass means array is sorted
			if (!isSwapped)
				break;
		}
	}
	
	// Bubble sort using with recursive
	static void bubbleSort_Recursive(int arr[], int size) {
		// Base case
		if (size == 1)
			return;
		// One pass of bubble sort. After this pass, the largest element is moved (or bubbled) to end.
		for (int i = 0; i < size - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				// swap arr[i], arr[i+1]
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		// Largest element is fixed,recur for remaining array
		bubbleSort_Recursive(arr, size - 1);
	}
}

/*
Time Complexity:
Best case: O(n)
Average case: O(n^2)
Worst case: O(n^2)



Input:

arr = [5, 3, 8, 4, 2] (n=5n=5)
Execution:

    Outer Loop i=0:
        Inner loop runs n−i−1 = 5−0−1	=4 times:
            Compare and swap 5 & 3: [3, 5, 8, 4, 2]
            Compare and swap 5 & 8: [3, 5, 8, 4, 2]
            Compare and swap 8 & 4: [3, 5, 4, 8, 2]
            Compare and swap 8 & 2: [3, 5, 4, 2, 8]

    Outer Loop i=1:
        Inner loop runs n−i−1 = 5−1−1	=3 times:
            Compare and swap 3 & 5: [3, 5, 4, 2, 8]
            Compare and swap 5 & 4: [3, 4, 5, 2, 8]
            Compare and swap 5 & 2: [3, 4, 2, 5, 8]

    Outer Loop i=2:
        Inner loop runs n−2−1 = 5−2−1	=2 times:
            Compare and swap 3 & 4: [3, 4, 2, 5, 8]
            Compare and swap 4 & 2: [3, 2, 4, 5, 8]

    Outer Loop i=3:
        Inner loop runs n−3−1 = 5−3−1	=1 times:
            Compare and swap 3 & 2: [2, 3, 4, 5, 8]


Summary:
    The outer loop runs n−1 times because each pass places one element in its correct position.
    The inner loop runs n−i−1 times because elements at the end of the list are already sorted 

In each round, compare each pair of adjacent elements, and swap them if they are in the wrong order. 
	The largest number "bubbles up" to the end in each round
*/