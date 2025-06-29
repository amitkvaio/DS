package acom.sorting;

public class JPeakElement {
	public static void main(String[] args) {
		int[] arr = { 50, 10, 500, 100 };
		 
		findPeakElementsUsingBinarySearch(new int[] { 10, 20, 15, 2, 23, 90, 67 });
		System.out.println("##################################");
		findPeakElementsUsingBinarySearch(arr);
	}
 
	public static void findPeakElementsUsingBinarySearch(int[] arr) {
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

TC : O(logn)
SC : 0(1)

*/