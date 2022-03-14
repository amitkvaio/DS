package acom.stack.problem;

import acom.stack.array.StackUsingArray;

//Mathematics expression should be given and it will give the result.
//input should be post fix
public class DPostFixEvaluation {
	public static void main(String[] args) {
		String postfxi ="35*62/+4-";
		int result  = evaluatePostFix(postfxi);
		System.out.println("Result ::"+result);
	}

	public static int evaluatePostFix(String postfix) {
		char[] postArr = postfix.toCharArray();
		StackUsingArray stack = new StackUsingArray(20);
		int i, x1, x2, result = 0;
		for (i = 0; i < postArr.length; i++) {
			//If it is operand then push into the stack else pop up and do its operation
			if (isOperand(postArr[i])) {
				stack.push(postArr[i]-'0');
				//int val=Character.getNumericValue(postArr[i]);
				//System.out.println("val::"+val);
				//stack.push(val);
			} else {
				x1 = stack.pop();
				x2 = stack.pop();
				//Second pop up element will come first as below shown
				switch (postArr[i]) {
				case '+':
					result = x2 + x1;
					stack.push(result);
					break;
				case '-':
					result = x2 - x1;
					stack.push(result);
					break;
				case '*':
					result = x2 * x1;
					stack.push(result);
					break;
				case '/':
					result = x2 / x1;
					stack.push(result);
					break;
				}
			}
		}
		return stack.pop();
	}

	// used to check whether character is operand or not
	public static boolean isOperand(char ch) {
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
			return false;
		return true;
	}
}
