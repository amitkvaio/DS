package com.problem.soving01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountNoOfOccurence {
	public static void main(String[] args) {

		String str = "JavaExamplesJavaCodeJavaProgram";
		String strFind = "Java";
		countWordOccurrence(str, strFind);
		countNo(str, strFind);
		countString(str, strFind);
	}

	public static void countWordOccurrence(String str, String strFind) {
		int count = 0, fromIndex = 0;
		while ((fromIndex = str.indexOf(strFind, fromIndex)) != -1) {
			count++;
			fromIndex++;
		}
		System.out.println("Total occurrences: " + count);
	}

	public static void countNo(String str, String strFind) {
		int count = str.split(strFind, -1).length;
		System.out.println("Total occurrences: " + (count - 1));
	}

	public static void countString(String str, String strFind) {
		int count = 0, startIndex = 0;
		Pattern p = Pattern.compile("Java");
		Matcher m = p.matcher(str);
		while (m.find(startIndex)) {
			count++;
			startIndex = m.start() + 1;
		}
		System.out.println("Total occurrences: " + count);
	}
}