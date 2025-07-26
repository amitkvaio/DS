package amit.kumar.recursion;
//Calculate the factorial of a number
public class DFactorial {
	public static void main(String[] args) {
		System.out.println(getFactorial(5));
	}
	
	public static int getFactorial(int n) {
		if (n == 1) {
			return n;
		}
		return n * getFactorial(n-1);
	}
}
