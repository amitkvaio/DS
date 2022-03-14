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

class Stackk {
	int top;
	int size;
	int [] arr;
	int length;
	
	public Stackk(int size) {
		this.size = size;
		arr = new int[this.size];
		top =-1;
		length =0;
	}
	
	public boolean isStackEmpty() {
		return this.length==0;
	}
	
	public int getSizeOfTheElement() {
		return this.length;
	}
	
	public int getCapacity(){
		return this.size;
	}
	
	public void push(int values) {
		if(this.length==this.size-1) {
			System.out.println("Stack is over flow insertion is not possible!!");
			return;
		}else {
			arr[++top]=values;
			length++;
			System.out.println(values +" is inserted successfully!!");
		}
	}
	
	public int peek() {
		return arr[top];
	}
	
	public int pop() {
		int data = 0;
		if(isStackEmpty()) {
			System.out.println("Stack is under flow !! Deletion is not possible!!");
		}else {
			data = arr[top--];
			length--;
		}
		return data;
	}
}











