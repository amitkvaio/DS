package com.heap;

import java.util.Arrays;
import java.util.Random;

public class FMinInsertDriverClass {
	public static void main(String[] args) {
		EMinHeapImp heap = new EMinHeapImp(10);
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			//ran.nextInt(max - min) + min; Print the random number in the given range.
			int value = ran.nextInt(100 - 10) + 10;
			System.out.print(value +" ");
			heap.insertHeap(value);
		}
		heap.printHeap();
		System.out.println(heap.getSize());
		System.out.println(heap.getMin());
		System.out.println(heap.isFull());
		System.out.println(Arrays.toString(heap.getMinHeapArray()));
	}
}
