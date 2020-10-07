package com.heap;

import java.util.Arrays;

public class HMinHeapifyingDriverClass {
	public static void main(String[] args) {
		int[] arr = {10,20,8,15,6,3,1,12,30};
		System.out.println("---Before Heapifying---"+Arrays.toString(arr));
		EMinHeapImp minHeap = new EMinHeapImp(10);
		minHeap.buildHeap(arr, arr.length-1);
		System.out.println("---After Heapifying--- "+Arrays.toString(arr));
	}
}
