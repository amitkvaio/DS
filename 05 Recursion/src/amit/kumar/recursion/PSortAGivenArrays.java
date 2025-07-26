package amit.kumar.recursion;

import java.util.ArrayList;
import java.util.List;

public class PSortAGivenArrays {
	public static void main(String[] args) {
		System.out.println(sortArray(new ArrayList<>(List.of(9, 5, 4, 10, 15, 7))));
		System.out.println(sortArray(new ArrayList<>(List.of(10, 4, 3, 70, 34, 2))));
		System.out.println(sortArray(new ArrayList<>(List.of(10, 5, 50, 45, 49, 15))));
		System.out.println(sortArray(new ArrayList<>(List.of(30, 35, 5, 9, 8, 3, 1))));
	}

	//Recursive method to sort the list
	public static ArrayList<Integer> sortArray(ArrayList<Integer> arr) {
		if (arr.size() == 1) {
			return arr;
		}
		
		// Step 1: Remove the last element
		int temp = arr.get(arr.size() - 1);
		arr.remove(arr.size() - 1);
		
		// Step 2: Recursively sort the remaining list
		arr = sortArray(arr);
		
		// Step 3: Insert the removed element back into the sorted list
		arr = insert(arr, temp);
		return arr;
	}

	// Recursive method to insert an element into the correct position in a sorted list
	public static ArrayList<Integer> insert(ArrayList<Integer> arr, int temp) {
		
		// If list is empty or the last element is less than or equal to temp, add temp at the end
		if (arr.size() == 0 || arr.get(arr.size() - 1) <= temp) {
			arr.add(temp);
			return arr;
		}
		
		// Otherwise, remove the last element and recursively insert temp
		int last = arr.get(arr.size() - 1);
		arr.remove(arr.size() - 1);
		arr = insert(arr, temp);
		
		// Add the removed element back after placing temp correctly
		arr.add(last);
		return arr;
	}
}
/*

sort(): Recursively remove last element, sort the rest, and insert the removed element back in sorted order.
insert(): Insert an element in the correct position in a sorted list by recursion.

| Complexity Type  | Value |
| ---------------- | ----- |
| Time Complexity  | O(n²) |
| Space Complexity | O(n)  |

*/