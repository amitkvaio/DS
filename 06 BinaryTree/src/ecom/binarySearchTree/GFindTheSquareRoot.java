package ecom.binarySearchTree;
//https://leetcode.com/problems/sqrtx/
/*
TC : O(logn)
SC : O(1)
*/
public class GFindTheSquareRoot {
	public static void main(String[] args) {
		int num = 50;
		int squarRoot =  getSquareRoot(num);
		int sqr = getSquareRoot1(num);
	
		System.out.println("SquareRoof of "+num +" is::"+squarRoot);
		System.out.println("SquareRoof of "+num +" is::"+sqr);
	}
	
	public static int getSquareRoot(int num) {
		int start = 1;
		int end = num;
		int mid;
		int ans = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (mid * mid == num) {
				return mid;
			}
			if (mid * mid < num) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}
	
	public static int getSquareRoot1(int num) {
		int start = 1;
		int end = num;
		int mid;
		int ans = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (mid == num / mid) {
				return mid;
			}
			if (mid < num / mid) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}
}
