package acom.recursion.basic;
//Calculate the number of digits in a given number
public class CountDigits {
	public static void main(String[] args) {
		int num =10002;
		int count = numberOfDigits(num);
		System.out.println(count);
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
}
