package acom.stack.array;

public class Test {
	public static void main(String[] args) {
		
		int arr[] = {10,5,100,1,99,85,34,26,45,999,90,2};
		int min=arr[0],max=arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if(min > arr[i]) {
				min =arr[i];
			}
			
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		System.out.println("Min:"+min);
		System.out.println("max :"+max);
		
		
		System.out.println("ok");
	}
}
