package com.heap;

import java.util.Random;

public class FMinInsertDriverClass {
	public static void main(String[] args) {
		EMinHeapImp minHeap = new EMinHeapImp(10);
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			//ran.nextInt(max - min) + min; Print the random number in the given range.
			int value = ran.nextInt(100 - 10) + 10;
			minHeap.insertHeap(value);
		}
		minHeap.printHeap();
		System.out.println(minHeap.getSize());
	}
}
