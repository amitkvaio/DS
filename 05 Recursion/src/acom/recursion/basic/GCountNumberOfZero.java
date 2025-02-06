package acom.recursion.basic;

//Count total number of zero present in the given number
public class GCountNumberOfZero {
	public static void main(String[] args) {
		int number = 10203040;
		int zeroCount = countZeros(number);
		System.out.println("Total number of zeros in " + number + " is: " + zeroCount);
	}

	// Recursive function to count zeros
	public static int countZeros(int n) {
		// Base case: if n is 0 and it's the only digit, count it
		if (n == 0) {
			return 1;
		}

		// Base case: if n has only one digit left, return 0 if it's not zero
		if (n < 10) {
			return 0;
		}

		// Check last digit and recursively process the remaining digits
		if (n % 10 == 0) {
			return 1 + countZeros(n / 10);
		} else {
			return countZeros(n / 10);
		}
	}
}
/*
Explanation

    Base Case 1: If n == 0 (and it's the only digit), return 1.
    Base Case 2: If n is a single digit (except 0), return 0.
    Recursive Step:
        Check the last digit (n % 10).
        If it's 0, add 1 and call countZeros(n / 10).
        Otherwise, call countZeros(n / 10) without adding.
        
countZeros(10203040) -> 1 + countZeros(1020304)
countZeros(1020304)  -> countZeros(102030)
countZeros(102030)   -> 1 + countZeros(10203)
countZeros(10203)    -> countZeros(1020)
countZeros(1020)     -> 1 + countZeros(102)
countZeros(102)      -> countZeros(10)
countZeros(10)       -> 1 + countZeros(1)
countZeros(1)        -> 0
  

*/