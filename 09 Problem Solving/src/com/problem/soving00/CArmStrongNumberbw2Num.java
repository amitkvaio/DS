//Armstrong Numbers between two integers
package com.problem.soving00;

public class CArmStrongNumberbw2Num {
	public static void main(String[] args) {
		int low = 100;
		int high = 999;
		armStrongNumberBw2Number(low, high);
	}
	
	public static void armStrongNumberBw2Number(int low, int high) {
		for (int i = low + 1; i <= high; i++) {
			// Find the number of digit of a given number
			int num = i;
			int digitCount = 0;
			while (num > 0) {
				num = num / 10;
				digitCount++;
			}
			num = i;
			int revNum = 0;
			while (num > 0) {
				int rem = num % 10;
				revNum = (int) (revNum + Math.pow(rem, digitCount));
				num = num / 10;
			}

			if (i == revNum) {
				System.out.println(i);
			}
		}
	}
}
