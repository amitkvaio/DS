package amit.kumar.recursion;
//Reverse a number using recursion
public class IReverseANumber {
	public static void main(String[] args) {
		System.out.println(reverseNumber(123));
		System.out.println(reverseNumber(10203));
		System.out.println(reverseNumber(12345));
	}
	
	public static int reverseNumber(int num) {
		 return solution(num, 0);
	}
	
	public static int solution(int num, int rev) {
		if (num == 0) {
			return rev;
		}
		int rem = num % 10;
		rev = rev * 10 + rem;
		return solution((num / 10), rev);
	}
}
