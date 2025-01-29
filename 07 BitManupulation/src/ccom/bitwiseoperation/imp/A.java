package ccom.bitwiseoperation.imp;

//How to find ith bit of a number?
public class A {
	public static void main(String[] args) {
		int num = 8;//1000
				//	  3210 , 3rd bit of binary of 8 is 1
		int ithBit = 3;
		int result = (num >> ithBit) & 1;
		System.out.println(result);
		System.out.println("**************************");
		
		
		System.out.println("************************");
		System.out.println((8 >> 0) &1);//0
		System.out.println((8 >> 1) &1);//0
		System.out.println((8 >> 2) &1);//0
		System.out.println((8 >> 3) &1);//1
	}
}
