package com.heap;

import java.util.Random;

public class CMaxDeleteDriverClass {
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
		
		System.out.println("--After deletion--");
		int value = maxHeap.delete(2);
		System.out.println("Delete element :" + value);
		maxHeap.printHeap();
		System.out.println("Size::" + maxHeap.getSize());
		System.out.println("*************************************");
		
		for (int index2delete = 0; index2delete < maxHeap.getSize();) {
			System.out.println("--After deletion--");
			int val = maxHeap.delete(index2delete);
			System.out.println("Delete element :" + val);
			maxHeap.printHeap();
			System.out.println("Size::" + maxHeap.getSize());
			System.out.println("*************************************");
			if(maxHeap.getSize()==3) {
				break;
			}
		}
	}
}
