package com.heap;

import java.util.NoSuchElementException;

//MaxHeap implemented using Array 
public class EMinHeapImp {

	private int[] A;
	private int heapSize;

	public EMinHeapImp(int capacity) {
		heapSize = 0;
		A = new int[capacity];
	}
	
	public int[] getMinHeapArray() {
		return A;
	}
	
	// This will check if the heap is empty or not : Complexity: O(1)
	public int getSize() {
		return heapSize;
	}

	// This will check if the heap is empty or not : Complexity: O(1)
	public boolean isEmpty() {
		return heapSize == 0;
	}

	// This will check if the heap is full or not : Complexity: O(1)
	public boolean isFull() {
		return heapSize == A.length;
	}

	// return the parent node
	private int parent(int i) {
		int par = (i - 1) / 2;
		return par;
	}

	// This method returns the min element of the heap. complexity: O(1)
	public int getMin() {
		if (isEmpty())
			throw new NoSuchElementException("Heap is empty.");
		return A[0];
	}

	// This method used to print all element of the heap
	public void printHeap() {
		System.out.print("Min Heap = ");
		for (int i = 0; i < heapSize; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	/**
	 * This will insert new element in to heap Complexity: O(log N) As worst case scenario, we need to traverse till the root
	 */

	public void insertHeap(int value) {
		if (isFull())
			throw new NoSuchElementException("Heap is full, No space to insert new element");
		A[heapSize] = value;
		int i = heapSize;
		heapSize = heapSize + 1;
		while (i > 0) {
			// Getting the parent index
			int parIndex = parent(i);
			// swapping
			if (A[parIndex] > A[i]) {
				int temp = A[parIndex];
				A[parIndex] = A[i];
				A[i] = temp;
				i = parIndex;
			} else {
				return;
			}
		}
	}

	public void insertHeap1(int value) {
		if (isFull())
			throw new NoSuchElementException("Heap is full, No space to insert new element");
		A[heapSize] = value;
		heapifyUp(heapSize);
		heapSize = heapSize + 1;
	}

	// This method used to maintain the heap property while inserting an element.
	private void heapifyUp(int pos) {
		int temp = A[pos];
		while (pos > 0 && temp < A[parent(pos)]) {
			A[pos] = A[parent(pos)];
			pos = parent(pos);
		}
		A[pos] = temp;
	}

	// This will delete element at index x Complexity: O(log N)
	public int delete(int x) {
		if (isEmpty())
			throw new NoSuchElementException("Heap is empty, No element to delete");
		int value = A[x];
		A[x] = A[heapSize - 1];
		heapSize = heapSize - 1;
		heapify(A, x, heapSize);
		return value;
	}

	public void buildHeap(int arr[], int size) {
		for (int i = size / 2; i >= 0; i--) {
			heapify(arr, i, size);
		}
	}

	public void heapify(int arr[], int index, int size) {
		int left = 2 * index + 1;
		int right = left + 1;

		int max = index;

		if (left <= size && arr[left] < arr[max]) {
			max = left;
		}
		if (right <= size && arr[right] < arr[max]) {
			max = right;
		}
		if (index != max) {
			int temp = arr[index];
			arr[index] = arr[max];
			arr[max] = temp;
			heapify(arr, max, size);
		}
	}

}
