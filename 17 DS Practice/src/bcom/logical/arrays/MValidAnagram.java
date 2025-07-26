package bcom.logical.arrays;

import java.util.Arrays;

public class MValidAnagram {
	public static void main(String[] args) {
		System.out.println(checkValidAnagram("cars", "rcas"));
	}
	
	public static boolean checkValidAnagram(String str1, String str2) {
		int [] ch = new int[27];

		for (int i = 0; i < str1.length(); i++) {
			ch[str1.charAt(i) - 'a']++;
		}

		System.out.println(Arrays.toString(ch));

		for (int i = 0; i < str1.length(); i++) {
			ch[str2.charAt(i) - 'a']--;
		}
		System.out.println(Arrays.toString(ch));
		
		for(int c : ch) {
			if(c!=0) {
				return false;
			}
		}
		return true;
	}
}
/*
TC: O(n)
SC : o(n)

*/