package acom.recursion.basic;
//Print natural number of the given number
//1,2,3,4,5,6,
public class DPrintNaturalNumber {
	public static void main(String[] args) {
		printNaturalNumer(5);
	}

	public static void printNaturalNumer(int num) {
		// Base Case
		if (num == 0)
			return;

		System.out.println(num);
		
		// Small Answer
		printNaturalNumer(num - 1);

		return;
	}
}
