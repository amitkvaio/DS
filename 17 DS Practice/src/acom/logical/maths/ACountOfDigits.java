package acom.logical.maths;

public class ACountOfDigits {
	public static void main(String[] args) {
		int nums = 00000;
		System.out.println(getCount(nums));
		System.out.println(getCount_(nums));
	}
	
	public static int getCount(int nums) {
		return nums == 0 ? 0 : String.valueOf(nums).length();
	}
	// TC=SC = O(1)
	
	public static int getCount_(int nums) {
		int counts = 0;
		while(nums!=0) {
			nums = nums/10;
			counts++;
		}
		return counts;
	}
	//O(N)
	//SC(1)
}
