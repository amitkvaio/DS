package ecom.binarySearchTree;

public class HFindMinimumElementInSortedRotatedArray {
	public static void main(String[] args) {
		int arr[] = { 40, 50, 60, 70, 80, 90, 100, 10, 20, 30 };
		int minimum = findMinimumElement(arr, arr.length);
		System.out.println("Index::"+minimum);
	}

	private static int findMinimumElement(int[] arr, int length) {
		int start = 0;
		int end = length-1;
		int minimum = Integer.MAX_VALUE;
		while(start<=end){
			int mid = start + (end -start)/2;
			if(arr[mid] < minimum)
				minimum =arr[mid];
			if(minimum >=arr[mid]) {
				end = mid -1;
			}else {
				start = mid +1;
			}
		}
		return minimum;
	}
}
