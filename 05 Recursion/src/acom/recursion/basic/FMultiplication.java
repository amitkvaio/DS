package acom.recursion.basic;

public class FMultiplication {
	public static void main(String[] args) {
		int num1 = 9;
		int num2 = 5;
		int mul = multiplication(num1, num2);
		System.out.println(mul);
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
}
