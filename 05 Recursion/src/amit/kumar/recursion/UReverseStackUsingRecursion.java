package amit.kumar.recursion;

import java.util.Stack;

//Reverse a stack using recursion.
public class UReverseStackUsingRecursion {
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.push(5);
		stack1.forEach(x ->System.out.println(x));
		System.out.println("###############################");
		
		Stack<Integer> reverse = stackRecursion(stack1, stack1.size());
		reverse.forEach(x ->System.out.println(x));
	}
	
	public static Stack<Integer> stackRecursion(Stack<Integer> stack, int size) {

		if (stack.isEmpty()) {
			return stack;
		}
		if (size == 1) {
			return stack;
		}

		int temp = stack.pop();

		stack = stackRecursion(stack, (size - 1));
		insertElement(stack, temp);
		return stack;
	}

	public static Stack<Integer> insertElement(Stack<Integer> stack, int element) {
		if (stack.isEmpty()) {
			stack.push(element);
			return stack;
		}

		int num = stack.pop();
		stack = insertElement(stack, element);
		stack.push(num);
		return stack;
	}
}
/*
Time Complexity (TC)
stackRecursion() is called N times (once per element popped).
Each call then uses insertElement() to insert elements at the bottom, which can take up to N operations.
Time Complexity = O(N²)

Space Complexity (SC)
Each recursive call (both stackRecursion and insertElement) adds a new frame to the call stack.
In the worst case, the recursion depth reaches O(N).
Space Complexity = O(N)
*/