package ecom.binarySearchTree;
/*
How Many times sorted array has rotated.
find the number of rotations from the minimum index.
*/
public class IHowManyTimesSortedArrayRotated {
	public static void main(String[] args) {
		int arr[] = { 40, 50, 60, 70, 80, 90, 100, 10, 20, 30 };
		int arr1[] = { 8, 9, 10, 2, 5, 6 };
		int index = findTotalRotationCount(arr1);
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
/*

To determine how many times a sorted array has been rotated, we need to find the index of the minimum element (pivot) in a sorted rotated array.
Key Observations:

    The number of rotations is equal to the index of the minimum element.
    If the array is not rotated, the minimum element is at index 0, meaning 0 rotations.
    The minimum element is the only one smaller than its previous element.
    
Time Complexity: O(log N) (Binary search)
Space Complexity: O(1) (No extra space used)
*/