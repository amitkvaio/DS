//Check Balanced Parentheses in an Expression
package acom.stack.problem;

public class BStackParentesisMatchingCheck {

	public static boolean checkParentesis(String str) {
		if (str.isEmpty()) {
			System.out.println("String Expression is empty!! ");
			return true;
		}

		AStack stack = new AStack(100);

		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			
			 /* If the current character is starting bracket,then push them in a stack  */
			
			if (current == '{' || current == '(' || current == '[') {
				stack.push(current);
			}
			
			 /* 
            Else, If the stack is not empty,
            And current character is a closing bracket
            and top character of a stack is matching open bracket
            then pop it.
          */
			
			if (current == '}' || current == ')' || current == ']') {
				if (stack.isEmpty())
					return false;

				char last = stack.peek();
				if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String str1 = "{()}[]";
		String str2 ="{[]})";
		boolean status  = checkParentesis(str2);
		if(status) {
			System.out.println("Parenthesis is balanced!!");
		}else {
			System.out.println("Parenthesis is not balaced!!");
		}
	}

}
