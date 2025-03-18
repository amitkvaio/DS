package acom.stack.problem;

import acom.stack.array.StackUsingArray;

/*
Sort a Stack using another stack

Let’s say,  you have two stacks, stack and tempStack.
Pop an element currentData from stack and compare it with head of tempStack.
If currentData it greater, push it to tempStack.
If currentData is lesser than  head of tempStack, 
	pop an element from tempStack and push it to stack until you get the element which is greater than currentData
In the end, tempStack will be sorted stack.

*/
public class ESortUsingTempStack {
	public static void main(String[] args) {
		StackUsingArray stackCustom = new StackUsingArray();
		System.out.println("=================");
		stackCustom.push(5);
		stackCustom.push(1);
		stackCustom.push(3);
		stackCustom.push(2);
		stackCustom.push(6);
		
		System.out.println("=================");
		System.out.println("Before Sorting :");
		System.out.println("=================");
		printStack(stackCustom);
		StackUsingArray sortedStack = sortStack(stackCustom);
		System.out.println("=================");
		System.out.println("After Sorting :");
		System.out.println("=================");
		printStack(sortedStack);

	}

	// Sort a stack using another stack
	public static StackUsingArray sortStack(StackUsingArray stack) {
		StackUsingArray tempStack = new StackUsingArray();
		while (!stack.isEmpty()) {
			int currentData = stack.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > currentData) {
				stack.push(tempStack.pop());
			}
			tempStack.push(currentData);
		}
		return tempStack;
	}

	public static void printStack(StackUsingArray stack) {
		int top = stack.top;
		if (top >= 0) {
			System.out.println("Elements of stacks are:");
			for (int i = 0; i <= top; i++) {
				System.out.println(stack.stack[i]);
			}
		}
	}
}
