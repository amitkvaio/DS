package amit.kumar.recursion;
//Check if a number is a palindrome using recursion
public class JPalindromeCheck {
	public static void main(String[] args) {
		System.out.println(palindromeCheck(101));
		System.out.println(palindromeCheck(12321));
		System.out.println(palindromeCheck(102030));
	}
	
	public static boolean palindromeCheck(int num) {
		int rev = reverse(num, 0);
		return rev == num;
	}
	
	public static int reverse(int num, int rev) {
		if(num == 0 ) {
			return rev;
		}
		rev = rev * 10 + num %10;
		return reverse(num/10, rev);
	}
}
