package acom.String;

import java.util.HashSet;

/*
How to check if String has all unique characters in java.

Java Program to check if String has all unique characters Using HashSet
By using indexOf and lastIndexOf methods.

*/
public class ZBStringAllUniqueCharMain {
	public static void main(String[] args) {
		System.out.println("Apple has all unique chars : " + hasAllUniqueChars("apple"));
		System.out.println("index has all unique chars : " + hasAllUniqueChars("index"));
		System.out.println("world has all unique chars : " + hasAllUniqueChars("Banana"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Apple has all unique chars : " + hasAllUniqueCharsUsingIndex("apple"));
		System.out.println("index has all unique chars : " + hasAllUniqueCharsUsingIndex("index"));
		System.out.println("world has all unique chars : " + hasAllUniqueCharsUsingIndex("Banana"));
	}

	public static boolean hasAllUniqueChars(String word) {

		HashSet<Character> alphaSet = new HashSet<>();
		for (int index = 0; index < word.length(); index++) {
			char c = word.charAt(index);
			// If Hashset's add method return false,that means it is already present in
			if (!alphaSet.add(c))
				return false;
		}
		return true;
	}
	
	public static boolean hasAllUniqueCharsUsingIndex(String word) {
	     for(int index=0;index < word.length(); index ++)   {
	         char c =word.charAt(index);
	         if(word.indexOf(c)!=word.lastIndexOf(c))
	              return false;
	     }
	     return true;
	 }
}

