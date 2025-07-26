package amit.kumar.recursion;
/*
Check if a string is a palindrome
Input: s = "abba"
Output: 1
Explanation: s is a palindrome
*/
public class QPalindromeCheck {
	public static void main(String[] args) {
		System.out.println(checkPalindrome("abba"));
		System.out.println(checkPalindrome("madam"));
	}

	private static boolean checkPalindrome(String str) {
		return solution(str, 0, str.length() - 1);
	}

	public static boolean solution(String str, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return true;
		}

		if (str.indexOf(startIndex) != str.indexOf(endIndex))
			return false;

		return solution(str, startIndex + 1, endIndex - 1);
	}
}
/*
Time and Space Complexity:
Time: O(n), where n is the length of the string.
Space: O(n) due to recursion stack.
*/