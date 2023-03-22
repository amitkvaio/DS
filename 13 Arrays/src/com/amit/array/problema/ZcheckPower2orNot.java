package com.amit.array.problema;
//check given number is power of 2 or not
public class ZcheckPower2orNot {
	public static void main(String[] args) {
		int num =64;
		boolean checkStatus = checkPowerOf2(num);
		System.out.println("Given number::"+num +" is the power of 2 ::"+checkStatus);
		check(num);
	}
	
	private static void check(int num) {
		 int cal =2;
		 boolean flag = false;
		 while(cal <=num){
			 if(cal == num) {
				 flag = true;
				 System.out.println("Yes give number is power of 2");
				 break;
			 }else {
				 cal = cal *2;
			 }
		 }
		 if(!flag) {
			 System.out.println("Given number is not a power of 2");
		 }
		
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
