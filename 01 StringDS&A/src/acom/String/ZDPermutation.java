package acom.String;
/*
Find all Permutations of a String in java

*/
public class ZDPermutation {
	public static void main1(String[] args) {
		permutation("", "ABC");
	}
	
	
	 // Method to recursively generate permutations
    public static void generatePermutations(String str, String permutation) {
        // Base case: if the string is empty, print the permutation
        if (str.isEmpty()) {
            System.out.println("Perm::" +permutation);
            return;
        }

        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {
            // Choose a character
            char ch = str.charAt(i);

            // Form a substring without the chosen character
            String remaining = str.substring(0, i) + str.substring(i + 1);
            System.out.println(str + " : " + permutation + " : "  + ch + " : " + remaining);

            // Recur with the remaining characters and current permutation
            generatePermutations(remaining, permutation + ch);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("All permutations of " + str + " are:");
        generatePermutations(str, "");
    }

	public static void permutation(String perm, String word) {
		if (word.isEmpty()) {
			System.out.println(perm + word);
		} else {
			for (int i = 0; i < word.length(); i++) {
				permutation(perm + word.charAt(i), 
						word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
	}
}
