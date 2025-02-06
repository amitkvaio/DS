package ecom.binarySearchTree;
/*
/// https://leetcode.com/problems/search-in-rotated-sorted-array/
TC : O(n)
SC : O(1)
*/
public class FSearchAnElementInBinarySortedArray {
	public static void main(String[] args) {
		int arr[] = { 40, 50, 60, 70, 80, 90, 100, 10, 20, 30 };
		int target = 20;
		int index = searchAnElementInSortedArray(arr, arr.length, target);
		System.out.println("Index::"+index);
	}
	
	public static int searchAnElementInSortedArray(int[] arr, int size, int target) {
		int startIdx = 0;
		int endIdx = size - 1;
		int mid = -1;
		while (startIdx <= endIdx) {
			mid = (startIdx + endIdx)/2;
			if (arr[mid] == target) {
				return mid;
			}  
			if(arr[startIdx] <=arr[mid]) {
				if(target >=arr[startIdx]&& target <=arr[mid]) {
					endIdx = mid-1;
				}else {
					startIdx = mid+1;
				}
			}else {
				if(target >=arr[mid] && target <=arr[endIdx]) {
					startIdx = mid +1;
				}else {
					endIdx  = mid-1;
				}
			}
		} 
		return mid;
	}
}
