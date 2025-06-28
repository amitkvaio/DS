package acom.stack.problem;

import java.util.Stack;

//Prefix to PostFix conversion
public class FPreFixToPostFixConversion {
	public static void main(String[] args) {
		String prefix = "*+AB-CD";
		String postfix = prefixToPostfixConversion(prefix);
		System.out.println("Postfix:::::"+postfix);
	}
	
	public static String prefixToPostfixConversion(String str) {
		if (str == null) {
			return null;
		}
		 
		Stack<String> stack = new Stack<String>();
		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			if (isOperator(c)) {
				String op1 = stack.pop();
				String op2 = stack.pop();
				String tempOut = op1 + op2 + c;
				stack.push(tempOut);
			} else {
				stack.push(c + "");
			}
		}
		return stack.pop();
	}
	
	public static boolean isOperator(char ch) {
	    return "+-*/%^".indexOf(ch) >= 0;
	}
}
/*
Prefix --> *+AB-CD
Postfix --> AB+CD-*

Algoritham for prefix to postfix conversion
*****************************************
1.	Read the prefix expression from right to left
2.  If the symbol is an operand, push it onto the stack.
3.  If the sysmbol is an operator, then pop two operands from the stack 
	create a string by concatenating the two operands and the operator
	between them
	String = (Operand1 + operand2 + operator).
	Push the resultant string back to the stack.
4.  Repeate above steps 2 and 3 until the end of the prefix expression is reached.
5.  The final string on the stack is the infix expression. 

TC : O(n)
SC : O(N)
*/
