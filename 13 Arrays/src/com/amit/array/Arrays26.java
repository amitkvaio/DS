package com.amit.array;
//check given number is power of 2 or not
public class Arrays26 {
	public static void main(String[] args) {
		int num =60;
		boolean checkStatus = checkPowerOf2(num);
		System.out.println("Given number::"+num +" is the power of 2 ::"+checkStatus);
	}
	
	public static boolean checkPowerOf2(int num) {
		boolean status = false;
		while (num >= 2) {
			if (num % 2 == 0) {
				status = true;
			} else {
				status = false;
			}
			num = num/2;
		}
		return status;
	}
}
