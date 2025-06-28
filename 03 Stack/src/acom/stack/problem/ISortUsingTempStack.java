package acom.stack.problem;

import java.util.Stack;

public class ISortUsingTempStack {
	public static void main(String[] args) {
		Stack<Integer> stackCustom = new Stack<>();
		System.out.println("=================");
		stackCustom.push(30);
		stackCustom.push(10);
		stackCustom.push(20);
		stackCustom.push(40);
		
		System.out.println("=================");
		System.out.println("Before Sorting :");
		System.out.println("=================");
		System.out.println(stackCustom);
		
		Stack<Integer> sortedStack = sortStack(stackCustom);
		System.out.println("=================");
		System.out.println("After Sorting :");
		System.out.println("=================");
		System.out.println(sortedStack);
	}

	// Sort a stack using another stack
	public static Stack<Integer> sortStack(Stack<Integer> stack1) {
		// Auxilary stack
		Stack<Integer> stack2 = new Stack<>();
		
		// While stack1 is not empty
		while (!stack1.isEmpty()) {
			// Pop an element from stack1
			int temp = stack1.pop();

			// While stack2 is not empty and top of stack2 is greater than temp
			while (!stack2.isEmpty() && stack2.peek() > temp) {
				// Move elements from stack2 back to stack1
				stack1.push(stack2.pop());
			}

			// Push the current element (temp) into stack2
			stack2.push(temp);
		}
		return stack2;
	}
}
/*
	Sort a Stack using another stack
	************************************
	Let’s say,  We have two stacks, stack and tempStack.
	Pop an element currentData from stack and compare it with head of tempStack.
	If currentData it greater, push it to tempStack.
	If currentData is lesser than  head of tempStack, 
		pop an element from tempStack and push it to stack until 
		we get the element which is greater than currentData
	In the end, tempStack will be sorted stack.
*/



