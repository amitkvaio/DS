package com.heap;

import java.util.NoSuchElementException;

// MaxHeap implemented using Array 
public class AMaxHeapImp {
	private int[] A;
	private int size;

	public AMaxHeapImp(int capacity) {
		size = 0;
		A = new int[capacity];
	}
	
	public int[] getMaxHeapArray() {
		return A;
	}

	// This will check if the heap is empty or not : Complexity: O(1)
	public int getSize() {
		return size;
	}

	// This will check if the heap is empty or not : Complexity: O(1)
	public boolean isEmpty() {
		return size == 0;
	}

	// This will check if the heap is full or not : Complexity: O(1)
	public boolean isFull() {
		return size == A.length;
	}

	// return the parent node
	private int parent(int i) {
		return  (i - 1) / 2;
	}
	
	//return the left node of the given parent node index
	public static int left(int i) {
		return (2 * i) + 1;
	}

	//return the right node of the given parent node index
	public static int right(int i) {
		return (2 * i) + 2;
	}

	// This method returns the max element of the heap. complexity: O(1)
	public int getMax() {
		if (isEmpty())
			throw new NoSuchElementException("Heap is empty.");
		return A[0];
	}

	// This method used to print all element of the heap
	public void printHeap() {
		System.out.print("\nMax Heap = ");
		for (int i = 0; i < size; i++)
			System.out.print(A[i] + " ");
		System.out.println();
	}

	/**
	 * This will insert new element in to heap Complexity: O(log N) As worst case scenario, we need to traverse till the root
	 */

	public void insertHeap(int value) {
		if (isFull())
			throw new NoSuchElementException("Heap is full, No space to insert new element");
		A[size] = value;
		int i = size;
		size = size + 1;
		while (i > 0) {
			// Getting the parent index
			int parIndex = parent(i);
			// swapping
			if (A[parIndex] < A[i]) {
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
		A[size] = value;
		heapifyUp(size);
		size = size + 1;
	}

	// This method used to maintain the heap property while inserting an element.
	private void heapifyUp(int pos) {
		int temp = A[pos];
		while (pos > 0 && temp > A[parent(pos)]) {
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
		A[x] = A[size - 1];
		size = size - 1;
		heapify(A, x, size);
		return value;
	}

	//TC: O(N)
	/*
	For the given array need to convert into heap.
	*/
	public void buildHeap(int arr[], int size) {
		for (int i = parent(size)-1; i >= 0; i--) {
			heapify(arr, i, size);
		}
	}
	
	
	/*
	Given Binary Heap with one possible violation
	While deletion of any element in the heap need to rearrange the elements in order
	to follow the heap max/min property. 
	*/
	public void heapify(int arr[], int index, int size) {
		int left = left(index);
		int right = right(index);

		int max = index;

		if (left <= size && arr[left] > arr[max]) {
			max = left;
		}
		if (right <= size && arr[right] > arr[max]) {
			max = right;
		}
		if (index != max) {
			int temp = arr[index];
			arr[index] = arr[max];
			arr[max] = temp;
			heapify(arr, max, size);
		}
	}
	
	

	// This will replace the values of the given index Complexity: O(log N)
	public void replace(int index, int value) {
		if (isEmpty())
			throw new NoSuchElementException("Heap is empty, No element to delete");
		A[index] = value;
		while (index != 0) {
			if (A[parent(index)] < A[index]) {
				int temp = A[index];
				A[index] = A[parent(index)];
				A[parent(index)] = temp;
				index = parent(index);
			}
		}
	}
	
	// This will increaseOrDecrease the values of the given index Complexity: O(log N)
	public void increaseOrDecrese(int index, int value) {
		if (isEmpty())
			throw new NoSuchElementException("Heap is empty, No element to delete");
		A[index] = A[index] + value;
		System.out.println("Index::"+index +" Value::"+A[index]);
		while (index != 0) {
			if (A[parent(index)] < A[index]) {
				int temp = A[index];
				A[index] = A[parent(index)];
				A[parent(index)] = temp;
				index = parent(index);
			}
		}
	}
}
