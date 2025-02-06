package com.problem.soving00;

public class CArmStrongNumber {
	public static void main(String[] args) {
		int num = 153;
		checkArmStrongNumber(num);
	}
	
	public static void checkArmStrongNumber(int num) {
		int armStrong = num; 
		int sum = 0;
		while(num > 0) {
			int lastDigit = num % 10;
			//sum = sum + (lastDigit * lastDigit * lastDigit);
			sum = (int) (sum + Math.pow(lastDigit, 3));
			num = num /10;
		}
		if(sum == armStrong) {
			System.out.println(armStrong +" is ArmStrong Number!!");
		}else {
			System.out.println(armStrong + " is not ArmsStrong Number !!!");
		}
	}
}

/*
1.	An Armstrong number is a 3 digit number for 
	which sum of cube of its digits is equal to the number itself. 
An example of Armstrong number is 153 as 153= 1+ 125+27 which is equal 	to 1^3+5^3+3^3.

3-digit Armstrong Numbers:
153 → 1^3+5^3+3^3=1+125+27=153
370 → 3^3+7^3+0^3=27+343+0=370
371 → 3^3+7^3+1^3=27+343+1=371

4-digit Armstrong Numbers:
1634 → 1^4+6^4+3^4+4^4=1+1296+81+256=1634
9474 → 9^4+4^4+7^4+4^4=6561+256+2401+256=9474

List of 5-digit Armstrong numbers:
54748 → 5^5+4^5+7^5+4^5+8^5=3125+1024+16807+1024+32768=54748

N=d1^n​+d2^n​+d3^n​+...+dn^n
where d1,d2,...,dn​ are the digits of N,then N is an Armstrong number.​

*/
