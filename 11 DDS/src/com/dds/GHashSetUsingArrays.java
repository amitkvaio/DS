package com.dds;

public class GHashSetUsingArrays {
	
	int [] arr;
	
	public GHashSetUsingArrays() {
		arr = new int[1000001];
	}
	
	public void add(int key) {
		arr[key] = 1 ;
	}
	
	public void remove(int key) {
		arr[key] = 0;
	}
	
	public boolean contains(int key) {
		if(arr[key]==1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		GHashSetUsingArrays myHashSet  = new GHashSetUsingArrays();
		myHashSet.add(1);      // set = [1]
		myHashSet.add(2);      // set = [1, 2]
		System.out.println(myHashSet.contains(1)); // return True
		System.out.println(myHashSet.contains(3)); // return False, (not found)
		myHashSet.add(2);      // set = [1, 2]
		System.out.println(myHashSet.contains(2)); // return True
		myHashSet.remove(2);   // set = [1]
		System.out.println(myHashSet.contains(2)); // return False, (already removed)
	}
}
/*
https://leetcode.com/problems/design-hashset/description/
Leetcode 705

*/