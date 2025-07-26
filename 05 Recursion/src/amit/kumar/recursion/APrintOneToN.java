package amit.kumar.recursion;
//Function to print numbers from 1 to n using recursion
public class APrintOneToN {
	public static void main(String[] args) {
		printOneToN(7);
	}
	
	public static void printOneToN(int n) {
		//Base Case
		if (n == 0) {
			return;
		}
		
		//Induction Hypothesis:
		printOneToN(n -1);
		
		// builds solution step-by-step 
		System.out.println(n);
	}
}
