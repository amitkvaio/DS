package leet.code.general;

import java.util.Arrays;

/*
Zig-Zag convesion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
	(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
*/
public class KZigZagConversion {
	public static void main(String[] args) {
		String str ="PAYPALISHIRING";
		zigZagConversion(str, 3);
		zigZagConversion("A", 1);
		System.out.println("****************");
		//zigZagConversion_1(str,3);
		//zigZagConversion_1("A",1);
	}
	
	public static void zigZagConversion(String str, int numOfRows) {
		String[] strArr = new String[numOfRows];
		for (int i = 0; i < strArr.length; i++) {
			strArr[i]="";
		}
		
		int row = 0;
		int step = 1;

		for (int i = 0; i < str.length(); i++) {
			System.out.println(row);
			strArr[row] = strArr[row] + Character.toString(str.charAt(i));
			if (row == 0) {
				step = 1;
			} else if (row == numOfRows - 1) {
				step = -1;
			}
			row = row + step;
			System.out.println(">>>>>");
		}
		System.out.println(Arrays.toString(strArr));
		String result ="";
		for (int i = 0; i < strArr.length; i++) {
			result = result+strArr[i];
		}
		//System.out.println(result.replaceAll("null", ""));
		System.out.println(result);
	}
	
	public static void zigZagConversion_1(String str, int numOfRows) {
		String[] strArr = new String[numOfRows];
		for (int i = 0; i < strArr.length; i++) {
			strArr[i]="";
		}
		
		for (int i = 0; i < str.length(); i++) {
			System.out.println(i%numOfRows);
			
			strArr[i % numOfRows] = strArr[i % numOfRows] + Character.toString(str.charAt(i));

		}
		String result ="";
		for (int i = 0; i < strArr.length; i++) {
			result = result+strArr[i];
		}
		//System.out.println(result.replaceAll("null", ""));
		System.out.println(result);
	}
}
