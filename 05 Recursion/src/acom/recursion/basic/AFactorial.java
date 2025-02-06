package acom.recursion.basic;

public class AFactorial {
	public static void main(String[] args) {
		int val = 5;
		System.out.println("Factorial : "+factorial(val));
		System.out.println("Factorial : "+factorial_(val));
	}
	
	public static int factorial(int n) {
		// Base Case
		if (n == 0) {
			return 1;
		}

		// Assumption - for the small Ans
		int smallAns = factorial(n - 1);

		// Calculation
		return n * smallAns;
	}
	
	public static int factorial_(int n) {
		if(n<=0) {
			return 1;
		}
		return n * factorial(n-1);
	}
}


//Factorial Example