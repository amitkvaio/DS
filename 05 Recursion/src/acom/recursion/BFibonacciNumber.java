package acom.recursion;
//program to calculate the nth number of the fibonacci series
public class BFibonacciNumber {
	public static void main(String[] args) {
		int n = 7;
		int fibo = fib(n);
		System.out.println("Fibonacci Number is::" + fibo);
	}

	public static int fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		int out1 = fib(n - 1);
		int out2 = fib(n - 2);
		return out1 + out2;
	}
}

//0 1 -------- 1 2 3 5 8 13 21 34