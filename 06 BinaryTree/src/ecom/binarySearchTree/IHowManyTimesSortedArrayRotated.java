package ecom.binarySearchTree;
/*
How Many times sorted array has rotated
*/
public class IHowManyTimesSortedArrayRotated {
	public static void main(String[] args) {
		int arr[] = { 40, 50, 60, 70, 80, 90, 100, 10, 20, 30 };
		int arr1[] = { 8, 9, 10, 2, 5, 6 };
		int index = getMiniEleIndex(arr, 0, arr.length);
		System.out.println(index);
	}
	
	
	public static int getMiniEleIndex(int[] arr, int low, int high) {
		int mid;
		high = high - 1;
		while (low < high) {
			mid = (low + high) / 2;
			if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		System.out.println("Total Number of rotation::" + (low));
		return arr[low];
	}
}
