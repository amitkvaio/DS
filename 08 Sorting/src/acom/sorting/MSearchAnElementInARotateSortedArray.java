package acom.sorting;

public class MSearchAnElementInARotateSortedArray {
	public static int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == target)
				return mid;

			// Left half is sorted
			if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			// Right half is sorted
			else {
				if (nums[mid] < target && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1; // target not found
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;

		int index = search(nums, target);
		System.out.println("Index of target: " + index);
	}
}
/*

You are given a sorted array which has been rotated at some unknown pivot, and a target value. 
You need to return the index of the target if it exists, otherwise return -1.

Input:
nums = [4,5,6,7,0,1,2], target = 0
Output:
4

Input:
nums = [4,5,6,7,0,1,2], target = 3
Output:
-1

Explanation (Step-by-step)
***************************
    Check middle element.
    Determine which half is sorted:
        If nums[low] <= nums[mid], the left half is sorted.
        Else, the right half is sorted.
    Narrow your search to the half where the target could exist.
    
    
Time and Space Complexity
**************************
    Time Complexity: O(log n) → Efficient binary search
    Space Complexity: O(1) → No extra space used
*/
