package acom.stack.problem;

import java.util.Stack;

//Mathematics expression should be given and it will give the result.
//Similar to Postfix to infix conversion, Reading happen left to right.

public class GPostFixEvaluation {
	public static void main(String[] args) {
		String postfix = "35*62/+4-"; // Example postfix expression
		int result = evaluatePostFix(postfix);
		System.out.println("Result: " + result);
	}

	public static int evaluatePostFix(String postfix) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {
			char ch = postfix.charAt(i);

			// If the character is an operand (digit), push it onto the stack
			if (Character.isDigit(ch)) {
				stack.push(ch - '0'); // Convert char to int and push
			} else {
				// Otherwise, the character is an operator
				int x2 = stack.pop();
				int x1 = stack.pop();

				// Perform the operation based on the operator
				int result = 0;
				switch (ch) {
				case '+':
					result = x1 + x2;
					break;
				case '-':
					result = x1 - x2;
					break;
				case '*':
					result = x1 * x2;
					break;
				case '/':
					result = x1 / x2;
					break;
				default:
					throw new IllegalArgumentException("Invalid operator: " + ch);
				}
				stack.push(result); // Push the result of operation back onto the stack
			}
		}
		// The final result will be the only item remaining in the stack
		return stack.pop();
	}
}
/*
TC : O(n)
SC : O(n)


Postfix Expression: "35*62/+4-"
Postfix Evaluation:
    Step 1: Push 3 → Stack: [3]
    Step 2: Push 5 → Stack: [3, 5]
    Step 3: * → Pop 5 and 3, calculate 3 * 5 = 15, push 15 → Stack: [15]
    Step 4: Push 6 → Stack: [15, 6]
    Step 5: Push 2 → Stack: [15, 6, 2]
    Step 6: / → Pop 2 and 6, calculate 6 / 2 = 3, push 3 → Stack: [15, 3]
    Step 7: + → Pop 3 and 15, calculate 15 + 3 = 18, push 18 → Stack: [18]
    Step 8: Push 4 → Stack: [18, 4]
    Step 9: - → Pop 4 and 18, calculate 18 - 4 = 14, push 14 → Stack: [14]
    Final result: 14
Infix Equivalent
*****************
Infix : "(((3 * 5) + (6 / 2)) - 4)"
*/