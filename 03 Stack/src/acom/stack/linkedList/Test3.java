package acom.stack.linkedList;

import acom.stack.problem.AStack;

public class Test3 {
	public static void main(String[] args) {
		String str1 = "{()}[]";
		String str2 ="({[]})(";
		boolean status=chekPrenthesis(str2);
		if(status) {
			System.out.println(str2 +" is balanced!!");
		}else {
			System.out.println(str2 +" is not balanced!!");
		}
		
	}
	
	public static boolean chekPrenthesis(String str) {
		char[] ch = str.toCharArray();
		AStack aStack = new AStack(50);
		for (char current : ch) {
			if(current=='(' || current=='{' || current=='[' ) {
				aStack.push(current);
			}
			
			if (current == ')' || current == '}' || current == ']') {
				if(aStack.isEmpty()) {
					return false;
				}
				
				char last = aStack.peek();
				if(current==')' && last=='('||current=='}' && last=='{' || current==']'&& last=='[') {
					aStack.pop();
				}else {
					return false;
				}
			}
		}
		return aStack.isEmpty();
	}
}
