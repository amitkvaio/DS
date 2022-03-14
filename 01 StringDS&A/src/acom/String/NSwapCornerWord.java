//Swap corner words and reverse middle characters
package acom.String;

import java.util.Arrays;
import java.util.Iterator;

public class NSwapCornerWord {
	public static void main(String[] args) {
		String str = "Hello World GFG Welcomes You";
		System.out.println(str);
		System.out.println(reverse1(str));
		//reverse1(str);
	}

	public static String reverse(String str) {
		String first = "", last = "";
		int m = 0;
		int n = 0;
		// For getting the first string
		for (int i = 0; i < str.length();) {
			while (str.charAt(i) != ' ') {
				first = first + str.charAt(i);
				i++;
			}
			m = i;
			break;
		}
		// System.out.println("First:"+first);
		// For getting the last string
		for (int j = str.length() - 1; j > m;) {
			while (str.charAt(j) != ' ') {
				last = str.charAt(j) + last;
				j--;
			}
			n = j;
			break;
		}
		String result = "";
		for (int i = n; i > m; i--) {
			result = result + str.charAt(i);
		}
		result = last + " " + result + " " + first;
		return result;
	}
	
	public static String reverse1(String str) {
		String[] wordsArr = swap(str.split("\\s"));
		String output =wordsArr[0];
		for (int i = 1; i < wordsArr.length-1; i++) {
			wordsArr[i] = reverseUsingRecurstion(wordsArr[i]); 
			output = output +" "+wordsArr[i];
		}
		return output+" "+wordsArr[wordsArr.length-1];
	}
	
	public static String[] swap(String[] wordsArr) {
		String temp = wordsArr[0];
		wordsArr[0] = wordsArr[wordsArr.length-1];
		wordsArr[wordsArr.length-1] = temp;
		return wordsArr;
	}
	
	public static String reverseUsingRecurstion(String str) {
		if (str.length() < 2) {
			return str;
		}
		return reverseUsingRecurstion(str.substring(1))+str.charAt(0);
	}

}
