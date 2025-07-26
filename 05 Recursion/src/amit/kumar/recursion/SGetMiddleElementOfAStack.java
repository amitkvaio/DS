package amit.kumar.recursion;

import java.util.Stack;

/*
Get middle elements of the stack using recursion
if stack is even size return n/2
in case of odd size return n/2 +1
*/
public class SGetMiddleElementOfAStack {
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
		
		System.out.println("Middle Element stack1: " + getMiddle(stack1, stack1.size()));
		System.out.println("Middle Element stack2: " + getMiddle(stack2, stack2.size()));
		System.out.println(stack1);
		System.out.println(stack2);
	}
	
	public static int getMiddle(Stack<Integer> stack, int size) {
		
		if(stack.isEmpty()) {
			return -1;
		}
		
		// Calculate the middle position
		int middleValue = size % 2 == 0 ? size / 2 : (size / 2) + 1;
		
		// Call recursive helper method with initial result as 0
		return getSolution(stack, middleValue, 0);
	}

	public static int getSolution(Stack<Integer> stack, int middle, int res) {
		
		if (middle == 0) {
			return res;
		}
		
		// Store the current top element as a potential middle
		res = stack.peek();
		
		// Remove the top element temporarily
		int temp = stack.pop();
		res = getSolution(stack, (middle - 1), res);
		
		// Restore the stack to its original state
		stack.push(temp);
		return res;
	}
}

/*
Time Complexity = O(N)
middle = N/2, the number of operations (pop + push) = N/2 + N/2 = N

Space Complexity (SC) : O(N)
*/
