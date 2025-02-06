package acom.recursion.basic;
//Sum of n given number using recursion.
public class ESumOfGivenNumber {
	public static void main(String[] args) {
		int num =123;
		System.out.println(sumOfGivenNumber(num));
		System.out.println(sumOfGivenNumber_(num));
	}
	
	public static int sumOfGivenNumber(int num) {
		// Base Case
		if (num == 0) {
			return 0;
		}

		// SmallAns
		int smallAns = sumOfGivenNumber(num / 10);

		// Calculation
		int lastDig = num % 10;
		
		return smallAns + lastDig;
	}
	
	public static int sumOfGivenNumber_(int num) {
		if(num < 1) {
			return 0;
		}
		return sumOfGivenNumber(num / 10 ) + num %10;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
