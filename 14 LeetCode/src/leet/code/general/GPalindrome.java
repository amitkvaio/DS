package leet.code.general;
/*
Given a string, determine if it is a palindrome,
considering only alphanumeric characters and ignoring
cases.
input : "A man, a plan, a canal: Panama"
output: true

input :"race a car"
output: false


*/
public class GPalindrome {
	public static void main(String[] args) {
		String input = "A man, a plan, a canal: Panama".toLowerCase();
		System.out.println(palindromeCheck(input));
	}
	
	public static boolean palindromeCheck(String input) {
		System.out.println(input);
		int start = 0;
		int end = input.length()-1;
		while(start<=end) {
			while(start < end && !checkChracter(input.charAt(start)))
				start++;
			
			while(start < end && !checkChracter(input.charAt(end)))
				end--;
			
			if(input.charAt(start)!=input.charAt(end))
				return false;
			
			start++;
			end--;
		}
		return true;
	}
	
	public static boolean checkChracter(char ch) {
		return Character.isAlphabetic(ch);
	}
}
