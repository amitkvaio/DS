package com.amit.array;

import java.util.Arrays;

public class Array04 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(arr));
		int rotateCount = 3;
		for (int i = 0; i < rotateCount; i++) {
			leftRotate(arr);
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void leftRotate(int[] arr) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			System.out.println("Before::"+Arrays.toString(arr));
			arr[i-1]=arr[i];
			System.out.println("After:::"+Arrays.toString(arr));
			System.out.println("*******************");
		}
		arr[arr.length-1]=temp;
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>"+Arrays.toString(arr));
	}
	
	private static void leftRotate(int[] arr,int rotateCount) {
		int temp = arr[0];
		for (int i = 1; i < rotateCount; i++) {
			arr[i-1]=arr[i];
		}
		arr[arr.length-1]=temp;
	}
	
	//TO-do
	public static void rotateUsingTempAarry(int[]arr,int rotateCount){
		int tempArr[] = new int[rotateCount];
		for (int i = 0; i < tempArr.length; i++) {
			tempArr[i]=arr[i];
			
		}
	}
	
}

/*

METHOD 1 (Using temp array) 

Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7
1) Store the first d elements in a temp array
   temp[] = [1, 2]
2) Shift rest of the arr[]
   arr[] = [3, 4, 5, 6, 7, 6, 7]
3) Store back the d elements
   arr[] = [3, 4, 5, 6, 7, 1, 2]

Time complexity : O(n) 
Auxiliary Space : O(d)

METHOD 2 (Rotate one by one)  

leftRotate(arr[], d, n)
start
  For i = 0 to i < d
    Left rotate all elements of arr[] by one
end

To rotate by one, store arr[0] in a temporary variable temp, move arr[1] to arr[0], arr[2] to arr[1] 
and finally temp to arr[n-1]
Let us take the same example arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2 
Rotate arr[] by one 2 times 
We get [2, 3, 4, 5, 6, 7, 1] after first rotation and [ 3, 4, 5, 6, 7, 1, 2] after second rotation.
Below is the implementation of the above approach 


*/