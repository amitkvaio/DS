package leet.code.general;

//Find the length of last word
public class ALastWordLength {
	public static void main(String[] args) {
		String str ="Ranchi is the capital city of Jharkhand";
		int lastWordLength = getLastWordLength(str);
		System.out.println("Length of the last word is::"+lastWordLength);
		System.out.println("Done");
	}

	private static int getLastWordLength(String str) {
		int n = str.length();
		int count =0;
		int i=0;
		while (i < n) {
			if (str.charAt(i) != ' ') {
				i++;
				count++;
			} else {
				while (str.charAt(i) == ' ') {
					i++;
				}

				if (i == n) {
					return count;
				} else {
					count = 0;
				}
			}
		}
		return count;
	}
}
