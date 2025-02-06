package acom.recursion.basic;

public class FMultiplication {
	public static void main(String[] args) {
		int num1 = 9;
		int num2 = 5;
		System.out.println(multiplication(num1, num2));
		System.out.println(multiplication_(num1, num2));
	}
	
	public static int multiplication(int num1 , int num2) {
		//Base Case
		if(num2==0) {
			return 0;
		}
		
		//SmallAns - Assumption
		int smallAns = multiplication(num1, num2-1);
		
		//Calculation
		return num1 + smallAns;
	}

	public static int multiplication_(int num1 , int num2) {
		if(num2==0) {
			return 0;
		}
		return num1 + multiplication_(num1, num2-1);
	}
}
