// Search a number in the given list using binary search algorithm
package ecom.binarySearchTree;

import java.util.Arrays;
/*
Search an elements in the given array using binary search tree
*/
public class ABinarySearch {
	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50,60,70,80,90,100};
		//System.out.println("Given Arrays : "+Arrays.toString(arr));
		Arrays.sort(arr);
		//System.out.println("After Sort : "+Arrays.toString(arr));
		int index = binarySearch(arr, arr.length, 30);
		if(index>=0) {
			System.out.println("Number is present at index values :"+index);
		}else {
			System.out.println("Sorry!! Given number is not present in the list.");
		}
	}
	//[6, 7, 8, 9, 10, 15, 20, 30, 40]
	public static int binarySearch(int[] arr, int size, int searchValue) {
		int startIdx, endIdx, mid;
		startIdx = 0;
		endIdx = size - 1;
		while (startIdx <= endIdx) {
			mid = (startIdx + endIdx) / 2;
			if (arr[mid] == searchValue) {
				return mid;
			} else if (arr[mid] < searchValue) {
				startIdx = mid + 1;
			} else if (arr[mid] > searchValue) {
				endIdx = mid - 1;
			}
		}
		return -1;
	}
}
/*
complexity of binary search is log(n)
*/