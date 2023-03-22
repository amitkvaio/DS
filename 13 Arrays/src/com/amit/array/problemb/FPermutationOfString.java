package com.amit.array.problemb;

public class FPermutationOfString {
	public static void main(String[] args) {
		String str = "abc";
		purmutation(str, "");
	}
	
	public static void purmutation(String str, String ans) {
		if(str.length()==0) {
			System.out.println(ans);
			return;
		}
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			//System.out.println(str.substring(0, i) + "\t" + str.substring(i + 1) + "\t" + ans);
			String st = str.substring(0,i)+str.substring(i+1);
			purmutation(st, ans+ch);
		}
	}
}
