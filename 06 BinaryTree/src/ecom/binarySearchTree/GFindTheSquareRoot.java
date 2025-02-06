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
		int startIdx = 1;
		int endIdx = num;
		int mid;
		int squareRoot = -1;
		while (startIdx <= endIdx) {
			mid = startIdx + (endIdx - startIdx) / 2;
			if (mid * mid == num) {
				return mid;
			}
			if (mid * mid < num) {
				squareRoot = mid;
				startIdx = mid + 1;
			} else {
				endIdx = mid - 1;
			}
		}
		return squareRoot;
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
