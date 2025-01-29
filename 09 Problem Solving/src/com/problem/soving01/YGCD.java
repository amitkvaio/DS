package com.problem.soving01;

//Gcd of two number
public class YGCD {
	public static void main(String[] args) {
		int n1 = 81;
		int n2 = 153;
		int gcd = 1;
		
		for (int i = 1 ; i < n1 && i < n2 ; i ++) {
			if(n1 % i ==0 && n2 % i ==0) {
				gcd = i;
			}
		}
		System.out.println(gcd);
		findGCD(n1, n2);
	}
	
	public static void findGCD(int n1, int n2) {
		while (n1 != n2) {
			if (n1 > n2) {
				n1 = n1 - n2;
			} else {
				n2 = n2 - n1;
			}
		}
		
		System.out.println("Gcd n1: "+n1);
		System.out.println("Gcd n2: "+n2);
		
	}
}
