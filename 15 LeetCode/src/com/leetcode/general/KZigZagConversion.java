package com.leetcode.general;

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
		//zigZagConversion(str, 3);
		//zigZagConversion("A", 1);
		System.out.println("****************");
	}
	
	public static void zigZagConversion(String str, int numOfRows) {
		
		// Edge case
        if (numOfRows == 1 || str.length() <= numOfRows) {
            return;
        }
		
		String[] strArr = new String[numOfRows];
		for (int i = 0; i < strArr.length; i++) {
			strArr[i]="";
		}
		
		int row = 0;
		int step = 1;
		
		
		int currentRow = 0;
        boolean goingDown = false;
        
        
     // Place characters
        for (char ch : str.toCharArray()) {
        	strArr[row] = strArr[row] + Character.toString(ch);

            // Change direction at top or bottom
            if (currentRow == 0 || currentRow == numOfRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

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
}
