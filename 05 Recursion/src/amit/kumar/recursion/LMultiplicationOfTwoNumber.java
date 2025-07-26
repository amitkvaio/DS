package amit.kumar.recursion;
//Multiplication of two number.
public class LMultiplicationOfTwoNumber {
	public static void main(String[] args) {
		System.out.println(getMultiplicationOfTwoNumber(9, 5));
		System.out.println(getMultiplicationOfTwoNumber(9, 6));
		System.out.println(getMultiplicationOfTwoNumber(9, 7));
		System.out.println(getMultiplicationOfTwoNumber(9, 8));
		System.out.println(getMultiplicationOfTwoNumber(9, 0));
	}
	
	public static int getMultiplicationOfTwoNumber(int num1, int num2) {
		return getMultiplicationSolution(num1, num2, 0);
	}
	
	public static int getMultiplicationSolution(int num1, int num2, int res) {
		if (num2 == 0) {
			return res;
		}
		res = res + num1;
		return getMultiplicationSolution(num1, (num2 - 1), res);
	}
}
