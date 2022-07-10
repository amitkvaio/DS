package leet.code.general;

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. 
	The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. 
	The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

--Reverse Each world
--Reverse Complete world

*/
public class OReverseEachWorkd {

	public static void main(String[] args) {
		String str1 = "the sky is blue";
		String str2 = "hello world";
		System.out.println(reverseWords(str1));
		System.out.println(reverseWords(str2));

	}

	public static void reverse(char[] A, int begin, int end) {
		char ch;
		while (begin <= end) {
			ch = A[begin];
			A[begin] = A[end];
			A[end] = ch;
			begin++;
			end--;
		}
	}

	public static String reverseWords(String str) {
		/// step 1
		int begin = 0;
		int end = 0;
		char[] A = str.toCharArray();
		while (end < A.length) {
			if (A[end] == ' ') {
				reverse(A, begin, end - 1);
				end++;
				begin = end;
			} else {
				end++;
			}
		}
		reverse(A, begin, end - 1); /// last word
		reverse(A, 0, A.length - 1); /// reversing complete string
		return new String(A);
	}
}
