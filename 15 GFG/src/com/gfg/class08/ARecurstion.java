package com.gfg.class08;

public class ARecurstion {
	
	public static void main(String[] args) {
		int x = 5;
		int result = fact(x);
		System.out.println("Factorial of : " + x + " is: " + result);
	}
	
	static int fact(int n) {
		//Base case
		if (n == 0)
			return 1;
		
					//Breaking into smaller sub-problems
		return n * fact(n - 1);

	}
	
}
/*
Recursion:-
-----------
	When a function calls itself
		function dream(){
			System.out.println("Dreaming!");
			dream();
		}
	What is base case?
	------------------
		Base case is a subproblem that we know the
		Answer in advance.
	When to use Recursion ?
	-----------------------
		When a given problem can be broken
		down into smaller subproblems.
	
		Base case should be present.
		Base cases are reached.
	
*/
