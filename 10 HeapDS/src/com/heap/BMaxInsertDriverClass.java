package com.heap;

import java.util.Random;

public class BMaxInsertDriverClass {
	public static void main(String[] args) {
		AMaxHeapImp maxHeap = new AMaxHeapImp(10);
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			//ran.nextInt(max - min) + min; Print the random number in the given range.
			int value = ran.nextInt(100 - 10) + 10;
			maxHeap.insertHeap(value);
		}
		maxHeap.printHeap();
		System.out.println(maxHeap.getSize());
	}
}

/*
		100
	   /   \		
	  30     10
	 /  \   /  \
    7    5  3   5
*/