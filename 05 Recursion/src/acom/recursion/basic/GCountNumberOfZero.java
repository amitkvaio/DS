package acom.recursion.basic;

//Count total number of zero present in the given number
public class GCountNumberOfZero {
	public static void main(String[] args) {
		int num = 120506;
		int countZero = countNumerOfZeros(num);
		System.out.println(countZero);
	}

	public static int countNumerOfZeros(int num) {
		// Base Case
		if (num == 0) {
			return 0;
		}

		// Assumption
		int smallAns = countNumerOfZeros((num - 1) / 10);

		// Calculation
		int lastDigit = num % 10;
		if (lastDigit == 0) {
			return smallAns + 1;
		} else {
			return smallAns;
		}
	}
}
