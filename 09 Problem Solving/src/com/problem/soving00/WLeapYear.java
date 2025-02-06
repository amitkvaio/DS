package com.problem.soving00;

public class WLeapYear {
	public static void main(String[] args) {
		int[] testYears = { 1800, 1900, 2000, 2021, 2024, 2025 };
		for (int year : testYears) {
			System.out.println(year + " is a leap year? " + isLeapYear(year));
		}
	}
	
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}
}
/*
Check if the year is divisible by 4 but not 100, DISPLAY "leap year"
Check if the year is divisible by 400, DISPLAY "leap year"
*/