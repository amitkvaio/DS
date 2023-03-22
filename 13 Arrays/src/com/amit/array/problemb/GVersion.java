package com.amit.array.problemb;

/*
Find the given two version find the greater version
*/
public class GVersion {
	public static void main(String[] args) {
		String ver1 = "5.2.3";
		String ver2 = "5.2.3.2";
		int v1 = getInterger(ver1);
		int v2 = getInterger(ver2);
		if (v1 > v2) {
			System.out.println(ver1 + " Greater Version");
		} else {
			System.out.println(ver2 + " Greater Version");
		}
	}

	public static int getInterger(String str) {
		if (str.contains(".")) {
			str = str.replaceAll("\\.", "");
		}
		return Integer.parseInt(str);
	}
}
