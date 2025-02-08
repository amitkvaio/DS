package com.recursion;

public class BStringReverse {
	public static void main(String[] args) {
		reverse("amitkumar", 0);
	}
	
	public static void reverse(String str, int idx) {
		System.out.println(idx+"==="+str.length());
		//base case
		if(idx >= str.length())
			return;
		reverse(str,idx + 1);
		System.out.println(str.charAt(idx));
	}
}
