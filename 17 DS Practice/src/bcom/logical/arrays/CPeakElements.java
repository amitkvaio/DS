package bcom.logical.arrays;

public class CPeakElements {
	
	public static void main(String[] args) {
		int[] arr = { 50, 10, 500, 100 };
		findAllPeaks(arr);
		System.out.println("*****");
		findAllPeaks(new int[] {10, 20, 15, 2, 23, 90, 67});
		System.out.println("##################################");
		findAllPeakUsingBinarySearch(arr);
		System.out.println("****");
		findAllPeakUsingBinarySearch(new int[] {10, 20, 15, 2, 23, 90, 67});
		
	}
	
	public static void findAllPeaks(int[] arr) {
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			boolean left = (i == 0) || arr[i] >= arr[i - 1];
			boolean right = (i == n - 1) || arr[i] >= arr[i + 1];

			if (left && right) {
				System.out.println("Peak Elements::" + arr[i]);
			}
		}
	}

	public static void findAllPeakUsingBinarySearch(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (arr[mid] > arr[mid + 1]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		System.out.println("Peak Elements:" + arr[low]);
	}
}
/*
What is a Peak Element?
A peak element in an array is an element that is not smaller than its neighbors.


Input: arr[] = {5, 10, 20, 15}
Output: 20
Explanation: 20 is greater than 10 and 15

Input: arr[] = {10, 20, 15, 2, 23, 90, 67}
Output: 20 or 90
Explanation: Both 20 and 90 are peak elements

-- It uses two pointers: low (starting from 0) and high (starting from the last index of the array).
-- The algorithm works by calculating the middle element (mid) and comparing it with its next element (arr[mid + 1]).
-- If the middle element is greater than the next, it means the peak might be to the left, so it moves the high pointer to mid.
-- If the middle element is smaller than or equal to the next element, it moves the low pointer to mid + 1.
-- The process repeats until low equals high, which will point to a peak element.
-- Finally, the peak element is printed.

*/