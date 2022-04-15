package com.interview;

class Base{
	int number;
	public Base(int i) {
		number=i;
	}
}
public class Child extends Base {

	int count;
	Child(int count,int num){
		super(num);
		this.count=count;
	}
	
	public Child(int i) {
		super(i);
		
	}

}
