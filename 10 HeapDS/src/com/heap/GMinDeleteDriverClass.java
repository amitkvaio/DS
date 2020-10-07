package com.heap;

import java.util.Random;

public class GMinDeleteDriverClass {
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

		for (int index2delete = 0; index2delete < minHeap.getSize();) {
			System.out.println("--After deletion--");
			int value = minHeap.delete(index2delete);
			System.out.println("Delete element :" + value);
			minHeap.printHeap();
			System.out.println("Size::" + minHeap.getSize());
			System.out.println("*************************************");
			if(minHeap.getSize()==3) {
				break;
			}
		}
	}
}
