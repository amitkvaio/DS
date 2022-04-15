package acom.sorting;

import java.util.Arrays;

public class Testt {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 8, 12, 15, 6, 3, 9, 5, 7 };
		// bubbleSort(arr);
		//selectionSort(arr);
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr) {
		int size = arr.length;
		int j, temp;
		
		for (int i = 1; i < size; i++) {
			j = i;
			temp = arr[j];
			while(j>0 && arr[j-1] >temp ) {
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=temp;
		}
		
	}

	private static void selectionSort(int[] arr) {
		int size = arr.length;
		boolean isSwapped = true;
		for (int i = 0; i < size; i++) {
			int minimum = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[minimum] > arr[j]) {
					minimum = j;
					isSwapped=false;
				}
			}
			
			if(isSwapped) {
				break;
			}
			
			int temp = arr[i];
			arr[i] = arr[minimum];
			arr[minimum]=temp;
			
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void bubbleSort(int[] arr) {
		int size = arr.length;
		boolean isSwapped = true;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 1; j < size - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					isSwapped = false;
				}

			}
			if (isSwapped) {
				break;
			}
		}

	}
}
