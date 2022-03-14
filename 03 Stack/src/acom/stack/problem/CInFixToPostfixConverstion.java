package acom.stack.problem;

public class CInFixToPostfixConverstion {
	
	// used to check whether character is operand or not
	public static boolean isOperand(char ch) {
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
			return false;
		return true;
	}

	//used to get the precedence of the operator
	public static int getPredence(char x) {
		if (x == '+' || x == '-') {
			return 1;
		} else if (x == '*' || x == '/') {
			return 2;
		}
		return 0;
	}

	static String evaluatePostfix(String exp) {
		int length = exp.length();
		AStack stack = new AStack(length); // Create post fix stack
		char[] infix = exp.toCharArray();
		
		//post character array is for storing the post fix expression
		char[] postfix = new char[length];
		int j = 0, i = 0;
		
		while (i < length) {
			//Step 1 - checking if a character is operand then store into post fix character array
			if (isOperand(infix[i])) {
				postfix[j++] = infix[i++];
			} else {
				//Step 2 - if not operand and if stack is empty then push into the stack
				if (stack.isEmpty()) {
					stack.push(infix[i++]);
				//Step 3 - if the infix operator precedence is greater than top most operator precedence of the stack
				//then push into the stack
				} else if (getPredence(infix[i]) > getPredence(stack.peek())) {
					stack.push(infix[i++]);
				//Step 4 - is precedence is less then or equal then pop the stack operator and add into the post fix
				} else {
					postfix[j++] = stack.pop();
				}
			}
		}
		//Step 5 - if stack is not empty then pop it up and store into the post fix.
		while (!stack.isEmpty()) {
			postfix[j++] = stack.pop();
		}
		return String.valueOf(postfix);
	}

	public static void main(String args[]) {
		String exp = "3*5+6/2-4";
		//a+b*c-d/e : Equivalent post fix : abc*+de/-
		//a+b+c-d : Equivalent post fix : ab+c+d-
		//3*5+6/2-4 : Equivalent post fix : 3 5 * 6 2 / + 4 -
		System.out.print("The PostFix Evaluation for the Given Expression " + exp + " is: ");
		String postfix = evaluatePostfix(exp);
		System.out.println("Postfix ::"+postfix);
	}
}
