package com.recursion;


public class CFabonacci {
	public static void main(String[] args) {
		System.out.println(fabonacci(7));
	}
	
	public static int fabonacci(int n) {
		//base case
		if(n==0) 
			return 0;
		
		if(n==1)
			return 1 ;
		
		return fabonacci(n-1) + fabonacci(n-2);
	}
}
