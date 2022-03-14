package acom.single;

import java.util.regex.Pattern;

public class Test1 {
	public static void main(String[] args) {
		vowelConsonantCount("amitkumar");
	}
	
	public static void vowelConsonantCount(String str) {
		char[] ch = str.toCharArray();
		int vowelCount =0;
		int consoNantCount=0;
		for (char c : ch) {
			if(Pattern.matches("[aeiouAEIOU]", Character.toString(c))) {
				vowelCount++;	
			}else {
				consoNantCount++;
			}
		}
		System.out.println(vowelCount);
		System.out.println(consoNantCount);
	}
}
