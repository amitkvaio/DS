package acom.recursion.basic;
//Print natural number of the given number
//1,2,3,4,5,6,
public class DPrintNaturalNumber {
	public static void main(String[] args) {
		System.out.println("Descending natural number order");
		printNaturalNumer(5);
		System.out.println("Ascending order number order");
		printNaturalNumer_(5);
	}

	public static void printNaturalNumer(int num) {
		// Base Case
		if (num == 0)
			return;
		
		//Descending order
		System.out.println(num);
		
		// Small Answer
		printNaturalNumer(num - 1);
	}
	
	public static void printNaturalNumer_(int num) {
		if(num==0) {
			return;
		}
		printNaturalNumer_(num-1);
		System.out.println(num);
	}
}
