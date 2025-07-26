package acom.sorting;

public class EInversionCountMergeSort  {
	public static void main(String[] args) {
		int[] A = new int[] { 7, 8, 9, 1, 2, 3 };
		countInversion(A);
		System.out.println("############################");
		int count = countInversions(A);
	    System.out.println("Total number of inversion pairs: " + count);
	}

	// TC: O(N²) and SC : o (1)
	public static void countInversion(int[] A) {
		int count = 0;

		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j]) {
					count++;
					System.out.println("Inversion pair: (" + A[i] + "," + A[j] + ")");
				}
			}
		}
		System.out.println("Total number of inversion pairs: " + count);
	}

	// TC : O(N log N) and SC : O(N)
	public static int countInversions(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		return mergeSortAndCount(arr, 0, arr.length - 1);
	}

	private static int mergeSortAndCount(int[] arr, int left, int right) {
		int count = 0;
		if (left < right) {
			int mid = left + (right - left) / 2;
			count += mergeSortAndCount(arr, left, mid);
			count += mergeSortAndCount(arr, mid + 1, right);
			count += mergeAndCount(arr, left, mid, right);
		}
		return count;
	}

	private static int mergeAndCount(int[] arr, int left, int mid, int right) {
		int[] leftArray = new int[mid - left + 1];
		int[] rightArray = new int[right - mid];

		for (int i = 0; i < leftArray.length; i++)
			leftArray[i] = arr[left + i];

		for (int j = 0; j < rightArray.length; j++)
			rightArray[j] = arr[mid + 1 + j];

		int i = 0, j = 0, k = left, swaps = 0;

		while (i < leftArray.length && j < rightArray.length) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k++] = leftArray[i++];
			} else {
				arr[k++] = rightArray[j++];
				swaps += (leftArray.length - i); // Count inversions
			}
		}

		while (i < leftArray.length)
			arr[k++] = leftArray[i++];

		while (j < rightArray.length)
			arr[k++] = rightArray[j++];

		return swaps;
	}
}


/*
Find the number of ordered pairs (i, j) such that i < j and A[i] > A[j] — 
	you're essentially being asked to count the number of inversions in the array.
Efficient Merge Sort-based method (O(N log N)) and O(N) space for temporary arrays
*/