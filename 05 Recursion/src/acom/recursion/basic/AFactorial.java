package acom.recursion.basic;

public class AFactorial {
	public static void main(String[] args) {
		int fact = factorial(5);
		System.out.println("Factorial : "+fact);
	}
	
	public static int factorial(int n) {
		//Base Case 
		if(n==0) {
			return 1;
		}
		
		//Assumption - for the small Ans
		int smallAns = factorial(n-1);
		
		//Calculation
		return n*smallAns;
	}
}


//Factorial Example