package amit.kumar.recursion.advanced;
//A recursive function to print the string in order
//A recursive function to print the string in reverse
public class APrintRecursively {
	public static void main(String[] args) {
		print("Mumbai");
		print("Jharkhand");
		print("Ranchi");
		print("Recursion");
		System.out.println("################");
		printReverse("Mumbai");
		printReverse("Jharkhand");
		printReverse("Ranchi");
		printReverse("Recursion");
	}

	public static void print(String str) {
		if (str.length() == 0) {
			System.out.println();
			return;
		}
		System.out.print(str.charAt(0));
		print(str.substring(1));
	}

	public static void printReverse(String str) {
		if (str.length() == 0) {
			System.out.println();
			return;
		}
		char ch = str.charAt(0);
		printReverse(str.substring(1));
		System.out.print(ch);
	}
}
/*
Time Complexity (TC)
    For a string of length n, the function:
        Makes n+1 recursive calls (n characters + 1 base case).
        In each call, it:

Takes a substring → O(n) (in Java, substring() has time complexity of O(n) because it creates a new string).
Prints one character → O(1).

So overall:
Time Complexity=O(n2)
Time Complexity=O(n2)


Space Complexity (SC)
    Due to recursion, there are n+1 function calls on the stack.
    Each call uses O(1) extra space.
Space Complexity=O(n)
*/