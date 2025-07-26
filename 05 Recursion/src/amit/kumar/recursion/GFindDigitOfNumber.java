package amit.kumar.recursion;

//Find the sum of digits of a number using recursion
public class GFindDigitOfNumber {
	public static void main(String[] args) {
		System.out.println(getSumOfDigit(123));
		System.out.println(getSumOfDigit(123456789));
		System.out.println(getSumOfDigit(556688));
	}
	
	public static int getSumOfDigit(int num ) {
		return getSolution(num, 0);
	}
	
	public static int getSolution(int n, int sum) {
		if (n == 0) {
			return sum;
		}
		sum = sum + n % 10;
		return getSolution(n / 10, sum);
	}
}
