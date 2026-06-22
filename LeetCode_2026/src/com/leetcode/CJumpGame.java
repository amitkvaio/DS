package com.leetcode;

public class CJumpGame {
	public static void main(String[] args) {
		System.out.println(canJump(new int [] {2,3,1,1,4}));
		System.out.println(canJump(new int [] {3,2,1,0,4}));
		System.out.println(canJump(new int [] {2}));
		System.out.println(canJump(new int [] {0,2}));
		System.out.println(canJump(new int [] {1,2}));
	}
	
	public static boolean canJump(int [] jumpArr) {
		int n = jumpArr.length;
		int reach = 0;
		
		
		if(n == 1) {
			return true;
		}
		for (int i = 0 ; i < n ; i++) {
			reach = i + jumpArr[i];
			if(reach == n - 1) {
				return true;
			}
		}
		return false;
	}
}
