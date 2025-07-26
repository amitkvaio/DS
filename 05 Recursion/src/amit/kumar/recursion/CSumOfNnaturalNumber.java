package amit.kumar.recursion;

//Calculate the sum of first N natural numbers
public class CSumOfNnaturalNumber {
	public static void main(String[] args) {
		System.out.println(getSumOfNnaturalNumbers(10));
	}
	
	public static int getSumOfNnaturalNumbers(int n) {
		if (n == 1) {
			return 1;
		}
		return n + getSumOfNnaturalNumbers(n - 1);
	}
}
