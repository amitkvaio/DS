package com.heap;

import java.util.Arrays;

public class KHeapSort {
	
	static AMaxHeapImp heap = new AMaxHeapImp(10); 
	
	public static void main(String[] args) {
		int[] arr = new int[] { 22, 13, 17, 11, 10, 14, 12, 16, 7, 18 };
		System.out.println("Befor Heap Sort :" + Arrays.toString(arr));
		int len = arr.length;
		heapSort(arr, len);
		System.out.println("After Heap Sort:" + Arrays.toString(arr));
	}

	public static void heapSort(int[] arr, int size) {
		heap.buildHeap(arr, size);
		int lastIndex = size - 1;
		while (lastIndex > 0) {
			swap(arr, 0, lastIndex);
			lastIndex = lastIndex - 1;
			heap.heapify(arr, 0, lastIndex);
		}
	}

	public static void swap(int[] arr, int firstIdx, int secondIdx) {
		int temp = arr[firstIdx];
		arr[firstIdx] = arr[secondIdx];
		arr[secondIdx] = temp;
	}
}
/*
Time Complexity:
Best case : O(nlogn)
Average case : O(nlogn)
Worst case : O(nlogn)
*/
