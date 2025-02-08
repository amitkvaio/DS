package com.amit.array.problema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

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
public class GfindDuplicate {
	public static void main(String[] args) {
		int arr[] = { 12, 11, 40, 12, 5, 6, 5, 12, 11 };
        int n = arr.length;
        findDuplicates(arr, n);
        System.out.println("\n***********Using HashMap*************");
        findDuplicateUsingHashMap(arr,n);
        System.out.println("\n***********Using HashSet**************");
        findDuplicateUsingHashSet(arr, n);
        System.out.println(">>>>>>>>>>>Get Duplicate>>>>>>>>>>>>>");
        Integer arr1[] = { 12, 11, 40, 12, 5, 6, 5, 12, 11 };
        getDuplicates(arr1);
        System.out.println(">>>>>>>>>>>Get_____>>>>>>>>>>>>>");
        getDuplicates_(arr);
	}
	
	
	//TC : O(n*n) brute force
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
		
		System.out.println(">>> Using Java 8 >>>>");
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		Arrays.stream(arr).boxed().filter(x->Collections.frequency(Arrays.asList(arr), x)>1)
		.collect(Collectors.toSet())
		.forEach(System.out::println);
		
		System.out.println(">>>>>>>>>>>>");
		
		list.stream()
			.filter(x->Collections.frequency(list, x)>1)
			.collect(Collectors.toSet())
			.forEach(System.out::println);

	}
	
	private static void findDuplicateUsingHashSet(int[] arr, int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(arr[0]);
		boolean status = false;
		for (int i = 1; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				status = true;
				if(!set.add(arr[i])) {
					System.out.print(arr[i] + " ");
				}
			}else {
				set.add(arr[i]);
			}
		}
		
		if(!status)
			System.out.println(-1);
	}
	
	public static <T extends Comparable<T>> void getDuplicates(T[] array) {
		Set<T> dupes = new HashSet<T>();
		for (T i : array) {
			if (!dupes.add(i)) {
				System.out.println("Duplicate element in array is : " + i);
			}
		}
	}
	
	public static void getDuplicates_(int [] array) {
		Set<Integer> dupes = new HashSet<Integer>();
		for (Integer i : array) {
			if (!dupes.add(i)) {
				System.out.println("Duplicate element in array is : " + i);
			}
		}
	}



}
