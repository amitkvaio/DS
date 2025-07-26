package amit.kumar.recursion;

import java.util.Stack;

public class RSortAStack {
	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(5);
		stack.push(3);
		stack.push(9);
		stack.push(7);
		stack.push(4);
		stack = sort(stack);

		while (!stack.empty()) {
			int element = stack.pop();
			System.out.print(element + "->");
		}
	}

	private static Stack<Integer> sort(Stack<Integer> stack) {
		if (stack.size() == 1) {
			return stack;
		}

		int temp = stack.pop();
		stack = sort(stack);
		stack = insert(stack, temp);
		return stack;
	}

	private static Stack<Integer> insert(Stack<Integer> stack, int temp) {
		if (stack.empty()) {
			stack.push(temp);
			return stack;
		} else if (stack.peek() <= temp) {
			stack.push(temp);
			return stack;
		}
		int temp1 = stack.pop();
		stack = insert(stack, temp);
		stack.push(temp1);
		return stack;
	}
}
