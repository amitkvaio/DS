package leet.code.general;
/*
Zig-Zag convesion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
	(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

*/
public class K {
	public static void main(String[] args) {
		String str ="PAYPALISHIRING";
		zigZagConversion(str, 3);
		zigZagConversion("A", 1);
	}
	
	public static void zigZagConversion(String str, int numOfRows) {
		String[] strArr = new String[numOfRows];
		for (int i = 0; i < strArr.length; i++) {
			strArr[i]="";
		}
		
		int row = 0;
		int step = 1;

		for (int i = 0; i < str.length(); i++) {
			strArr[row] = strArr[row] + Character.toString(str.charAt(i));
			if (row == 0) {
				step = 1;
			} else if (row == numOfRows - 1) {
				step = -1;
			}
			row = row + step;
		}
		String result ="";
		for (int i = 0; i < strArr.length; i++) {
			result = result+strArr[i];
		}
		//System.out.println(result.replaceAll("null", ""));
		System.out.println(result);
	}
}
