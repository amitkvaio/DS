package ecom.binarySearchTree;
/*
How Many times sorted array has rotated.
find the number of rotations from the minimum index.
*/
public class IHowManyTimesSortedArrayRotated {
	public static void main(String[] args) {
		int arr[] = { 40, 50, 60, 70, 80, 90, 100, 10, 20, 30 };
		int arr1[] = { 8, 9, 10, 2, 5, 6 };
		int index = findTotalRotationCount(arr);
		System.out.println(index);
	}
	public static int findTotalRotationCount(int[] arr) {
		int left = 0, right = arr.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			// If mid element is greater than rightmost element, move right
			if (arr[mid] > arr[right]) {
				left = mid + 1;
			} else {
				// Otherwise, move left
				right = mid;
			}
		}
		System.out.println("Total Number of rotation::" + (left));
		return arr[left]; // left or right now points to the minimum element
	}
}
