package com.dds;

public class LLexicographicallySmallerCheck {
	private static boolean isLexicographicallySmaller(String a, String b) {
	    
		if (b == null) return true; // If b is null, a is always smaller
	    int len = Math.min(a.length(), b.length()); // Get the shorter length

	    for (int i = 0; i < len; i++) { // Compare character by character
	        if (a.charAt(i) < b.charAt(i)) return true;  // 'a' is smaller
	        if (a.charAt(i) > b.charAt(i)) return false; // 'b' is smaller
	    }
	    return a.length() < b.length(); // If all characters are same, shorter word is smaller
	}
	public static void main(String[] args) {
		System.out.println(isLexicographicallySmaller("apple", "banana"));
		System.out.println(isLexicographicallySmaller("dog", "door"));
		System.out.println(isLexicographicallySmaller("apple", "app"));
	}

}

/*
Understanding Lexicographical Order
Lexicographical order is dictionary order—the way words are arranged in a dictionary. It follows these rules:

Compare character by character:
    The first different character determines the order.
    The character with a smaller ASCII value comes first.

If one word is a prefix of another:
    The shorter word comes first.
    Example: "apple" comes before "apples".

ASCII value comparison:
    'a' (97) < 'b' (98) → "apple" comes before "banana".
    'Z' (90) < 'a' (97) → Uppercase letters come before lowercase.
*/