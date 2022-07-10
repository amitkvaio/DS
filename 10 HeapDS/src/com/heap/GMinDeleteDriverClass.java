package com.heap;

import java.util.Random;

public class GMinDeleteDriverClass {
	public static void main(String[] args) {
		EMinHeapImp heap = new EMinHeapImp(10);
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
			//ran.nextInt(max - min) + min; Print the random number in the given range.
			int value = ran.nextInt(100 - 10) + 10;
			heap.insertHeap(value);
		}
		heap.printHeap();
		System.out.println(heap.getSize());

		for (int i = 0; i < heap.getSize();) {
			System.out.println("--After deletion--");
			int value = heap.delete(i);
			System.out.println("Delete element :" + value);
			heap.printHeap();
			System.out.println("Size::" + heap.getSize());
			System.out.println("*************************************");
			if(heap.getSize()==3) {
				break;
			}
		}
	}
}
