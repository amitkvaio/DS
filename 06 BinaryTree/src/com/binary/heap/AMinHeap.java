package com.binary.heap;

public class AMinHeap {
	int [] arr;
	int size;
	int capacity;
	
	public AMinHeap(int cap) {
		this.capacity = cap;
		size = 0;
		arr = new int[cap];
	}
	
	public static int left(int i) {
		return (2 * i) + 1;
	}

	public static int right(int i) {
		return (2 * i) + 2;
	}

	public static int parent(int i) {
		return (i - 1) / 2;
	}
	
	public void insert(int val) {
		if (size == capacity) {
			return;
		}
		size++;
		arr[size-1] = val;
		for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; i++) {
			int temp = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)]= temp;
			i = parent(i);
		}
	}
}
