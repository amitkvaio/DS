package com.leetcode.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

// https://leetcode.com/problems/majority-element/
//Moore Voting approach
public class JMooreMajorityElements {
	public static void main(String[] args) {
		int arr1[] = { 4, 3, 2, 4, 4, 6, 4, 4, 4, 2 };
		int arr2[] = {3,2,3};
		int arr3[] = {2,2,1,1,1,2,2};
		bruteForceAppraoch(arr1);bruteForceAppraoch(arr2);bruteForceAppraoch(arr3);
		System.out.println("***********Using Hash Map***************");
		usingHashMap(arr1);usingHashMap(arr2);usingHashMap(arr3);
		System.out.println("*******************Using sorting ***********************");
		usingSorting(arr1);usingSorting(arr2);usingSorting(arr3);
		System.out.println("*******************Using Moore Voting ***********************");
		usingMooreVotingTech(arr1);usingMooreVotingTech(arr2);usingMooreVotingTech(arr3);
	}
	
	//TC = O(N*N) ST : O(1)
	public static void bruteForceAppraoch(int[] arr) {
		int n = arr.length;
		int major = n / 2;
		int count = 0;
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n ; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count > major) {
				System.out.println("Majority elements::"+arr[i]);
				break;
			}
		}
	}
	
	//TC : O(n) sc: O(n)
	public static void usingHashMap(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int major = arr.length/2;
		for (int num : arr) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			}else {
				map.put(num, 1);
			}
		}
		Set<Integer> entrySet = map.keySet();
		for (Integer key : entrySet) {
			if(map.get(key)>major) {
				System.out.println("Majority elements::"+key);
				break;
			}
		}
	}
	
	//TC : O(nlogn) sc: O(1)
	public static void usingSorting(int[] arr) {
		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		int majorIndex = arr.length/2;
		System.out.println("Majority elements::"+arr[majorIndex]);
	}
	
	//TC: O(N) SC: O(1)
	public static void usingMooreVotingTech(int[] arr) {
		int candidate=arr[0];
		int count =1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]==candidate) {
				count++;
			}else {
				count--;
				if(count==0) {
					candidate=arr[i];
					count=1;
				}
			}
		}
		System.out.println("Majority elements::>>>>"+candidate);
		
		// we can not assume , so we check
		int count2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == candidate) {
				count2++;
			}
		}

		if (count2 > arr.length / 2)
			System.out.println("Majority elements::" + candidate);
		else
			System.out.println("Majority elements::" + -1);
	}
}
