package com.interview;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Morgan03<T> {
	void add(T t) {
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Morgan03<Number> myadd = new Morgan03<Number>();
		myadd.add(new Integer(0));
		myadd.add(new Double(1.0));
		
		BlockingDeque<Integer> deque = new LinkedBlockingDeque<Integer>();
		deque.offerLast(10, 5, TimeUnit.SECONDS);
		System.out.println(deque.pollLast( 5, TimeUnit.SECONDS));
		System.out.println(deque.pollLast( 5, TimeUnit.SECONDS));
	}
}
