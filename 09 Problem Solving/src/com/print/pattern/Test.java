package com.print.pattern;

public class Test {
	public static void main(String[] args) {
		int num =111;
		int reverse =0;
		while(num > 0) {
			int rem = num % 10;
			reverse = reverse * 10 + rem;
			num = num /10;
		}
		System.out.println(reverse);
		
		if(num == reverse) {
			System.out.println("Palindrom");
		}else {
			System.out.println("not palindrom");
		}
	}
}
