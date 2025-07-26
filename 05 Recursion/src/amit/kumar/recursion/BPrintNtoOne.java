package amit.kumar.recursion;
// Function to print numbers from n to 1 using recursion
public class BPrintNtoOne {
	public static void main(String[] args) {
		printNtoOne(10);
	}
	
    public static void printNtoOne(int n) {
        
        // 🔹 Base Case: If n is 0, stop the recursion
        // This is like the base case in mathematical induction
        if (n == 0) {
            return;
        }

        // 🔹 Print current number
        System.out.println(n);

        // 🔹 Recursive Step:
        // Assume: printNtoOne(n-1) will correctly print (n-1) to 1
        // This is the "Hypothesis of Induction" — assume function works for smaller input
        // Now: using this assumption, we build the solution for 'n'
        printNtoOne(n - 1);
    }
}
