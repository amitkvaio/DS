package acom.stack.problem;

import java.util.Stack;

// Prefix to Infix conversion
public class EPreFixToInFixConversion {
	
	public static void main(String[] args) {
		String prefix = "*+AB-CD";
		String infix = prefixToInfixConversion(prefix);
		System.out.println("Infix::"+infix);
	}
	
	public static String prefixToInfixConversion(String str) {
		if (str == null) {
			return null;
		}
		 
		Stack<String> stack = new Stack<String>();
		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			if (isOperator(c)) {
				String op1 = stack.pop();
				String op2 = stack.pop();
				String tempOut = "(" + op1 + c + op2 + ")";
				stack.push(tempOut);
			} else {
				stack.push(c + "");
			}
		}
		return stack.pop();
	}
	
	
	public static boolean isOperator(char ch) {
		switch (ch) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
		case '%':
			return true;
		}
		return false;
	}
	
	public static boolean isOperator_(char ch) {
	    return "+-*/%^".indexOf(ch) >= 0;
	}
}


/*
Prefix --> *+AB-CD
Infix --> (A+B)*(C-D)

Algoritham for prefix to infix conversion
*****************************************
1.	Read the prefix expression from right to left
2.  If the symbol is an operand, push it onto the stack.
3.  If the sysmbol is an operator, then pop two operands from the stack 
	create a string by concatenating the two operands and the operator
	between them
	String = (Operand1 + operator + operand2).
	Push the resultant string back to the stack.
4.  Repeate above steps 2 and 3 until the end of the prefix expression is reached.
5.  The final string on the stack is the infix expression. 

TC : O(n)
SC : O(N)

*/
