package leet.code.problem;

// https://leetcode.com/problems/longest-common-prefix/
public class C {
	public static void main(String[] args) {
		String[] strArr = { "java2blog", "javaworld", "javabean", "javatemp" };
		String longestPrefix = getLongestCommonPrefix(strArr);
		System.out.println("Longest Prefix : " + longestPrefix);
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
	
	
	 public static String longestCommonPrefix(String[] strs) {
	        
			String ans = "";
			if (strs.length == 0)
				return "";

			int endIndex = 0;
	        
			String s = getMinString(strs); /// return min string
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < strs.length; j++) {
					if (s.charAt(i) != strs[j].charAt(i)) {
						return ans;
					}
				}
				endIndex = i;
			}
			return s.substring(0, endIndex);
	        
	        /*
		 string ans = "";
	        if(strs.size()==0) return "";
	        
	        string s = strs[0]; 
	        
	        for(int i=0;i<s.size();i++){
	            for(int j=1;j<strs.size();j++){
	                if(i>=strs[j].size() || s[i] != strs[j][i]){
	                    return ans;
	                }
	            }
	            ans.push_back(s[i]);
	        }
	        return ans;
	        */
	        
	    }
	
}
/*
TC O(n*m) 
where
n : total number of string in the array
m : length of the smallest string

Space complexity : O(n)

*/
