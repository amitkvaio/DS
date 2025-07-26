package amit.kumar.recursion;

//Write the table for the given number
public class MGemerateTableOfAGivenNumber {
	public static void main(String[] args) {
		getTable(5);
		System.out.println("###############");
		getTable(15);
		System.out.println("################");
		getTable(25);
	}

	 

	public static void getTable(int num) {
		getSolution(num, 1 , 0);
	}

	private static void getSolution(int num, int factor, int res) {
		if (factor == 11) {
			return;
		}
		res = res + num;
		System.out.println(res);

		getSolution(num, (factor + 1), res);
	}
}
