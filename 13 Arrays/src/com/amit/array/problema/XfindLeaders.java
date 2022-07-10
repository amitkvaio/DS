package com.amit.array.problema;
/*


Find leaders in an array
arr[]={14, 12, 70, 15, 99, 65, 21, 90}
Here 99 and 90 are leader elements

An element is leader if it is greater than all the elements to its right side. 
And the rightmost element is always a leader. 
For example in the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2. 
https://java2blog.com/introduction-to-complexity-of-algorithm/
*/
public class XfindLeaders {
	public static void main(String[] args) {
		int arr[] = { 14, 12, 70, 15, 99, 65, 21, 90 };
		findLeadersInAnArrayBruteForce(arr);
		System.out.println("\n==================");
		findLeadersInAnArray(arr);
	}

	//Time complexity : o(N^2)
	public static void findLeadersInAnArrayBruteForce(int arr[]) {
		System.out.println("Finding leaders in an array using brute force : ");
		for (int i = 0; i < arr.length; i++) {
			boolean isLeader = true;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] <= arr[j]) {
					isLeader = false;
					break;
				}
			}
			if (isLeader)
				System.out.print(arr[i] + " ");
		}
	}

	//Time complexity : o(N)
	public static void findLeadersInAnArray(int arr[]) {
		System.out.println("Finding leaders in an array : ");
		int rightMax = arr[arr.length - 1];
		// Rightmost will always be a leader
		System.out.print(rightMax + " ");
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > rightMax) {
				rightMax = arr[i];
				System.out.print(" " + rightMax);
			}
		}
	}
}
