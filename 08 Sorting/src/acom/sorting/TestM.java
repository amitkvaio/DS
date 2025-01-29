package acom.sorting;

import java.util.Arrays;

public class TestM {
	public static void main(String[] args) {
		int [] arr = new int[] {10,8,2,4,3,1,7,6};
		mergeSort(arr);
	}
	
	
	public static void mergeSort(int[] arr) {
		int len = arr.length;
		if(len < 2) {
			return;
		}
		
		int mid = len /2;
		
		int leftAr[] = new int[mid];
		int rightAr[] = new int[len-mid];
		for(int i =0 ; i < mid ; i ++) {
			leftAr[i] = arr[i];
		}
		for (int j = mid ; j < len ; j ++) {
			rightAr[j-mid] = arr[j];
		}
		System.out.println("Left Arr ::" + Arrays.toString(leftAr));
		System.out.println("Right Arr ::" + Arrays.toString(rightAr));
		mergeSort(leftAr);
		System.out.println("*********************************");
		mergeSort(rightAr);
		merge(leftAr,rightAr, arr);
	}


	private static void merge(int[] leftAr, int[] rightAr, int[] arr) {
		int lenleftAr = leftAr.length;
		int lenrightAr = rightAr.length;
		
		int i =0 , j =0 , k = 0 ;
		
		while(i < lenleftAr && j < lenrightAr) {
			if(leftAr[i] < rightAr[j]) {
				arr[k++] =leftAr[i++];
			}else {
				arr[k++] = rightAr[j++];
			}
		}
		
		for(; i < lenleftAr ; i++) {
			arr[k++] =leftAr[i];
		}
		
		for(; j< lenrightAr; j++) {
			arr[k++] = rightAr[j];
		}
		
		System.out.println("After sort :: " + Arrays.toString(arr));
	}
}
