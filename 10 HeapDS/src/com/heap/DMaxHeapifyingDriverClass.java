package com.heap;

import java.util.Arrays;

public class DMaxHeapifyingDriverClass {
	public static void main(String[] args) {
		int[] arr = {10,20,8,15,6,3,1,12,30};
		System.out.println("---Before Heapifying---"+Arrays.toString(arr));
		
		AMaxHeapImp imp = new AMaxHeapImp(10);
		imp.buildHeap(arr, arr.length);
		System.out.println("---After Heapifying--- "+Arrays.toString(arr));
	}
}
