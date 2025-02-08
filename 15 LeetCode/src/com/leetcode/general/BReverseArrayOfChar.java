package com.leetcode.general;

import java.util.Stack;

//Reverse a array of character
public class BReverseArrayOfChar {
	public static void main(String[] args) {
		String str = "Jharkhand";
		String rev = reverse(str);
		System.out.println("Rev ::"+rev);
		System.out.println("**********Using swapping************");
		String reverse = reverseUsingSwapping(str);
		System.out.println("Reverse::"+reverse);
	}
	
	public static String reverse(String str) {
		Stack<Character> stack = new Stack<>();
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			stack.push(c);
		}
		
		
		for (int i = 0; i < ch.length; i++) {
			 ch[i] = stack.pop();
		}
		return new String(ch);
	}
	
	public static String reverseUsingSwapping(String str) {
		int first =0;
		int last = str.length()-1;
		char [] charAr = str.toCharArray();
		char temp;
		while(first < last) {
			temp = charAr[first];
			charAr[first] = charAr[last];
			charAr[last]=temp;
			first++;
			last--;
		}
		return new String(charAr);
	}
}

/*
1.use stack push all the character into the stack.
2. Pop all the character and store into the same array.

Swap first and last character from each iteration
*/