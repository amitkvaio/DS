//Remove duplicate Elements from an arrays.
package bcom.Arrays1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GRemoveDuplicateElementsFromArrays {
	public static void main(String[] args) {
		int [] arr = new int[]{1, 1, 3, 7, 7, 8, 9, 9, 9, 10};
		removeDuplicate(arr);
		removeDuplicateUsingHashSet(arr);
	}
	
	public static void removeDuplicate(int[] arr) {
		int current = arr[0];
		boolean found = false;
		for (int i = 0; i < arr.length; i++) {
			if (current == arr[i] && !found) {
				found = true;
			} else if (current != arr[i]) {
				System.out.print(" " + current);
				current = arr[i];
				found = false;
			}
		}
		System.out.println(" " + current);
	}
	//This approach has a time complexity of O(n), as adding to a HashSet and iterating over it is generally efficient.
	public static void removeDuplicateUsingHashSet(int[] arr) {
		
		// Create a HashSet to store unique elements
        Set<Integer> uniqueElements = new HashSet<>();
        
        // Add elements of the array to the HashSet
        for (int num : arr) {
            uniqueElements.add(num);
        }

        // Convert HashSet back to an array
        int[] result = new int[uniqueElements.size()];
        int i = 0;
        for (int num : uniqueElements) {
            result[i++] = num;
        }
        System.out.println(Arrays.toString(result));
	}
}
