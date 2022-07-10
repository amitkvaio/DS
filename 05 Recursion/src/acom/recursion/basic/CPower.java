package acom.recursion.basic;
//calculate the power of a number using a recursive function in Java
public class CPower {
	public static void main(String[] args) {
		int num = 5;
		int pow = 5;
		int ans = power(num, pow);
		System.out.println(ans);
	}

	public static int power(int num, int pow) {
		// Base Case
		if (pow == 0) {
			return 1;
		}
		// Assumption
		int smallAns = power(num, pow - 1);

		// Calculation
		return num * smallAns;
	}
}
