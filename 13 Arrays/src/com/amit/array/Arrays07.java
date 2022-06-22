package com.amit.array;

import java.util.ArrayList;
import java.util.HashMap;

/*
Find duplicates in a given array when elements are not limited to a range
Given an array of n integers. The task is to print the duplicates in the given array. 
	If there are no duplicates then print -1. 

Input: {2, 10,10, 100, 2, 10, 11,2,11,2}
Output: 2 10 11

Input: {5, 40, 1, 40, 100000, 1, 5, 1}
Output: 5 40 1

Note: The duplicate elements can be printed in any order.
*/
public class Arrays07 {
	public static void main(String[] args) {
		int arr[] = { 12, 11, 40, 12, 5, 6, 5, 12, 11 };
        int n = arr.length;
        findDuplicates(arr, n);
        System.out.println("\n***********Using HashMap*************");
        findDuplicateUsingHashMap(arr,n);
	}
	
	//TC : O(n*n)
	static void findDuplicates( int arr[], int len) {
        // initialize ifPresent as false
        boolean ifPresent = false;
 
        // ArrayList to store the output
        ArrayList<Integer> al = new ArrayList<Integer>();
		 
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] == arr[j]) {
                    // checking if element is present in the ArrayList
                    // or not if present then break
                    if (al.contains(arr[i])) {
                        break;
                    }
                    // if element is not present in the ArrayList then add it to ArrayList
                    // and make ifPresent at true
                    else {
                        al.add(arr[i]);
                        ifPresent = true;
                    }
                }
            }
        }
        if (ifPresent == true) {
            System.out.print(al + " ");
        }
        else {
            System.out.print("No duplicates present in arrays");
        }
	}
	
	//Time Complexity: O(N)
	private static void findDuplicateUsingHashMap(int[] arr, int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean dup = true;
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
				dup = false;
			} else {
				map.put(arr[i], 1);
			}
		}
		map.forEach((k, v) -> {
			if (map.get(k) > 1)
				System.out.println(k);
		});

		if (dup) {
			System.out.println("-1");
		}

	}
}
