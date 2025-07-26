package bcom.logical.arrays;

public class DMajorityElements {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(findMajorityElements(arr));
		System.out.println(findMajorityElements(new int[] {1,5,5}));
		System.out.println(findMajorityElements(new int[] {1,1,2,2,2,2,3,3,3}));
	}

	private static Object findMajorityElements(int[] arr) {
		// Step 1: Find a candidate
		int count = 0;
		Integer major = null;
		
		for (int i = 0; i < arr.length; i++) {
			if (count == 0) {
				major = arr[i];
			}

			if (major == arr[i]) {
				count++;
			} else {
				count--;
			}
		}

		// Step 2: Verify the candidate
		count = 0;
		for (int num : arr) {
			if (num == major) {
				count++;
			}
		}
		major = count > arr.length / 2 ? major : null;
		return (major != null ? major : "None");
	}
	
}

/*
Note: An element is called a majority element if it appears more than n/2 times.

*/