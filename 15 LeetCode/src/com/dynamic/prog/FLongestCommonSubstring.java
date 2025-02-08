package com.dynamic.prog; 
/*
Longest common Substring
************************
Given two strings ‘X’ and ‘Y’, find the longest common substring. 
input : X = “GeeksforGeeks”, y = “GeeksQuiz” 
Output : 5 
Explanation:
The longest common substring is “Geeks” and is of length 5.

Input : X = “abcdxyz”, y = “xyzabcd” 
Output : 4 
Explanation:
The longest common substring is “abcd” and is of length 4.

Input : X = “zxabcdezy”, y = “yzabcdezx” 
Output : 6 
Explanation:
The longest common substring is “abcdez” and is of length 6.

String 1: Java2blog
String 2: CoreJavaTutorial
Longest common subString is: Java

*/
public class FLongestCommonSubstring {
	public static void main(String[] args) {
		String str1 = "Java2blog";
		String str2 = "CoreJavaTutorial";
		System.out.println("String 1: " + str1);
		System.out.println("String 2: " + str2);
		System.out.println("Longest common subString is: " + getLongestCommonSubstring(str1, str2));
	}

	public static String getLongestCommonSubstring(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int max = 0;
		int[][] dp = new int[m][n];
		int endIndex = -1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					// If first row or column
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						// Add 1 to the diagonal value
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
					if (max < dp[i][j]) {
						max = dp[i][j];
						endIndex = i;
					}
				}
			}
		}
		// We want String upto endIndex, we are using endIndex+1 in substring.
		return str1.substring(endIndex - max + 1, endIndex + 1);
	}
}


/*
Dynamic programming solution

You can solve this problem with the help of dynamic programming.Here is simple algorithm.

    Initialize 2D array of m*n named “dp”
    Iterate over str1 in outer loop(Using i)
    Iterate over str2 in inner loop(Using j)
    If str.charAt(i) == str2.charAt(j)
        If i or j=0 then put dp[i][j] = 1
        If i !=0 and j!=0
            dp[i][j] = dp[i-1][j-1] + 1
    Keep the track of max and endIndex in process
    Find substring with the help of endIndex and max.



*/