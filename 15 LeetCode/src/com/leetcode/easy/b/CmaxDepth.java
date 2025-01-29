package com.leetcode.easy.b;

import java.util.Stack;

//29. Maximum Nesting Depth of the Parentheses | 2 Approaches | Leetcode 1614
public class CmaxDepth {
	public static void main(String[] args) {
		System.out.println(maxDepthUsingStack("(1+(2*3)+((8)/4))+1"));//3
		System.out.println(maxDepthUsingStack("(1)+((2))+(((3)))"));//3
		System.out.println(maxDepthUsingStack("()(())((()()))"));//3
		System.out.println("**************************************");
		System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));//3
		System.out.println(maxDepth("(1)+((2))+(((3)))"));//3
		System.out.println(maxDepth("()(())((()()))"));//3
	}
	
	//Approach-1 (using stack)
	//T.C : O(n)
	//S.C : O(n)
	
	public static int maxDepthUsingStack(String s) {
		int result = 0;
		Stack<Character> st = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				st.push(ch);
			} else if (ch == ')') {
				st.pop();
			}
			result = Math.max(result, st.size());
		}

		return result;
	}
	
	//Approach-2 (using constant space)
	//T.C : O(n)
	//S.C : O(1)
	public static int maxDepth(String s) {
        int result = 0;
        int openBrackets = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openBrackets++;
            } else if (ch == ')') {
                openBrackets--;
            }
            
            result = Math.max(result, openBrackets);
        }
        return result;
    }
}

/*
1641. Maximum Nesting Depth of the Parentheses.

Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

 

Example 1:

Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.

Example 2:

Input: s = "(1)+((2))+(((3)))"

Output: 3

Explanation:

Digit 3 is inside of 3 nested parentheses in the string.

Example 3:

Input: s = "()(())((()()))"

Output: 3

 

Constraints:

    1 <= s.length <= 100
    s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
    It is guaranteed that parentheses expression s is a VPS.


*/
