package leet.code.general;

//Excel sheet column number
public class FExcelSheetColumnNumber {
	public static void main(String[] args) {
		String column = "ABC";
		method1(column);
		method2(column);
	}

	private static void method1(String column) {
		int sum = 0;
		int pow = 1;

		for (int i = column.length() - 1; i >= 0; i--) {
			System.out.println(column.charAt(i) - 64);
			int pos = (column.charAt(i) - 64);
			sum = sum + pos * pow;
			pow = pow * 26;
		}
		System.out.println("Expected Column is::" + sum);
	}
	
	private static void method2(String column) {
		int sum = 0;
		int pow = 1;
		int charPos =0;
		for (int i = column.length() - 1; i >= 0; i--) {
			charPos=column.charAt(i) - 64;
			sum = sum + charPos * pow;
			pow = pow * 26;
		}
		System.out.println("Expected Column is::" + sum);
	}
}
