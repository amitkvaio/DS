package acom.recursion.basic;
//program to calculate the nth number of the fibonacci series
public class BFibonacciNumber {
	public static void main(String[] args) {
		int n = 6;
		int fibo = fib(n);
		System.out.println("Fibonacci Number is::" + fibo);
	}

	public static int fib(int n) {
		//Base case
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		/*
		if(n==0||n==1) 
			return n;
		*/
		/*
		if(n<=1) {
			return n;
		}
		*/
		//Assumption
		int out1 = fib(n - 1);
		int out2 = fib(n - 2);
		
		//calculation
		return out1 + out2;
	}
}

//0 1 -------- 1 2 3 5 8 13 21 34