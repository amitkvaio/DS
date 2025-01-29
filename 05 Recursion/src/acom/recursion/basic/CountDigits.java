package acom.recursion.basic;
//Calculate the number of digits in a given number
public class CountDigits {
	public static void main(String[] args) {
		int num =10002;
		int count = numberOfDigits(num);
		System.out.println(count);
		System.out.println(getNumberOfDigit(10002));
		System.out.println(getNumberOfDigitUsingTailRecursion(10002,0));
	}
	
	public static int numberOfDigits(int num) {
		// Base Case
		if (num == 0)
			return 0;
		/*
		if (num <= 1)
			return 1;
		*/
		
		//Small Answer
		int smallAns = numberOfDigits(num/10);
		
		//Calculation
		int count = smallAns + 1;
		return count;
	}
	
	//123
	public static int getNumberOfDigit(int num) {
		if(num ==0)
			return 0;
		return getNumberOfDigit(num/10) + 1;
	}
	
	// 123
	public static int getNumberOfDigitUsingTailRecursion(int num, int result) {
		if (num == 0)
			return result;
		return getNumberOfDigitUsingTailRecursion(num / 10, result + 1);
	}
}
