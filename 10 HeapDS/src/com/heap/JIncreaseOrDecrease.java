package com.heap;

import java.util.Random;
//Increase the give index values by given number
public class JIncreaseOrDecrease {
static AMaxHeapImp heap = new AMaxHeapImp(10);
	
	public static void main(String[] args) {
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
		System.out.println("**********After Increament****************");
		int index = 8;
		heap.increaseOrDecrese(index, 50);
		heap.printHeap();
	}
}
