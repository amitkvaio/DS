package com.coding.interview12025;

/*
 Java program to convert a camelCase string (like whatIsYourName) to an uppercase underscore-separated format 
 	(WHAT_IS_YOUR_NAME)
*/
public class CconvertToUpperUnderscore {
	public static void main(String[] args) {
		System.out.println(convertToUpperUnderscore("whatIsYourName")); // Output: WHAT_IS_YOUR_NAME
		System.out.println(convertToUpperUnderscore("helloWorldExample"));
		System.out.println(convertToUpperUnderscore("APIResponse"));
		System.out.println(convertToUpperUnderscore("my1Varia9ble123Name7comp"));
	}
	
	public static String convertToUpperUnderscore(String input) {
		//return input.replaceAll("([a-z])([A-Z])", "$1_$2").toUpperCase();
		return input.replaceAll("([a-zA-Z])", "$1_$2").toUpperCase();
	}
}
/*
Follow-up Questions and Answers:

    Q: What is the purpose of replaceAll("([a-z])([A-Z])", "$1_$2") in the program?
    A: This regular expression identifies lowercase letters ([a-z]) followed by uppercase letters ([A-Z]) and inserts an underscore (_) between them.

    Q: Why do we use .toUpperCase() in the program?
    A: The toUpperCase() method converts the entire string to uppercase as required.

    Q: What will be the output if the input is helloWorldExample?
    A: The output will be: HELLO_WORLD_EXAMPLE.

    Q: How does this program handle consecutive uppercase letters (e.g., APIResponse)?
    A: The program will convert APIResponse to A_P_I_RESPONSE. To avoid this issue, a more advanced regex can be used.

    Q: How can we modify the program to handle numbers, like myVariable123Name?
    A: We can modify the regex to consider numbers:
	input.replaceAll("([a-zA-Z])([0-9])", "$1_$2").replaceAll("([a-z])([A-Z])", "$1_$2").toUpperCase();

*/