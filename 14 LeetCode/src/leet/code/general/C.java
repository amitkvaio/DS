package leet.code.general;

// https://leetcode.com/problems/longest-common-prefix/
public class C {
	public static void main(String[] args) {
		String[] strArr = { "java2blog", "javaworld", "javabean", "javatemp" };
		String longestPrefix = getLongestCommonPrefix(strArr);
		System.out.println("Longest Prefix : " + longestPrefix);
		System.out.println("\n****************************");
		String longPre = longestCommonPrefix_(strArr);
		System.out.println(longPre);
	}

	public static String getLongestCommonPrefix(String[] strArr) {
		if (strArr.length == 0)
			return "";
		// Find minimum length String
		String minStr = getMinString(strArr);

		int minPrefixStrLength = minStr.length();
		for (int i = 0; i < strArr.length; i++) {
			int j;
			for (j = 0; j < minPrefixStrLength; j++) {
				if (minStr.charAt(j) != strArr[i].charAt(j))
					break;
			}
			if (j < minPrefixStrLength)
				minPrefixStrLength = j;
		}
		return minStr.substring(0, minPrefixStrLength);
	}

	public static String getMinString(String[] strArr) {
		String minStr = strArr[0];
		for (int i = 1; i < strArr.length; i++) {
			if (strArr[i].length() < minStr.length())
				minStr = strArr[i];
		}
		return minStr;
	}
	
	
	 public static String longestCommonPrefix_(String[] strs) {
			String s = getMinString(strs); /// return min string
			char [] output = new char[s.length()];
			int k=0;
			boolean flag = false;
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < strs.length; j++) {
					if (s.charAt(i) == strs[j].charAt(i)) {
						flag = true;
					}else {
						flag = false;
						break;
					}
				}
				if(flag) {
					output[k++]=s.charAt(i);
				}
				
			}
			return new String(output);
	    }
	
}
/*
TC O(n*m) 
where
n : total number of string in the array
m : length of the smallest string

Space complexity : O(n)

*/
