package ecom.binarySearchTree;

public class HFindMinimumElementInSortedRotatedArray {
	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
		int minimum = findMinimumElement(arr);
		 System.out.println("Minimum element is: " + minimum);
	}

	public static int findMinimumElement(int[] arr) {
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
		return arr[left]; // left or right now points to the minimum element
	}
}
/*
arr = {4, 5, 6, 7, 0, 1, 2}
Left	Mid	Right		Condition						Move Left/Right
0		3	6		arr[mid] (7) > arr[right] (2)		left = mid + 1
4		5	6		arr[mid] (1) < arr[right] (2)		right = mid
4		4	5		arr[mid] (0) < arr[right] (1)		right = mid

Time Complexity: O(log N) (Binary Search)
Space Complexity: O(1) (No extra space used)


Follow-up Questions

What if the array has duplicate elements?
    Modify binary search to handle cases like {3, 3, 1, 3}.
    Instead of if(arr[mid] > arr[right]), check if(arr[mid] == arr[right]) right--;.

What if the array is not rotated?
    The minimum is simply arr[0].

Can we find the number of rotations from the minimum index?
    Yes! The index of the minimum element gives the rotation count.

*/