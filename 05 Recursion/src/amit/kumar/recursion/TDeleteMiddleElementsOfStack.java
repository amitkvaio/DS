package amit.kumar.recursion;

import java.util.Stack;

/*
Delete Middle Elements of a stack and return the stack
*/

public class TDeleteMiddleElementsOfStack {
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push(10);
		stack1.push(50);
		stack1.push(60);
		stack1.push(90);
		stack1.push(150);
		
		Stack<Integer> stack2 = new Stack<Integer>();
		stack2.push(30);
		stack2.push(50);
		stack2.push(80);
		stack2.push(20);
		stack2.push(10);
		stack2.push(70);
		
		System.out.println("Original Arrays");
		System.out.println(stack1);
		System.out.println(stack2);
		
		System.out.println("After Deletion of middle element stack becomes");
		System.out.println(deleteMiddleElements(stack1, stack1.size()));
		System.out.println(deleteMiddleElements(stack2, stack2.size()));
		
	}

	private static Stack<Integer> deleteMiddleElements(Stack<Integer> stack, int size) {
		if (stack.isEmpty()) {
			return stack;
		}
		int n = stack.size() % 2 == 0 ? stack.size() / 2 : (stack.size()) / 2 + 1;
		return getSolution(stack, n);
	}

	public static Stack<Integer> getSolution(Stack<Integer> stack, int n) {
		if (n == 1) {
			stack.pop();
			return stack;
		}
		int temp = stack.pop();
		stack = getSolution(stack, (n - 1));
		stack.push(temp);
		return stack;
	}
}

/*
Time Complexity = O(N)
middle = N/2, the number of operations (pop + push) = N/2 + N/2 = N

Space Complexity (SC) : O(N)
*/