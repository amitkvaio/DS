package acom.recursion.intermediate;

public class ACheckArraysIsSortedOrNot {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 2, 3, 5, 4 };
		System.out.println(isArraySorted1(arr1, 0));
		System.out.println(isArraySorted2(arr2, arr2.length));
		System.out.println(isArraySorted3(arr1, arr1.length));
		System.out.println("Done");
	}

	public static boolean isArraySorted1(int arr[], int start) {
		if (start == arr.length - 1)
			return true;

		if (arr[start] <= arr[start + 1])
			return isArraySorted1(arr, start + 1);
		else
			return false;
	}

	//Recursive function to check if it
	//is in sorted order or not
	public static boolean isArraySorted2(int arr[], int n){
	   //all elements are checked and
	   //all are in sorted order
	   if (n == 1 || n == 0)
	      return true;
	   //when an array is not in sorted order
	   if(arr[n-1] < arr[n-2])
	      return false;
	   
	   return isArraySorted2(arr, n-1);
	}
	
	private static boolean isArraySorted3(int[] array, int n) {
		if (n == 1 || n == 0)
			return true;
		for (int i = 1; i < n; i++) {
			if (array[i] < array[i - 1])
				return false;
		}
		return true;
	}
}
