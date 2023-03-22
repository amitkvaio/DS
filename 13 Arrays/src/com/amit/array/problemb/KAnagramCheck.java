package com.amit.array.problemb;
/*
Check given number is armstrong number or not.
153 = 1^3+5^3+3^3
1634 = 1^4+6^4+3^4+4^4
9474 = 9^4+4^4+7^4+4^4
54748 = 5^5+4^5+7^5+4^5+8^5                                                                                                   
*/
public class KAnagramCheck {
	public static void main(String[] args) {
		long num = 54748;
		boolean artStatus = isArgmStrongNumber(num);
		System.out.println(artStatus);
	}

	public static boolean isArgmStrongNumber(long num) {
		int digitCount = countDigit(num);
		long originalNum = num;
		int count = 1;
		long powSumEachD = 1;
		long lastD;
		long arSum = 0;
		while (num > 0) {
			lastD = num % 10;
			while (count <= digitCount) {
				powSumEachD = powSumEachD * lastD;
				count++;
			}
			arSum = arSum + powSumEachD;
			num = num / 10;
			count = 1;
			powSumEachD = 1;
		}
		if (arSum == originalNum) {
			return true;
		}
		return false;
	}

	public static int countDigit(long num) {
		int count = 0;
		while (num > 0) {
			count++;
			num = num / 10;
		}
		return count;
	}
}
