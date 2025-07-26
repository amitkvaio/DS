package amit.kumar.recursion;
//Find the Nth Fibonacci number
public class EFibonacciNumber {
	public static void main(String[] args) {
		System.out.println(getNthFibonacciNumber(5));
		System.out.println(5/10);
		System.out.println(4/10);
		System.out.println(5/10);
	}
	
	public static int getNthFibonacciNumber(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return getNthFibonacciNumber(n - 1) + getNthFibonacciNumber(n - 2);
	}
}