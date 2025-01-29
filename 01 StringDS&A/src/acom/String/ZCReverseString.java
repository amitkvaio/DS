package acom.String;
/*
Java program to reverse a String
There are many ways to do reverse a String in java, some of them are:
*/
public class ZCReverseString {
	
	public static void main(String[] args) {
		String str = "amitkumar";
		System.out.println("Using For loop");
		reverseUsingForLoop(str);
		System.out.println("Using recursive function");
		String reverse=recursiveReverse(str);
		System.out.println(reverse);
		System.out.println("Using For String Builder");
		reverseUsingSringBuilder(str);
	}
	
	//Using For loop
	public static void reverseUsingForLoop(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        System.out.println("Reverse of java2blog is: " + reverse);
	}
	
	//Using Recursion
	public static String recursiveReverse(String orig) {
		System.out.println(orig);
		if (orig.length() == 1)
			return orig;
		else
			//return orig.charAt(orig.length() - 1) + recursiveReverse(orig.substring(0, orig.length() - 1));
			return recursiveReverse(orig.substring(1)) + orig.charAt(0);
	}
	
	//using StringBuilder
	public static void reverseUsingSringBuilder(String str) {
		StringBuffer sb = new StringBuffer(str);
        System.out.println("Reverse of java2blog is:" + sb.reverse());
	}
}
