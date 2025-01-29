//Check if a number is a power of another number
package bcom.Arrays2;

public class DPowerOfAnotherNumber {
	public static void main(String[] args) {
		boolean ispower = isPower(625, 25);
		if(ispower) {
			System.out.println("Given number is power of another number !!");
		}else {
			System.out.println("Given number is not power of another number !!");
		}
		usingMultiplication(5, 625);
	}

	public static boolean isPower(int x, int y) {
		if (x < 1 || y <= 1) {
			return false;
		}

		while (x % y == 0) {
			x = x/y;
		}
		return x == 1;
	}
/*
Input validation: If x is less than 1 or y is less than or equal to 1, 
	We return false (e.g., 0 or negative numbers or 1 cannot be a power of another number).
Division loop: We repeatedly divide x by y as long as x is divisible by y.
Result check: If x becomes 1 after the divisions, then x is a power of y.
*/

	public static void usingMultiplication(int x, int y) {
		if (x > 0 && x == y)
			System.out.println("Given number is power of 1 of the first number !!");
		int pow = 1;
		while (pow < y)
			pow = pow * x;
		if (pow == y)
			System.out.println("Given number is power of another number !!");
		else
			System.out.println("Given number is not power of another number !!");
	}
}
