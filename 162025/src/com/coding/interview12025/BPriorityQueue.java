package com.coding.interview12025;

import java.util.Collections;
import java.util.PriorityQueue;

public class BPriorityQueue {
	public static void main(String[] args) {
		getPriorityQueueWithMinHeap();
		System.out.println("****************************");
		getPriorityQueueWithMaxHeap();
		System.out.println("***********************");
		findingKLargetNumber();
	}

	private static void getPriorityQueueWithMinHeap() {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Default is Min Heap

		minHeap.add(10);
		minHeap.add(5);
		minHeap.add(30);
		minHeap.add(2);
		minHeap.add(8);

		System.out.println("Min Heap: " + minHeap); // Elements are NOT sorted when printed

		System.out.println("Smallest element (peek): " + minHeap.peek()); 	// 2
		System.out.println("Removing smallest (poll): " + minHeap.poll()); 	// Removes 2
		System.out.println("New top element: " + minHeap.peek()); 			// 5
	}

	private static void getPriorityQueueWithMaxHeap() {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap

		maxHeap.add(10);
		maxHeap.add(5);
		maxHeap.add(30);
		maxHeap.add(2);
		maxHeap.add(8);

		System.out.println("Max Heap: " + maxHeap); // Elements are NOT sorted when printed

		System.out.println("Largest element (peek): " + maxHeap.peek()); // 30
		System.out.println("Removing largest (poll): " + maxHeap.poll()); // Removes 30
		System.out.println("New top element: " + maxHeap.peek()); // 10
	}
	
	//Using PriorityQueue<Integer> in Finding K Largest Numbers
	public static void findingKLargetNumber() {
		int[] arr = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3 };
		int k = 3;

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int num : arr) {
			minHeap.add(num);
			System.out.println(minHeap);
			if (minHeap.size() > k) {
				System.out.println("Inside if::"+minHeap);
				minHeap.poll(); // Remove the smallest element
			}
		}
		System.out.println("K largest elements: " + minHeap);
	}
}


/*
A PriorityQueue in Java is a heap-based data structure that automatically 
	sorts elements in natural order (ascending by default). 

It is part of the java.util package and is implemented as a Min Heap by default.

Min Heap by Default:

    The smallest element is always at the top (first element).
    When elements are removed, the next smallest element moves to the top.

Max Heap (Descending Order):

    To use it as a Max Heap (largest element at the top), we use a custom comparator.

Efficient Insertions & Deletions:

    Insertion (add): O(log N)
    Removal (poll): O(log N)
    Peek (top element without removal): O(1)
 
Operation	Complexity	Description
add()		O(log N)	Inserts an element while maintaining heap order
poll()		O(log N)	Removes and returns the top (smallest/largest) element
peek()			O(1)	Returns the top element without removing it
size()			O(1)	Returns the number of elements in the queue
*/