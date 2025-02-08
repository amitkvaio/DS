package acom.String;
//Sort a string
public class GStringSort {
	public static void main(String[] args) {
		String str = "gfedcbaac";
		System.out.println(sortStirng(str.toLowerCase().toCharArray()));
		System.out.println(sortString(str.toLowerCase()));
	}
	
	public static String sortStirng(char[] charArray) {
		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[j] < charArray[i]) {
					swapChars(i, j, charArray);
				}
			}
		}
		return String.valueOf(charArray);
	}
	
	
    private static void swapChars(int i, int j, char[] charArray) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
    
    //The time complexity is O(n).O(1) extra space (since the character set is fixed).
	public static String sortString(String str) {
		int[] count = new int[128]; // ASCII character count array

		// Count frequency of each character
		for (char ch : str.toCharArray()) {
			count[ch]++;
		}
		// Build sorted string
		StringBuilder sortedStr = new StringBuilder();
		for (int i = 0; i < 128; i++) {
			while (count[i] > 0) { // Check if count is greater than 0
				sortedStr.append((char) i); // Append the character
				count[i]--; // Decrement count after appending
			}
		}
		return sortedStr.toString();
	}
}
