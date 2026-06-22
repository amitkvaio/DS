package com.leetcode;

import java.util.Arrays;
import java.util.Iterator;

public class Height {
	public static void main(String[] args) {
		int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
		int height1[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(trap(height1));
	}
	
	public static int trap(int[] height) {
        int n = height.length;
        int [] left = new int [n];
        int [] right = new int [n];

        left[0] = height[0];
        for(int i = 1; i < n ; i ++){
            left[i] = Math.max( left[i-1], height[i]);
        }
        System.out.println(Arrays.toString(left));
        right[n-1] = height[n-1];
        for(int i = n-2; i >=0;i--){
            right[i] = Math.max(right[i + 1], height[i]);
        }
        System.out.println(Arrays.toString(right));

        int max = 0;
        for(int i = 0; i < n ; i ++){
            max = max + Math.min( left[i], right[i]) - height[i];
        }
        return max;
    }
}
