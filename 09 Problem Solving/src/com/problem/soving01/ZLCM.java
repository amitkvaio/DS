package com.problem.soving01;

public class ZLCM {
	public static void main(String[] args) {
		getLCM(72, 120);
		getLcmUsingGcd(72, 120);
	}
	
	public static void getLCM(int n1, int n2) {
		int lcm;
		
		lcm = n1 > n2 ? n1 : n2;
		while(true) {
			if(lcm % n1 == 0 && lcm % n2 == 0) {
				System.out.println("Lcm of n1=" + n1 + " and n2=" + n2 + " is :" + lcm);
				break;
			}
			lcm++;
		}
	}
	
	public static void getLcmUsingGcd(int n1, int n2) {
		int gcd = 1;
		for (int i = 1; i < n1 && i < n2; i++) {
			if (n1 % i == 0 && n2 % i == 0) {
				gcd = i;
			}
		}

		int lcm = (n1 * n2) / gcd;

		System.out.println("Lcm of n1=" + n1 + " and n2=" + n2 + " is :" + lcm);
	}
}
