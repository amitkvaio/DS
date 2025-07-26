package amit.kumar.recursion;
//Count the number of digits in a number
public class HDigitInNumber {
	public static void main(String[] args) {
		System.out.println(getDigitCount(123));
		System.out.println(getDigitCount(1234500));
		System.out.println(getDigitCount(10000));
	}

	public static int getDigitCount(int num) {
		return getSolution(num, 0);
	}

	public static int getSolution(int num, int count) {
		if (num == 0) {
			return count;
		}
		if ((num % 10) >= 0) {
			count++;
		}
		return getSolution(num / 10, count);
	}
}
