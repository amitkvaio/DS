package com.heap;

import java.util.Arrays;
import java.util.Random;

public class BMaxInsertDriverClass {
	public static void main(String[] args) {
		AMaxHeapImp heap = new AMaxHeapImp(15);
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			//ran.nextInt(max - min) + min; Print the random number in the given range.
			int value = ran.nextInt(100 - 10) + 10;
			System.out.print(value +" ");
			heap.insertHeap(value);
		}
		heap.printHeap();
		System.out.println(heap.getSize());
		System.out.println(heap.getMax());
		System.out.println(heap.isFull());
		System.out.println(Arrays.toString(heap.getMaxHeapArray()));
	}
}

/*
		100
	   /   \		
	  30     10
	 /  \   /  \
    7    5  3   5
*/