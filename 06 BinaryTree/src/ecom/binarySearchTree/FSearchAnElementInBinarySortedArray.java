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
		int start = 0;
		int end = size - 1;
		int mid = -1;
		while (start <= end) {
			mid = (start + end)/2;
			if (arr[mid] == target) {
				return mid;
			}  
			if(arr[start] <=arr[mid]) {
				if(target >=arr[start]&& target <=arr[mid]) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}else {
				if(target >=arr[mid] && target <=arr[end]) {
					start = mid +1;
				}else {
					end  = mid-1;
				}
			}
		} 
		return mid;
	}
	
	
}
