package com.dds;

import java.util.Arrays;

public class MCustomStack {

	int SIZE;
	int stack[];
	int top;
	int incr[];// For hold the increment value.

	public MCustomStack(int maxSize) {
		this.SIZE = maxSize;
		this.stack = new int[SIZE];
		this.incr = new int[SIZE];
		this.top = -1;
	}

	public void push(int value) {
		if (top < SIZE - 1) {
			stack[++top] = value;
		}
	}

	public int pop() {
		if (top == -1) {
			return -1;
		}
		int result = stack[top] + incr[top];
		if (top > 0) {
			incr[top - 1] += incr[top];
		}
		incr[top] = 0;
		top--;
		return result;
	}

	public void increment(int k, int val) {
		int limit = Math.min(k - 1, top);
		if (limit >= 0) {
			incr[limit] = incr[limit] + val;
		}
	}

	public static void main(String[] args) {
		MCustomStack stk = new MCustomStack(3); // Stack is Empty []
		stk.push(1);                          // stack becomes [1]
		stk.push(2);                          // stack becomes [1, 2]
		System.out.println(Arrays.toString(stk.stack));
		System.out.println(stk.pop());                            // return 2 --> Return top of the stack 2, stack becomes [1]
		stk.push(2); 
		System.out.println(Arrays.toString(stk.stack));// stack becomes [1, 2]
		stk.push(3);
		System.out.println(Arrays.toString(stk.stack)); // stack becomes [1, 2, 3]
		stk.push(4);
		System.out.println(Arrays.toString(stk.stack));// stack still [1, 2, 3], Do not add another elements as size is 4
		System.out.println(Arrays.toString(stk.incr));
		stk.increment(5, 100);                // stack becomes [101, 102, 103]
		System.out.println(Arrays.toString(stk.incr));
		stk.increment(2, 100);                // stack becomes [201, 202, 103]
		System.out.println(Arrays.toString(stk.incr));
		System.out.println(stk.pop());                                 // return 103 --> Return top of the stack 103, stack becomes [201, 202]
		System.out.println(stk.pop());                                 // return 202 --> Return top of the stack 202, stack becomes [201]
		System.out.println(stk.pop());                                 // return 201 --> Return top of the stack 201, stack becomes []
		System.out.println(stk.pop());                                 // return -1 --> Stack is empty return -1.
	}
}

/*
https://leetcode.com/problems/design-a-stack-with-increment-operation/description/
LC : 1381
*/
