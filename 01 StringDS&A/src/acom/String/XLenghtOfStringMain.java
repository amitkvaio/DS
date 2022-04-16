package acom.String;
/*
How to find length of string in java without using length() method
Using toCharArray

Convert string to char array using toCharArray method
Iterate over char array and incrementing length variable.

We can use StringIndexOutOfBoundsException to find length of String without using length() method. 
*/
public class XLenghtOfStringMain {
	public static void main(String args[]) {

		String helloWorld = "This is hello world";
		System.out.println("length of helloWorld string :" + getLengthOfStringWithCharArray(helloWorld));
		System.out.println("length of helloWorld string :" + getLengthOfString(helloWorld));
	}

	public static int getLengthOfStringWithCharArray(String str) {
		int length = 0;
		char[] strCharArray = str.toCharArray();
		for (char c : strCharArray) {
			length++;
		}
		return length;
	}
	
	public static int getLengthOfString(String str) {
		int i = 0;
		try {
			for (i = 0;; i++) {
				str.charAt(i);
			}
		} catch (Exception e) {

		}
		return i;
	}
}
