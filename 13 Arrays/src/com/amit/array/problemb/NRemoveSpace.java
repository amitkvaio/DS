package com.amit.array.problemb;

import java.util.Scanner;
//Remove space from the given string
public class NRemoveSpace {
	public static void main(String[] args) {
		String str1 = "Amit kumar ranchi";
		String str2 = "Hello world I am here";
		String out = str1.replaceAll(" ", "");
		System.out.println(out);
		removeSpace(str2);
		System.out.println("**************");
		removeSpace_(str2);
	}

	public static void removeSpace(String str) {
		String r = "";
		Scanner sc = new Scanner(str);
		while (sc.hasNext()) {
			r += sc.next();
		}
		System.out.println(r);
	}
	
	public static void removeSpace_(String str) {
	    for (char c : str.toCharArray()) {
	        if (c != ' ')
	            System.out.print(c);
	    }
	}
}
