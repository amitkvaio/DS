package amit.kumar.recursion;
//Check if a number is prime using recursion
public class FCheckPrimeNumber {
	public static void main(String[] args) {
		System.out.println(checkPrimeNumber(5));
		System.out.println(checkPrimeNumber(6));
		System.out.println(checkPrimeNumber(7));
		System.out.println(checkPrimeNumber(11));
		System.out.println(checkPrimeNumber(13));
		System.out.println(checkPrimeNumber(14));
	}

	private static boolean checkPrimeNumber(int num) {
		return solution(num, num / 2, 0) == 0;
	}
	
	public static int solution(int num, int k, int count) {
		if (k == 1) {
			return count;
		}

		if ((num % k) == 0)
			count++;
		return solution(num, (k - 1), count);
	}
}
