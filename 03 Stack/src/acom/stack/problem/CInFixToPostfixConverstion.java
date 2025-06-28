package acom.stack.problem;

import java.util.Stack;

public class CInFixToPostfixConverstion {
	
	public static void main(String args[]) {
		String infix = "3*5+6/2-4";
		System.out.println(infixToPostfixConversion("A+B*(C-D)")); // Postfix = ABCD-*+
		System.out.println(infixToPostfixConversion(infix)); //Postfix =35*62/+4-
	}
	
	public static String infixToPostfixConversion(String str) {
		if (str == null) {
			return null;
		}
		// Stack to hold operator
		Stack<Character> stack = new Stack<Character>();
		StringBuilder output = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// if operand (A-Z or 0-9), add it to the result
			if (Character.isLetterOrDigit(ch)) {
				output.append(ch);
			}

			// if the character is '(' push into the stack
			else if (ch == '(') {
				stack.push(ch);
			}

			// if ch is ')' then pop from the stack until '(' is encounter
			else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					output.append(stack.pop());
				}
				// pop '(' from the stack
				stack.pop();
			}

			// if the character is an operator, pop it with higher or equal precedence
			else if (isOperator(ch)) {
				while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
					output.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		// Pop any remaining operators in the stack
		while (!stack.isEmpty()) {
			output.append(stack.pop());
		}
		return output.toString();
	}
	
	// Method to check if a character is an operator
    public static boolean isOperator(char ch) {
        return "+-*/%^".indexOf(ch) >= 0;
    }

	// Method to return the precedence of operators
	public static int precedence(char op) {
		switch (op) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '%':
			return 3;
		case '^':
			return 4;
		default:
			return -1;
		}
	}
}
/*

Infix to Postfix Logic:
***********************
    Operands (letters or digits): Directly append them to the result.
    
    Left Parenthesis (: Push it to the stack to signify that we have a sub-expression.
    
    Right Parenthesis ): Pop from the stack until we encounter the matching Left Parenthesis (. These popped operators are appended to the result.

    Operators: If the operator on top of the stack has higher or equal precedence than the current operator, pop it from the stack to the result. Then, push the current operator onto the stack.

Precedence of Operators:
************************
    Higher precedence operators (like *, /, ^) are popped before lower precedence ones (like +, -).

After the Loop:
***************** 
	Any remaining operators in the stack are popped and appended to the result.

TC : O(n)
SC : O(n)

*/
