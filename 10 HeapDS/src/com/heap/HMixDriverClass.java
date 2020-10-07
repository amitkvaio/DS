package com.heap;

import java.util.Arrays;
import java.util.Random;

public class HMixDriverClass {
	public static void main(String[] args) {

		AMaxHeapImp maxHeap = new AMaxHeapImp(10);
		EMinHeapImp minHeap = new EMinHeapImp(10);

		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			//ran.nextInt(max - min) + min; Print the random number in the given range.
			int value = ran.nextInt(100 - 10) + 10;
			maxHeap.insertHeap(value);
			minHeap.insertHeap(value);
		}

		System.out.println("--Before Heapifying max Heap");
		maxHeap.printHeap();
		System.out.println("--Before Heapifying min Heap");
		minHeap.printHeap();

		int[] maxHeapArr = maxHeap.getMaxHeapArray();
		int[] minHeapArr = minHeap.getMinHeapArray();

		maxHeap.buildHeap(maxHeapArr, maxHeap.getSize() - 1);
		minHeap.buildHeap(minHeapArr, minHeap.getSize() - 1);

		System.out.println("---After Heapifying Max Heap--- " + Arrays.toString(maxHeapArr));
		System.out.println("---After Heapifying Min Heap--- " + Arrays.toString(minHeapArr));

		System.out.println("Max element in maxheap is ::" + maxHeap.getMax());
		System.out.println("Min element in maxheap is ::" + minHeap.getMin());
	}
}
