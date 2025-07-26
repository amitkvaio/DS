package amit.kumar.recursion;
//Reverse a string using recursion
public class NReverseAString {
	public static void main(String[] args) {
		 System.out.println(getReverseString("Amit"));
		 System.out.println(getReverseString("Kumar"));
		 System.out.println(getReverseString("Jharkhand"));
		 
	}
	
	public static String getReverseString(String str) {
		if (str.length() == 0) {
			return str;
		}
		char lastChar = str.charAt(str.length() - 1);
		return lastChar + getReverseString(str.substring(0, str.length() - 1));
	}
}
