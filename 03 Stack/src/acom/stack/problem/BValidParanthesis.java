//Check Balanced Parentheses in an Expression
package acom.stack.problem;

import java.util.Stack;

public class BValidParanthesis{

	public static boolean checkParentesis(String str) {
		if (str.isEmpty()) {
			System.out.println("String Expression is empty!! ");
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		for (Character currentChar : str.toCharArray()) {
			if (currentChar == '[' || currentChar == '(' || currentChar == '{') {
				stack.push(currentChar);
			} else {
				if (stack.isEmpty())
					return false;
				else if (stack.peek() == '[' && currentChar == ']') {
					stack.pop();
				} else if (stack.peek() == '{' && currentChar == '}') {
					stack.pop();
				} else if (stack.peek() == '(' && currentChar == ')') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String str1 = "{()}[]";
		String str2 ="{[]})";
		boolean status  = checkParentesis(str1);
		if(status) {
			System.out.println("Parenthesis is balanced!!");
		}else {
			System.out.println("Parenthesis is not balaced!!");
		}
	}
}
/*
TC : O(n)
SC : O(n)
Using stack
-- Declare a character stack
-- Now traverse the string expression
	-- if the current character is starting bracket ( or { or [ then push it to the stack
	-- if we encounter closing bracket, then we will check then pop from the stack and if the
		popped character is the matching starting bracket then fine.
	-- Else return false, brackets are not valid.
-- After complete traversal, if there is some starting bracket left in the stack then not valid else valide.

*/