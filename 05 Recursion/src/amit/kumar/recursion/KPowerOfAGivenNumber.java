package amit.kumar.recursion;
//calculate the power of a number using a recursive function in Java
//int num = 5, power = 3 output = 5 * 5 * 5 = 125
public class KPowerOfAGivenNumber {
	public static void main(String[] args) {
		System.out.println(getPowerOfANumber(5, 0));
		System.out.println(getPowerOfANumber(5, 1));
		System.out.println(getPowerOfANumber(5, 2));
		System.out.println(getPowerOfANumber(5, 3));
		System.out.println(getPowerOfANumber(5, 4));
		System.out.println(getPowerOfANumber(5, 5));
	}
	
	public static int getPowerOfANumber(int num, int power) {
		return solution(num, power, 1);
	}

	public static int solution(int num, int power, int res) {
		if (power == 0) {
			return res;
		}
		res = res * num;
		return solution(num, (power - 1), res);
	}
}
