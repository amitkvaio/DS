package leet.code.general;

//Excel sheet column number
public class F {
	public static void main(String[] args) {
		String column = "ZZ";
		int sum = 0;
		int pow = 1;

		for (int i = column.length() - 1; i >= 0; i--) {
			System.out.println(column.charAt(i) - 64);
			sum = sum + (column.charAt(i) - 64) * pow;
			pow = pow * 26;
		}
		System.out.println("Expected Column is::" + sum);
	}
}
